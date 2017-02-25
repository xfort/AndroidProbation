package com.xiushuang.xprobation;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by Mac on 17/2/21.
 */

public class MainMenuView extends RelativeLayout {
    public Button titleBtn;

    public MainMenuView(Context context) {
        this(context, null);
    }

    public MainMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MainMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MainMenuView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.main_menu_item, this);
        titleBtn = (Button) findViewById(R.id.menu_title_tv);
    }
}

