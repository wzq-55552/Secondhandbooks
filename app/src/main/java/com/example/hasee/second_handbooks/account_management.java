package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class account_management extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management);
    }

    //返回键功能
    public void back(View view) {
        Intent intent = new Intent(account_management.this,UserActivity.class);
        startActivity(intent);
        finish();
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
