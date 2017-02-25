package com.xiushuang.xprobation.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

import com.xiushuang.xprobation.R;


//腾讯X5浏览器服务
public class X5WebViewSDK extends AppCompatActivity implements View.OnClickListener {

    WebView x5WV;
    EditText inputET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x5_web_view_sdk);
        x5WV = (WebView) findViewById(R.id.x5_webview);
        inputET = (EditText) findViewById(R.id.x5wv_input_et);
        findViewById(R.id.x5wv_go_btn).setOnClickListener(this);
        initX5WebView();
    }

    private void initX5WebView() {

    }

    @Override
    public void onClick(View v) {

    }

}
