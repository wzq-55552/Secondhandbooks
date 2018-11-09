package com.example.hasee.second_handbooks;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.hasee.second_handbooks.BaseClass.ExchangeMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//我的需求点击进去的页面
public class MyNeedsActivity extends AppCompatActivity {

    private List<ExchangeMessage> exchangeMessagesList = new ArrayList<>();

    private MyneedsMessageAdapter adapter;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_needs);

        //初始化数据



        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.myneeds_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyneedsMessageAdapter adapter = new MyneedsMessageAdapter(exchangeMessagesList);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home://点击了返回，结束该活动，返回上一个活动
                finish();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
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
                MyNeedsActivity.this.runOnUiThread(new Runnable() {//切换为主线程
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
