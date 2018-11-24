package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class account_management extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management);

        Toolbar toolbar = (Toolbar)findViewById(R.id.account_management_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home://点击了返回，结束该活动，返回上一个活动
                Intent intent = new Intent(account_management.this,UserActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //修改学号
    public void change_number(View view) {
        Intent intent = new Intent(account_management.this,change_number.class);
        startActivity(intent);
        finish();
    }


    //修改手机号
    public void change_phone(View view) {
        Intent intent = new Intent(account_management.this,change_phone.class);
        startActivity(intent);
        finish();
    }

    //修改密码
    public void change_password(View view) {
        Intent intent = new Intent(account_management.this,change_password.class);
        startActivity(intent);
        finish();
    }
}
