package com.example.hasee.second_handbooks;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//确认交换页面点击碎片查看信息

public class Myneedsitem_itemActivity extends AppCompatActivity {

    public static final String MESSAGE_BOOKNAME  = "book_name";
    public static final  String MESSAGE_TIME = "time";
    public static final  String MESSAGE_LOCATION = "location";
    public static final  String MESSAGE_REMARK = "remark";

    private FloatingActionButton item_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myneedsitem_item);


        final Intent intent1 = getIntent();
        String MessageBookName = intent1.getStringExtra(MESSAGE_BOOKNAME);
        String MessageTime = intent1.getStringExtra(MESSAGE_TIME);
        String MessageLocation = intent1.getStringExtra(MESSAGE_LOCATION);
        String MessageRemark = intent1.getStringExtra(MESSAGE_REMARK);

        //把值赋予显示出来
        TextView messageContentBookname = (TextView) findViewById(R.id.myneeds_fragment_item_bookname);
        TextView messageContentTime = (TextView) findViewById(R.id.myneeds_fragment_item_time);
        TextView messageContentLocation = (TextView) findViewById(R.id.myneeds_fragment_item_location);
        TextView messageContentRemark = (TextView) findViewById(R.id.myneeds_fragment_item_remark);
        messageContentBookname.setText(MessageBookName);
        messageContentTime.setText(MessageTime);
        messageContentLocation.setText(MessageLocation);
        messageContentRemark.setText(MessageRemark);

        Toolbar toolbar = (Toolbar)findViewById(R.id.myneeds_fragment_item_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }

        //悬浮按钮拨打对方实现
        item_fab = (FloatingActionButton)findViewById(R.id.myneeds_fragment_item_fab);
        item_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"联系对方？",Snackbar.LENGTH_SHORT)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //打电话给对方，读取对方的手机号并拨打
                                //检查是否授权check
                                if(ContextCompat.checkSelfPermission(Myneedsitem_itemActivity.this, Manifest.permission.CALL_PHONE)
                                        != PackageManager.PERMISSION_GRANTED){//PackageManager.PERMISSION_GRANTED相等就是用户已经授权
                                    ActivityCompat.requestPermissions(Myneedsitem_itemActivity.this,new String[]{
                                            Manifest.permission.CALL_PHONE},1);//申请授权
                                }else{
                                    call();
                                }
                            }
                        }).show();
            }
        });


    }

    private void call(){
        try{
            Intent intent = new Intent(Intent.ACTION_CALL);//自动拨号,声明权限
            intent.setData(Uri.parse("tel:10086"));//获取电话资源？？？？？？？？
            startActivity(intent);
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {//授权条件
                    call();
                }else{
                    Toast.makeText(this,"您拒绝了权限授权！",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
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
