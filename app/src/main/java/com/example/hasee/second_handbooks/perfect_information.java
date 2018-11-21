package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class perfect_information extends AppCompatActivity {

//    显示位置声明
    private TextView perfectNumber;
    private TextView perfectNickname;
    private TextView perfectsex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfect_information);

//        显示位置id
        perfectNumber = findViewById(R.id.perfect_number_show);
        perfectNickname = findViewById(R.id.perfect_nickname_show);
        perfectsex = findViewById(R.id.perfect_sex_show);
    }

//    跳转改变学号活动获取学号
    public void perfect_number(View view) {
        Intent intent = new Intent(perfect_information.this, change_number.class);
        startActivityForResult(intent, 0);
    }

//    跳转改变昵称活动获取昵称
    public void perfect_nickname(View view) {
        Intent intent = new Intent(perfect_information.this, change_nickname.class);
        startActivityForResult(intent, 1);
    }

//    根据结果修改显示
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 0:
                if (resultCode == RESULT_OK) {
                    perfectNumber.setText(data.getStringExtra("number"));
                }
                break;
            case 1:
                if (resultCode == RESULT_OK) {
                    perfectNickname.setText(data.getStringExtra("nickname"));
                }
            default:
        }
    }

    //返回键功能
    public void back(View view) {
        finish();
    }

}
