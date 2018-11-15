package com.example.hasee.second_handbooks;

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
        finish();
    }
}
