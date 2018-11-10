package com.example.hasee.second_handbooks;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasee.second_handbooks.BaseClass.ExchangeMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MyFragment01 extends Fragment {

    Context mContext;


    private ExchangeMessage[] exchangeMessages = {
            new ExchangeMessage("第一行代码","11月09日11点",
                    "旭日楼","本人吴，该书作者郭霖，570页，第二版，学编程安卓入门的第一书")
    };

    private List<ExchangeMessage> exchangeMessagesList = new ArrayList<>();

    private ExchangeMeAdapter adapter;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, container, false);

        initMessages();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);//每一行有1个元素
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ExchangeMeAdapter(exchangeMessagesList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initMessages(){//随机存入数据
        exchangeMessagesList.clear();

    }


    //刷新数据
    private void refreshMessages(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);//停留2秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {//切换为主线程
                    @Override
                    public void run() {
                        //初始数据
                        initMessages();
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }


}



