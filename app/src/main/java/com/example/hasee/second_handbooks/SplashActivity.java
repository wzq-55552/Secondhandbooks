package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
启动app前显示图片
可以了解怎样显示小视频
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //延迟2秒
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent  = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);//毫秒
    }
}