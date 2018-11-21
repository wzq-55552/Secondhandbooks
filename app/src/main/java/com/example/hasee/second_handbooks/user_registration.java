package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class user_registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

    }

    //注册功能(半成品)
    public void register(View view) {
        EditText userTelephone = findViewById(R.id.register_telephone);
        EditText userPassword = findViewById(R.id.register_password);
        final Long telephone = Long.parseLong(userTelephone.getText().toString());
        final String password = userPassword.getText().toString();
        Intent intent = new Intent(user_registration.this, perfect_information.class);
        intent.putExtra("telephone", telephone);
        intent.putExtra("password", password);
        startActivity(intent);
        finish();
    }

    //返回键功能
    public void back(View view) {
        Intent intent = new Intent(user_registration.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void get_verification_code(View view) {
    }
}
