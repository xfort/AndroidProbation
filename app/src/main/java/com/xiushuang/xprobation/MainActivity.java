package com.xiushuang.xprobation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.xiushuang.xprobation.sample.VideoJSActivity;
import com.xiushuang.xprobation.sample.XCrossWalkActivity;
import com.xiushuang.xprobation.utils.AdapterItemListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView menuRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();

        initRecycleView();
    }

    private void findView() {
        menuRecyclerView = (RecyclerView) findViewById(R.id.main_menu_recyclerview);

    }


    private void initRecycleView() {
        ArrayList<MenuItem> menuData = new ArrayList<>(10);

        menuData.add(new MenuItem(R.id.menu_videojs, "VideoJS,Web播放器"));
        menuData.add(new MenuItem(R.id.menu_crosswalk, "CrossWalk"));
        menuData.add(new MenuItem(R.id.menu_x5, "腾讯X5"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        menuRecyclerView.setLayoutManager(linearLayoutManager);

        MainMenuRecyclerAdapter adapter = new MainMenuRecyclerAdapter();
        adapter.dataList.addAll(menuData);
        adapter.setAdapterListener(new AdapterItemListener<MenuItem>() {
            @Override
            public void onItemListener(View view, int index, MenuItem obj, Message msg) {
                menuClick(view, index, obj, msg);
            }
        });

        menuRecyclerView.setAdapter(adapter);
    }

    private void menuClick(View view, int index, MenuItem obj, Message msg) {
        Log.d("MainAct", "menuClick()_" + obj.title);
        if (obj == null) {
            return;
        }

        switch (obj.id) {
            case R.id.menu_videojs:
                startVideoJS();
                break;
            case R.id.menu_crosswalk:
                startCrossWalk();
                break;
            case R.id.menu_x5:
                break;
        }
    }

    private void startVideoJS() {
        Intent intent = new Intent(this, VideoJSActivity.class);
        startActivity(intent);
    }

    private void startCrossWalk() {
        Intent intent = new Intent(this, XCrossWalkActivity.class);
        startActivity(intent);
    }
}
