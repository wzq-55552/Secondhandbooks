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

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        Toolbar toolbar = (Toolbar)findViewById(R.id.register_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }
    }

    //注册功能
    public void register(View view) {
        EditText userTelephone = findViewById(R.id.register_telephone);
        EditText userPassword = findViewById(R.id.register_password);
        String telephone = userTelephone.getText().toString();
        String password = userPassword.getText().toString();
        if(telephone.length() < 11 || password.length() < 6) {
            Toast.makeText(register.this, "手机号或密码错误",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(register.this, register_perfect_information.class);
            intent.putExtra("telephone", telephone);
            intent.putExtra("password", password);
            startActivity(intent);
            finish();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home://点击了返回，结束该活动，返回上一个活动
                Intent intent = new Intent(register.this,LoginActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void get_verification_code(View view) {
    }
}
