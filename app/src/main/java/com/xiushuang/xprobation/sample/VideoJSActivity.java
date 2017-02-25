package com.xiushuang.xprobation.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.EditText;

import com.xiushuang.xprobation.R;

import java.io.IOException;
import java.io.InputStreamReader;

public class VideoJSActivity extends AppCompatActivity {
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

        try {
            InputStreamReader fileInput = new InputStreamReader(getAssets().open("web/videojs.html"));

//            webView.loadDataWithBaseURL();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
