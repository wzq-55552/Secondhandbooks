package com.example.hasee.second_handbooks.nav_item_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hasee.second_handbooks.R;

public class FeedbackActivity extends AppCompatActivity {
    //反馈，弄个好看，里面不用去实现功能,就这样

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Button button = (Button)findViewById(R.id.feedback_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FeedbackActivity.this, "提交成功！", Toast.LENGTH_SHORT).show();
            }
        });


    }

    //返回键功能
    public void back(View view) {
        finish();
    }
}

