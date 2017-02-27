package com.xiushuang.xprobation;

import android.os.Message;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.xiushuang.xprobation.utils.AdapterItemListener;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Mac on 17/2/21.
 */

public class MainMenuRecyclerAdapter extends RecyclerView.Adapter<MainMenuVH> {

    ArrayList<MenuItem> dataList;
    AdapterItemListener<MenuItem> adapterItemListener;

    public MainMenuRecyclerAdapter() {
        dataList = new ArrayList<>(20);
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public MainMenuVH onCreateViewHolder(ViewGroup parent, int viewType) {
        MainMenuView menuView = new MainMenuView(parent.getContext());
        MainMenuVH menuVH = new MainMenuVH(menuView);
        menuVH.setListener(new AdapterItemListener<MenuItem>() {
            @Override
            public void onItemListener(View view, int index, MenuItem obj, Message msg) {
                if (adapterItemListener != null) {
                    adapterItemListener.onItemListener(view, index, dataList.get(index), null);
                }
            }
        });
        return menuVH;
    }

    @Override
    public void onBindViewHolder(MainMenuVH holder, int position) {
        MainMenuView menunView = (MainMenuView) holder.itemView;
        menunView.titleBtn.setText(dataList.get(position).title);
    }

    public void setAdapterListener(AdapterItemListener<MenuItem> adapterListener) {
        adapterItemListener = adapterListener;
    }
}


class MainMenuVH extends RecyclerView.ViewHolder implements View.OnClickListener {

    AdapterItemListener<MenuItem> adapterListener;

    public MainMenuVH(View itemView) {
        super(itemView);
        ((MainMenuView)itemView).titleBtn.setOnClickListener(this);
//        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int index = getAdapterPosition();
        if (adapterListener != null) {
            adapterListener.onItemListener(v, index, null, null);
        }
    }


    public void setListener(AdapterItemListener<MenuItem> adapterListener) {
        this.adapterListener = adapterListener;
    }
}