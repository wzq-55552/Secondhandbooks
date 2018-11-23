package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class change_nickname extends AppCompatActivity {

    private EditText change_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_nickname);

        Toolbar toolbar = (Toolbar)findViewById(R.id.change_nickname_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }

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
