package com.example.hasee.second_handbooks.nav_item_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.hasee.second_handbooks.R;

public class SystemSetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_setup);

    }

    //反馈，弄个好看，里面不用去实现功能
    public void feedback(View view){
        Intent intent = new Intent(SystemSetupActivity.this,FeedbackActivity.class);
        startActivity(intent);
    }



    //返回键功能
    public void back(View view) {
        finish();
    }
}
