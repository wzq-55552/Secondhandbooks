package com.example.hasee.second_handbooks.nav_item_activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hasee.second_handbooks.R;

public class FeedbackActivity extends AppCompatActivity {
    //反馈，弄个好看，里面不用去实现功能,就这样

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        final EditText editText = (EditText)findViewById(R.id.feedback_edittext);
        Button button = (Button)findViewById(R.id.feedback_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FeedbackActivity.this, "提交成功！", Toast.LENGTH_SHORT).show();
                editText.getText().clear();
            }
        });


        Toolbar toolbar = (Toolbar)findViewById(R.id.feedback_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home://点击了返回，结束该活动，返回上一个活动
                Intent intent =new Intent(FeedbackActivity.this,SystemSetupActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

