package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hasee.second_handbooks.nav_item_activity.MycollectionitemActivity;


public class MessageActivity extends AppCompatActivity {

    public static final String MESSAGE_BOOKNAME1  = "Book_name1";
    public static final  String MESSAGE_TIME1 = "Time1";
    public static final  String MESSAGE_LOCATION1 = "Location1";
    public static final  String MESSAGE_REMARK1 = "Remark1";


    private FloatingActionButton fab2;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        final Intent intent1 = getIntent();
        String MessageBookName = intent1.getStringExtra(MESSAGE_BOOKNAME1);
        String MessageTime = intent1.getStringExtra(MESSAGE_TIME1);
        String MessageLocation = intent1.getStringExtra(MESSAGE_LOCATION1);
        String MessageRemark = intent1.getStringExtra(MESSAGE_REMARK1);

        //把值赋予显示出来
        TextView messageContentBookname = (TextView) findViewById(R.id.message_bookname);
        TextView messageContentTime = (TextView) findViewById(R.id.message_time);
        TextView messageContentLocation = (TextView) findViewById(R.id.message_location);
        TextView messageContentRemark = (TextView) findViewById(R.id.message_remark);
        messageContentBookname.setText(MessageBookName);
        messageContentTime.setText(MessageTime);
        messageContentLocation.setText(MessageLocation);
        messageContentRemark.setText(MessageRemark);

        Toolbar toolbar = (Toolbar)findViewById(R.id.message_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }

        //交换按钮
        fab2 = (FloatingActionButton)findViewById(R.id.message_fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"申请本书？",Snackbar.LENGTH_SHORT)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //跳到填写信息申请界面
                                Intent intent = new Intent(MessageActivity.this,ApplyExchangeActivity.class);
                                startActivity(intent);
                            }
                        }).show();
            }
        });


        //收藏按钮
        fab = (FloatingActionButton)findViewById(R.id.message_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //收藏点击爱心变红，   数据保存到我的收藏
                fab.setImageResource(R.drawable.heart02);
                Toast.makeText(MessageActivity.this,"收藏成功！",Toast.LENGTH_SHORT).show();
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
