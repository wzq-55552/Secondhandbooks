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
import android.widget.Button;

import com.example.hasee.second_handbooks.db.ExchangeMessage;
import com.jauker.widget.BadgeView;

import java.util.ArrayList;
import java.util.List;


public class Fragment1Myapply extends Fragment {

    Context mContext;

    //滑动列表
    private List<ExchangeMessage> exchangeMessageList=new ArrayList<>();


    private SwipeRefreshLayout swipeRefreshLayout;

    private APCAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myapply, container, false);

        init();

        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.myapply_recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new APCAdapter(exchangeMessageList);
        recyclerView.setAdapter(adapter);

        //滑动刷新
        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.myapply_swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshAPC();
            }
        });
        //MsgSetTop();
        return view;
    }

    //初始化列表数据
    private void init(){
        ExchangeMessage a=new ExchangeMessage("例子1","54321","大约在冬季","没有");
        a.setBook_image_id(R.drawable.head);
        exchangeMessageList.add(a);

        ExchangeMessage b=new ExchangeMessage("例子2","54321","大约在冬季","没有");
        b.setBook_image_id(R.drawable.head);
        exchangeMessageList.add(b);

        ExchangeMessage c=new ExchangeMessage("例子3","54321","大约在冬季","没有");
        c.setBook_image_id(R.drawable.head);
        exchangeMessageList.add(c);
    }

    private void refreshAPC(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    /*//消息置顶
    public void MsgSetTop(){
        ExchangeMessage message=exchangeMessageList.get(2);
        exchangeMessageList.remove(message);
        exchangeMessageList.add(0,message);
        BadgeView badgeView=new com.jauker.widget.BadgeView(mContext);
        adapter.notifyDataSetChanged();
    }*/


}



