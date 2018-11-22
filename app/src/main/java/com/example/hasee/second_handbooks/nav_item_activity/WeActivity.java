package com.example.hasee.second_handbooks.nav_item_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.hasee.second_handbooks.R;

public class WeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we);
    }

    //返回键功能
    public void back(View view) {
        finish();
    }
}
