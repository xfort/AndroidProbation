package com.xiushuang.xprobation.utils;

import android.webkit.JavascriptInterface;

/**
 * Created by Mac on 17/2/27.
 */

public class JSHandler {
    JSListener jsListener;

    @JavascriptInterface
    public void onMessage(String msg) {
        if (jsListener != null) {
            jsListener.onMesssage(msg);
        }
    }

    public void setListener(JSListener jsListener) {
        this.jsListener = jsListener;
    }
}
