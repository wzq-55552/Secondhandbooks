package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class change_sex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_sex);
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

    //返回键功能
    public void back(View view) {
        finish();
    }
}
