package com.example.hasee.second_handbooks.nav_item_activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.hasee.second_handbooks.R;

public class SystemSetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_setup);
        Toolbar toolbar = (Toolbar)findViewById(R.id.system_setup_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }

    }

    //反馈，弄个好看，里面不用去实现功能
    public void feedback(View view){
        Intent intent = new Intent(SystemSetupActivity.this,FeedbackActivity.class);
        startActivity(intent);
        finish();
    }

    //关于我们
    public void We(View view){
        Intent intent = new Intent(SystemSetupActivity.this,WeActivity.class);
        startActivity(intent);
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
