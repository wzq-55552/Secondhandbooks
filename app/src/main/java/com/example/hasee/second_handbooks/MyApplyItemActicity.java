package com.example.hasee.second_handbooks;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hasee.second_handbooks.nav_item_activity.MycollectionitemActivity;


public class MyApplyItemActicity extends AppCompatActivity {


    //判断申请状态碎片显示
    private int isState=1;

    public static final String MESSAGE_BOOKNAME2  = "book_name2";
    public static final  String MESSAGE_TIME2 = "time2";
    public static final  String MESSAGE_LOCATION2 = "location2";
    public static final  String MESSAGE_REMARK2 = "remark2";

    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_myapplyitem);

        Toolbar toolbar = (Toolbar)findViewById(R.id.myapply_item_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }

        final Intent intent1 = getIntent();
        String MessageBookName = intent1.getStringExtra(MESSAGE_BOOKNAME2);
        String MessageTime = intent1.getStringExtra(MESSAGE_TIME2);
        String MessageLocation = intent1.getStringExtra(MESSAGE_LOCATION2);
        String MessageRemark = intent1.getStringExtra(MESSAGE_REMARK2);

        //把值赋予显示出来
        TextView messageContentBookname = (TextView) findViewById(R.id.myapply_item_bookname);
        TextView messageContentTime = (TextView) findViewById(R.id.myapply_item_time);
        TextView messageContentLocation = (TextView) findViewById(R.id.myapply_item_location);
        TextView messageContentRemark = (TextView) findViewById(R.id.myapply_item_remark);
        messageContentBookname.setText(MessageBookName);
        messageContentTime.setText(MessageTime);
        messageContentLocation.setText(MessageLocation);
        messageContentRemark.setText(MessageRemark);

        //取消交换按钮
        button1 = (Button)findViewById(R.id.myapply_item_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"取消交换？",Snackbar.LENGTH_SHORT)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //跳到取消交换界面，留言给物主之类

                            }
                        }).show();
            }
        });

        //查看自己交换书籍的按钮
        button2 = (Button)findViewById(R.id.myapply_item_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyApplyItemActicity.this,MyExchangeMessageActivity.class);
                startActivity(intent);
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
