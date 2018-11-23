package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class change_sex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_sex);

        Toolbar toolbar = (Toolbar)findViewById(R.id.change_sex_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }
    }

    //性别男
    public void change_sex_male(View view) {
        Intent intent = new Intent();
        intent.putExtra("sex", "男");
        setResult(RESULT_OK, intent);
        finish();
    }

// 性别女
    public void change_sex_female(View view) {
        Intent intent = new Intent();
        intent.putExtra("sex", "女");
        setResult(RESULT_OK, intent);
        finish();
    }

//    性别保密
    public void change_sex_secrecy(View view) {
        Intent intent = new Intent();
        intent.putExtra("sex", "保密");
        setResult(RESULT_OK, intent);
        finish();
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
