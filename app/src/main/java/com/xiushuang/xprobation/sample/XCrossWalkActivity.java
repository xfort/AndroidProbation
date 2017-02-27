package com.xiushuang.xprobation.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.xiushuang.xprobation.R;

import org.xwalk.core.XWalkNavigationHistory;
import org.xwalk.core.XWalkView;

public class XCrossWalkActivity extends AppCompatActivity implements View.OnClickListener {

    XWalkView xWalkView;
    EditText inputET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xcross_walk);
        xWalkView = (XWalkView) findViewById(R.id.xwalk_wv);
        inputET = (EditText) findViewById(R.id.xwalk_input_et);
        findViewById(R.id.xwalk_go_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        xWalkView.loadUrl(inputET.getText().toString());
//        getSupportFragmentManager().beginTransaction().commitAllowingStateLoss()
    }

    @Override
    public void onBackPressed() {
        if (xWalkView != null && xWalkView.getNavigationHistory().canGoBack()) {
            xWalkView.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.BACKWARD, 1);
            return;
        }
        super.onBackPressed();
    }
}
