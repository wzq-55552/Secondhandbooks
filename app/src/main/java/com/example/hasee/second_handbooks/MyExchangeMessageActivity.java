package com.example.hasee.second_handbooks;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MyExchangeMessageActivity extends AppCompatActivity {

    public static final String MESSAGE_BOOKNAME  = "book_name";
    //public static final  String MESSAGE_TIME = "time";
    //public static final  String MESSAGE_LOCATION = "location";
    public static final  String MESSAGE_REMARK = "remark";

    private FloatingActionButton item_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_exchange_message);


        /*final Intent intent1 = getIntent();
        String MessageBookName = intent1.getStringExtra(MESSAGE_BOOKNAME);
        String MessageRemark = intent1.getStringExtra(MESSAGE_REMARK);

        //把值赋予显示出来
        TextView messageContentBookname = (TextView) findViewById(R.id.myneeds_fragment_item_bookname);
        TextView messageContentRemark = (TextView) findViewById(R.id.myneeds_fragment_item_remark);
        messageContentBookname.setText(MessageBookName);
        messageContentRemark.setText(MessageRemark);*/

        //悬浮按钮拨打对方实现
        item_fab = (FloatingActionButton)findViewById(R.id.myexchange_message_fab);
        item_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyExchangeMessageActivity.this,ApplyExchangeActivity.class);
                startActivity(intent);
            }
        });


    }




    //返回键功能
    public void back(View view) {
        finish();
    }
}
