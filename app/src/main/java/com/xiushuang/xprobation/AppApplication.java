package com.xiushuang.xprobation;

import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by Mac on 17/2/25.
 */

public class AppApplication extends android.app.Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

}
