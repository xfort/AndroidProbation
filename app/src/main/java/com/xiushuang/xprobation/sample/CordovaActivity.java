package com.xiushuang.xprobation.sample;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.xiushuang.xprobation.utils.CordovaWebViewHandler;

import org.apache.cordova.CordovaWebView;

public class CordovaActivity extends AppCompatActivity {

    CordovaWebView cordovaWebView;
    CordovaWebViewHandler wvHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initCordova();
        View wv = cordovaWebView.getView();
        wv.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout
                .LayoutParams.MATCH_PARENT));
        setContentView(wv);
    }

    private void initCordova() {
        wvHandler = new CordovaWebViewHandler();
        cordovaWebView = wvHandler.newCordovaWebView(this);

//        SystemWebView systemWV = (SystemWebView) findViewById(R.id.cordova_systemwv);
//        ConfigXmlParser parser = new ConfigXmlParser();
//        parser.parse(this);
//        cordovaWebView = new CordovaWebViewImpl(new SystemWebViewEngine(systemWV));
//        cordovaWebView.init(new CordovaInterfaceImpl(this), parser.getPluginEntries(), parser.getPreferences());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        wvHandler.onNewIntent(intent, cordovaWebView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        wvHandler.onStart(cordovaWebView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        wvHandler.onResume(cordovaWebView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wvHandler.onPause(cordovaWebView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        wvHandler.onStop(cordovaWebView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wvHandler.onDestroy(cordovaWebView);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        wvHandler.onConfigurationChanged(newConfig, cordovaWebView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        wvHandler.onCreateOptionsMenu(menu, cordovaWebView);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        wvHandler.onPrepareOptionsMenu(menu, cordovaWebView);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        wvHandler.onOptionsItemSelected(item, cordovaWebView);
        return super.onOptionsItemSelected(item);
    }


}