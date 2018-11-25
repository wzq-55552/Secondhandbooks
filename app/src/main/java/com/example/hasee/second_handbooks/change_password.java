package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.hasee.second_handbooks.MainActivity.localhost;

public class change_password extends AppCompatActivity {

    private static final String URL = localhost +  "/user/change_password";

    private String change_password;

    //UI声明
    private EditText original_password_view;
    private EditText change_password_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        //设置界面
        original_password_view = findViewById(R.id.original_password);
        change_password_view = findViewById(R.id.change_password);

        Toolbar toolbar = findViewById(R.id.change_password_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }
    }

    private boolean isOriginalPasswordValid(String password) {
        String true_password = "123456";//迟点读取文件实现
        return password.equals(true_password);
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() >= 6;
    }

    //获取欲修改的昵称给上一个活动
    public void submit(View view) {
        String original_password = original_password_view.getText().toString();
        change_password = change_password_view.getText().toString();
        if (!isOriginalPasswordValid(original_password)) {
            Toast.makeText(change_password.this, "原密码错误", Toast.LENGTH_SHORT).show();
        } else if (!isPasswordValid(change_password)) {
            Toast.makeText(change_password.this, "修改后的密码长度过短", Toast.LENGTH_SHORT).show();
        } else {
            Change_password();
        }
    }

//    修改密码
    private void Change_password() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("number", "1714080902110")//迟点读取文件实现
                            .add("password", change_password)
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
                    Toast.makeText(change_password.this, "修改密码成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent().putExtra("password", change_password);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(change_password.this, "修改密码失败", Toast.LENGTH_SHORT).show();
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
