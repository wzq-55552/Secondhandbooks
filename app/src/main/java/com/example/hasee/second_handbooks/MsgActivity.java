package com.example.hasee.second_handbooks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
    }

    //返回键功能
    public void back(View view) {
        finish();
    }
}
