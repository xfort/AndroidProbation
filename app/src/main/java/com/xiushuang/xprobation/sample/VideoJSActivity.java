package com.xiushuang.xprobation.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.EditText;

import com.xiushuang.xprobation.R;
import com.xiushuang.xprobation.utils.JSHandler;
import com.xiushuang.xprobation.utils.JSListener;

import java.io.IOException;
import java.io.InputStreamReader;

public class VideoJSActivity extends AppCompatActivity {
    final String TAG = "VideoJSActivity";
    EditText videoUrlET;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_js);

        videoUrlET = (EditText) findViewById(R.id.videojs_url_et);
        webView = (WebView) findViewById(R.id.videojs_webview);

        initVideoJSHtml();
    }

    private void initVideoJSHtml() {
        JSHandler jsHandler = new JSHandler();
        jsHandler.setListener(new JSListener() {
            @Override
            public void onMesssage(String msg) {
                Log.d(TAG, "JSHandler()_onMesssage()" + msg);
            }
        });

        webView.addJavascriptInterface(jsHandler, "xjsHandler");
        webView.loadUrl("file:///android_assets/web/videojs.html");

//        try {
//            InputStreamReader fileInput = new InputStreamReader(getAssets().open("web/videojs.html"));
////          webView.loadDataWithBaseURL();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            webView.destroy();
        }
    }
}
