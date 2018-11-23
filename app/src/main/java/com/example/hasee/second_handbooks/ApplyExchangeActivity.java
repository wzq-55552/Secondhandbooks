package com.example.hasee.second_handbooks;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
/*
申请交换填写信息界面
 */

public class ApplyExchangeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_exchange);

        Toolbar toolbar = (Toolbar)findViewById(R.id.apply_exchange__toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }

        //提交键
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.apply_exchange_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "确定申请？", Snackbar.LENGTH_LONG)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(ApplyExchangeActivity.this,"申请成功！",Toast.LENGTH_SHORT);
                            }
                        }).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home://点击了返回，结束该活动，返回上一个活动
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
