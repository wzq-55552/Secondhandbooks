package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class change_number extends AppCompatActivity {

    private EditText change_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_number);

        Toolbar toolbar = (Toolbar)findViewById(R.id.change_number_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }

        change_number = (EditText) findViewById(R.id.change_number);
    }

    //获取欲修改的学号给上一个活动
    public void submit(View view) {
        String number = change_number.getText().toString();
        if (number.length() < 13) {
            Toast.makeText(change_number.this, "学号输入错误",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra("number", number);
            setResult(RESULT_OK, intent);
            finish();
        }
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
