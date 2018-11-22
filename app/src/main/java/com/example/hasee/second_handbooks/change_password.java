package com.example.hasee.second_handbooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class change_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
    }

    //返回键功能
    public void back(View view) {
        finish();
    }


    //提交修改的密码
    public void sure(View view) {
        finish();
    }
}
