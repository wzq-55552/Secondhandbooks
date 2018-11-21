package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class change_nickname extends AppCompatActivity {

    private EditText change_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_nickname);

        change_nickname = findViewById(R.id.change_nickname);
    }

    //获取欲修改的昵称给上一个活动
    public void submit(View view) {
        String nickname = change_nickname.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("nickname", nickname);
        setResult(RESULT_OK, intent);
        finish();
    }

    //返回键功能
    public void back(View view) {
        finish();
    }
}
