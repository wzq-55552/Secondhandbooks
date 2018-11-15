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

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class user_registration extends AppCompatActivity {

    static final String MY_URL = "";

    private static final String TAG = "user_registration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

    }

    //注册功能(test后端未实现)
    public void register(View view) {
        EditText userName = findViewById(R.id.register_username);
        EditText passWord = findViewById(R.id.register_password);
        final String username = userName.getText().toString();
        final String password = passWord.getText().toString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("register_username", username)
                            .add("register_password", password)
                            .build();
                    Request request = new Request.Builder()
                            .url(MY_URL)
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    Log.d(TAG, response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //返回键功能
    public void back(View view) {
        finish();
    }
}
