package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class change_telephone extends AppCompatActivity {

    private static final String URL = localhost +  "/user/change_telephone";

    private String telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_telephone);

        Toolbar toolbar = findViewById(R.id.change_phone_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }
    }

    //获取欲修改的手机号给上一个活动
    public void submit(View view) {
        EditText change_telephone = findViewById(R.id.change_telephone);
        telephone = change_telephone.getText().toString();
        Change_telephone();
        Intent intent = new Intent();
        intent.putExtra("telephone", telephone);
        setResult(RESULT_OK, intent);
        finish();
    }

    //    修改手机号
    private void Change_telephone() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("number", "1714080902110")//迟点读取文件实现
                            .add("telephone", telephone)
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
                    Toast.makeText(change_telephone.this, "修改手机号成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(change_telephone.this, "修改手机号失败", Toast.LENGTH_SHORT).show();
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
