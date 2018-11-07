package com.example.hasee.second_handbooks.BaseClass;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hasee.second_handbooks.APCAdapter;
import com.example.hasee.second_handbooks.R;

import java.util.ArrayList;
import java.util.List;

public class MyAPCActivity extends AppCompatActivity implements View.OnClickListener {

    //滑动列表
    private List<ExchangeMessage>exchangeMessageList=new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private APCAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_apc);
        init();
        Button back_button=(Button)findViewById(R.id.apc_back_button);
        back_button.setOnClickListener(this);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.apc_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new APCAdapter(exchangeMessageList);
        recyclerView.setAdapter(adapter);

        //滑动刷新
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.apc_swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshAPC();
            }
        });
    }

    //初始化列表数据
    private void init(){
        for(int i=0;i<20;i++)
        {
            ExchangeMessage a=new ExchangeMessage("例子1");
            a.setBook_image_id(R.drawable.head);
            a.setLocation("54321");
            a.setTime("大约在冬季");
            exchangeMessageList.add(a);
        }
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
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.apc_back_button:
                this.finish();
                break;
            default:
                break;
        }
    }
}
