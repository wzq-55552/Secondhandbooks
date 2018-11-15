package com.example.hasee.second_handbooks.nav_item_activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hasee.second_handbooks.ApplyExchangeActivity;
import com.example.hasee.second_handbooks.Myneedsitem_itemActivity;
import com.example.hasee.second_handbooks.R;

/*
点击我的收藏item跳到的页面
 */

public class MycollectionitemActivity extends AppCompatActivity {

    public static final String MESSAGE_BOOKNAME  = "book_name";
    public static final  String MESSAGE_TIME = "time";
    public static final  String MESSAGE_LOCATION = "location";
    public static final  String MESSAGE_REMARK = "remark";

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycollectionitem);

        final Intent intent1 = getIntent();
        String MessageBookName = intent1.getStringExtra(MESSAGE_BOOKNAME);
        String MessageTime = intent1.getStringExtra(MESSAGE_TIME);
        String MessageLocation = intent1.getStringExtra(MESSAGE_LOCATION);
        String MessageRemark = intent1.getStringExtra(MESSAGE_REMARK);

        //把值赋予显示出来
        TextView messageContentBookname = (TextView) findViewById(R.id.mycollectionitem_bookname);
        TextView messageContentTime = (TextView) findViewById(R.id.mycollectionitem_time);
        TextView messageContentLocation = (TextView) findViewById(R.id.mycollectionitem_location);
        TextView messageContentRemark = (TextView) findViewById(R.id.mycollectionitem_remark);
        messageContentBookname.setText(MessageBookName);
        messageContentTime.setText(MessageTime);
        messageContentLocation.setText(MessageLocation);
        messageContentRemark.setText(MessageRemark);

        Toolbar toolbar = (Toolbar)findViewById(R.id.mycollectionitem_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }

        //交换按钮
        button = (Button)findViewById(R.id.mycollectionitem_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"确定交换？",Snackbar.LENGTH_SHORT)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //跳到填写信息申请界面
                                Intent intent = new Intent(MycollectionitemActivity.this,ApplyExchangeActivity.class);
                                startActivity(intent);
                            }
                        }).show();
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

    //返回键功能
    public void back(View view) {
        finish();
    }
}
