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

import com.example.hasee.second_handbooks.db.ExchangeMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//我的需求点击进去的页面

public class Fragment1Myneeds extends Fragment {

    Context mContext;

    private MyneedsMessageAdapter adapter;

    private ExchangeMessage[] Messages = {
            new ExchangeMessage("第一行代码","11月09日11点",
                    "旭日楼","本人吴，该书作者郭霖，570页，第二版，学编程安卓入门的第一书"),
            new ExchangeMessage("了不起的盖兹比","11月10日17点",
                    "少康楼","作者菲兹杰拉德，238页，很新的，我还没看过，可能适合小孩看的吧"),
            new ExchangeMessage("瓦尔登湖","11月11日20点",
                    "南苑宿舍","作者大卫-梭罗，280页，语语惊人，字字闪光，动我衷肠。到了夜深人静的时候，万籁俱寂之时，此书清澄见底。有多少人懂梭罗，就有多少人懂生活"),
   };

    private List<ExchangeMessage> exchangeMessagesList = new ArrayList<>();


    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myneeds, container, false);

        //初始化数据
        initMessages();

        RecyclerView recyclerView1 = (RecyclerView) view.findViewById(R.id.myneeds_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        recyclerView1.setLayoutManager(layoutManager);
        adapter = new MyneedsMessageAdapter(exchangeMessagesList);
        recyclerView1.setAdapter(adapter);

        //刷新
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.myneeds_swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);//进度条颜色
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshMessages();
            }
        });
        return view;
    }



    private void initMessages(){//随机存入数据
        exchangeMessagesList.clear();
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int index = random.nextInt(Messages.length);
            exchangeMessagesList.add(Messages[index]);
        }
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
                        initMessages();
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

}



