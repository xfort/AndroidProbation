package com.xiushuang.xprobation.utils;

import android.os.Message;
import android.view.View;



/**
 * Created by Mac on 17/2/24.
 */

public interface AdapterItemListener<T> {
    public void onItemListener(View view, int index, T obj,Message msg);
}
