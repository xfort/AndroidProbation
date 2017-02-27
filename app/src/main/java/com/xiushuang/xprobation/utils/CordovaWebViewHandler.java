package com.xiushuang.xprobation.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.view.Menu;
import android.view.MenuItem;

import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaInterfaceImpl;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewEngine;
import org.apache.cordova.CordovaWebViewImpl;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginManager;
import org.json.JSONException;

import java.util.Locale;

/**
 * 初始化CordovaWebView
 * Created by Mac on 17/2/27.
 */

public class CordovaWebViewHandler {

    final String TAG = "CordovaWebViewHandler";

    Activity activity;
    CordovaWebView cordovaWV;
    CordovaInterfaceImpl cordovaInterface;
    ConfigXmlParser configXmlParser;

    public CordovaWebView newCordovaWebView(Activity activity) {
        this.activity = activity;
        loadConfig();
        makeCordovaInterface();

        cordovaWV = makeWebView();
        CordovaPreferences cordovaPreferences = configXmlParser.getPreferences();

        if (!cordovaWV.isInitialized()) {
            cordovaWV.init(cordovaInterface, configXmlParser.getPluginEntries(), cordovaPreferences);
        }
        cordovaInterface.onCordovaInit(cordovaWV.getPluginManager());

        String volumePref = cordovaPreferences.getString("DefaultVolumeStream", "");
        if ("media".equals(volumePref.toLowerCase(Locale.ENGLISH))) {
            activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        }
        return cordovaWV;
    }

    private void loadConfig() {
        configXmlParser = new ConfigXmlParser();
        configXmlParser.parse(activity.getApplicationContext());
    }

    private CordovaInterface makeCordovaInterface() {
        CordovaInterfaceImpl cordovaInterface = new CordovaInterfaceImpl(activity) {
            @Override
            public Object onMessage(String id, Object data) {
                //TODO
                return super.onMessage(id, data);
            }
        };
        return cordovaInterface;
    }

    private CordovaWebView makeWebView() {
        CordovaWebViewEngine cordovaWVEngine = CordovaWebViewImpl.createEngine(activity, configXmlParser
                .getPreferences());
        return new CordovaWebViewImpl(cordovaWVEngine);
    }


    public void onNewIntent(Intent intent, CordovaWebView wv) {
        if (wv != null) {
            wv.onNewIntent(intent);
        }
    }

    public void onStart(CordovaWebView wv) {
        if (wv == null) {
            return;
        }
        wv.handleStart();
    }

    public void onResume(CordovaWebView wv) {
        if (wv == null) {
            return;
        }
        wv.handleResume(false);
    }

    public void onPause(CordovaWebView cordovaWV) {
        if (cordovaWV != null) {
            // CB-9382 If there is an activity that started for result and main activity is waiting for callback
            // result, we shoudn't stop WebView Javascript timers, as activity for result might be using them
//            boolean keepRunning = keepRunning || cordovaInterface.activityResultCallback != null;
            cordovaWV.handlePause(false);
        }
    }

    public void onStop(CordovaWebView wv) {
        if (wv == null) {
            return;
        }
        wv.handleStop();
    }

    public void onDestroy(CordovaWebView wv) {
        if (wv == null) {
            return;
        }
        wv.handleDestroy();
    }

    public void startActivityForResult(int requestCode) {
        if (cordovaInterface != null) {
            cordovaInterface.setActivityResultRequestCode(requestCode);
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (cordovaInterface != null) {
            cordovaInterface.onActivityResult(requestCode, resultCode, intent);
        }
    }

    public void onCreateOptionsMenu(Menu menu, CordovaWebView wv) {
        if (wv != null) {
            wv.getPluginManager().postMessage("onCreateOptionsMenu", menu);
        }
    }

    public void onPrepareOptionsMenu(Menu menu, CordovaWebView wv) {
        if (wv != null) {
            wv.getPluginManager().postMessage("onPrepareOptionsMenu", menu);
        }
    }

    public void onOptionsItemSelected(MenuItem item, CordovaWebView wv) {
        if (wv != null) {
            wv.getPluginManager().postMessage("onOptionsItemSelected", item);
        }
    }

    public void onConfigurationChanged(Configuration newConfig, CordovaWebView wv) {
        if (wv != null) {
            PluginManager pm = wv.getPluginManager();
            if (pm != null) {
                pm.onConfigurationChanged(newConfig);
            }
        }
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        try {
            cordovaInterface.onRequestPermissionResult(requestCode, permissions, grantResults);
        } catch (JSONException e) {
            LOG.d(TAG, "JSONException: Parameters fed into the method are not valid");
            e.printStackTrace();
        }
    }
}