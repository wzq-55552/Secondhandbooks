package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.hasee.second_handbooks.MainActivity.localhost;

public class change_nickname extends AppCompatActivity {

    private static final String URL = localhost +  "/user/change_nickname";

    private String nickname;

    private static boolean isRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_nickname);

        //判断是否注册调用
        Intent intent = getIntent();
        isRegister = intent.getBooleanExtra("isRegister", false);

        Toolbar toolbar = findViewById(R.id.change_nickname_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }
    }

    //获取欲修改的昵称给上一个活动
    public void submit(View view) {
        EditText change_nickname = findViewById(R.id.change_nickname);
        nickname = change_nickname.getText().toString();
        if (isRegister == false) {
            Change_nickname();
        } else {
            Intent intent = new Intent();
            intent.putExtra("nickname", nickname);
            setResult(RESULT_OK, intent);
            finish();
        }

    }

//    修改昵称
    private void Change_nickname() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("number", "1714080902110")//迟点读取文件实现
                            .add("nickname", nickname)
                            .build();
                    Request request = new Request.Builder()
                            .url(URL)
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = null;
                    if (response.body() != null) {
                        data = response.body().string();
                    }
                    showResult(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


    //显示结果UI操作
    private void showResult(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (data.equals("true")) {
                    Toast.makeText(change_nickname.this, "修改昵称成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.putExtra("nickname", nickname);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(change_nickname.this, "修改昵称失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
