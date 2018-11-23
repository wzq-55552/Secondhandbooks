package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hasee.second_handbooks.db.User;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class register_perfect_information extends AppCompatActivity {

    private static final String TAG = "register_perfect_inform";

    private static final String URL = "http://a447899372.vicp.cc:37091/user/register";

    User user = new User();

//    显示位置声明
    private TextView perfectNumber;
    private TextView perfectNickname;
    private TextView perfectSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfect_information);

        Toolbar toolbar = (Toolbar)findViewById(R.id.perfect_information_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }

        Intent intent = getIntent();
        Long telephone = Long.parseLong(intent.getStringExtra("telephone"));
        String password = intent.getStringExtra("password");
        user.setTelephone(telephone);
        user.setPassword(password);

//        显示位置id
        perfectNumber = findViewById(R.id.perfect_number_show);
        perfectNickname = findViewById(R.id.perfect_nickname_show);
        perfectSex = findViewById(R.id.perfect_sex_show);
    }

//    跳转改变学号活动获取学号
    public void perfect_number(View view) {
        Intent intent = new Intent(register_perfect_information.this, change_number.class);
        startActivityForResult(intent, 0);
    }

//    跳转改变昵称活动获取昵称
    public void perfect_nickname(View view) {
        Intent intent = new Intent(register_perfect_information.this, change_nickname.class);
        startActivityForResult(intent, 1);
    }

//    跳转改变性别活动获取性别
    public void perfect_sex(View view) {
        Intent intent = new Intent(register_perfect_information.this, change_sex.class);
        startActivityForResult(intent, 2);
    }

//    根据结果修改显示
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 0:
                if (resultCode == RESULT_OK) {
                    String number = data.getStringExtra("number");
                    perfectNumber.setText(number);
                    user.setNumber(Long.parseLong(number));
                }
                break;
            case 1:
                if (resultCode == RESULT_OK) {
                    String nickname = data.getStringExtra("nickname");
                    perfectNickname.setText(nickname);
                    user.setNickname(nickname);
                }
            case 2:
                if (resultCode == RESULT_OK) {
                    String sex = data.getStringExtra("sex");
                    perfectSex.setText(sex);
                    user.setSex(sex);
                }
            default:
        }
    }

    //提交
    public void submit(View view) {
        user.setHonesty(100L);
        register();
    }

    private void register() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("number", user.getNumber().toString())
                            .add("telephone", user.getTelephone().toString())
                            .add("nickname", user.getNickname())
                            .add("sex", user.getSex())
                            .add("password", user.getPassword())
                            .add("honesty", user.getHonesty().toString())
                            .build();
                    Log.d(TAG, "run: " + requestBody.toString());
                    Request request = new Request.Builder()
                            .url(URL)
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();
                    showResult(data);
                } catch (Exception e) {
                    Toast.makeText(register_perfect_information.this, "网络错误", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        }).start();
    }

    //显示结果UI操作
    private void showResult(final String data) {
        Log.d(TAG, "showResult: " + data);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (data.equals("true")) {
                    TextView nickname_show = (TextView) findViewById(R.id.user_nickname_show);
                    TextView sex_show = (TextView) findViewById(R.id.user_sex_show);
                    Toast.makeText(register_perfect_information.this, "注册成功", Toast.LENGTH_SHORT).show();
                    user.change_user_information(nickname_show, sex_show);
                    Intent intent = new Intent(register_perfect_information.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(register_perfect_information.this,"此学号已被注册，如有问题请联系客服",
                            Toast.LENGTH_SHORT).show();
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
