package com.example.hasee.second_handbooks;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.hasee.second_handbooks.MainActivity.localhost;


/**
 *手机号为账号，登陆界面，还有登陆后的界面，登陆前界面
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String URL =  localhost + "/user/login";

    // 登陆按钮
    Button logbtn;
    // 显示用户名和密码
    EditText telephone, password;

    // 创建等待框
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 获取控件
        telephone = findViewById(R.id.telephone);
        password = findViewById(R.id.password);
        logbtn = findViewById(R.id.login_button);


        // 设置按钮监听器
        logbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:

                if (isUserNameAndPwdValid()) {

                    // 检测网络，无法检测wifi
                    if (!checkNetwork()) {
                        Toast toast = Toast.makeText(LoginActivity.this,"网络未连接!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        break;
                    }

                    // 提示框
                    dialog = new ProgressDialog(this);
                    dialog.setTitle("提示");
                    dialog.setMessage("正在登陆，请稍后...");
                    dialog.setCancelable(false);
                    dialog.show();

                    // 创建子线程
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                OkHttpClient client = new OkHttpClient();
                                RequestBody requestBody = new FormBody.Builder()
                                        .add("number", telephone.getText().toString())
                                        .add("password", password.getText().toString())
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
                }else{
                    break;
                }
                break;
        }
    }

    //显示结果UI操作
    private void showResult(final String data) {
        dialog.dismiss();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (data.equals("true")) {
                    Intent intent  = new Intent(LoginActivity.this,UserActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this,"密码错误或者该手机号还未注册！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // 检测网络
    private boolean checkNetwork() {
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connManager != null;
        if (connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }


    //跳转注册页面
    public void user_register(View view) {
        Intent intent = new Intent(LoginActivity.this, register.class);
        startActivity(intent);
        finish();
    }

    //跳转忘记密码页面
    public void forget_password(View view) {
        Intent intent = new Intent(LoginActivity.this, forget_password.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home://点击了返回，结束该活动，返回上一个活动
                Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

   //判断用户名和密码是否有效
    public boolean isUserNameAndPwdValid() {// 用户名和密码不得为空
    if (telephone.getText().toString().equals("")||telephone.getText().toString().length()!=11) {
            Toast.makeText(this,"手机号格式错误！" ,
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.getText().toString().equals("")) {
            Toast.makeText(this, "密码不能为空！",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}

