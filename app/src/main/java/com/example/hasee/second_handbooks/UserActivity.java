package com.example.hasee.second_handbooks;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

//个人中心activity

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        Toolbar toolbar = findViewById(R.id.users_toolbar);
        setSupportActionBar(toolbar);//获得ToolBar实例
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//菜单，默认图片返回图片
        }

        //点击头像进入手机图库
        CircleImageView circleImageView = findViewById(R.id.users_icon_image);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从图库选图的intent
                Intent i1 = new Intent(Intent.ACTION_PICK);
                i1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");

                //从相机拍照的intent
                Intent i2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                File camerFile = new File(file,System.currentTimeMillis()+".jpg");
                Uri value = Uri.fromFile(camerFile);
                i2.putExtra(MediaStore.EXTRA_OUTPUT, value);

                //把俩个intent“凑成”一个intent发送
                Intent intent = Intent.createChooser(i1, "选择头像");
                intent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{i2});
                //把凑成的intent发送出去
                startActivityForResult(intent, 100);
            }
        });

    }

    //返回图片
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==RESULT_OK){
            if(data==null){
                //拍照返回的
            }else{
                //图库选择返回的
                //content://media/XXXX
                Uri uri = data.getData();
                //ivAvatar.setImageURI(uri);
                //要找到uri对应的文件在SD卡上的绝对路径
                //ContentResolver去数据库查询
                ContentResolver cr = getContentResolver();
                Cursor c = cr.query(uri, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
                c.moveToNext();
                String path = c.getString(0);
                c.close();
                Log.d("TAG", "uri:-->"+uri.toString()+", 绝对路径：-->"+path);
            }
        }
    }

    //跳转登录界面
    public void go_login(View view) {
        Intent intent = new Intent(UserActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    //跳转账号管理
    public void user_account_management(View view) {
        Intent intent = new Intent(UserActivity.this, account_management.class);
        startActivity(intent);
        finish();
    }

    //跳转修改昵称
    public void change_nickname(View view) {
        Intent intent = new Intent(UserActivity.this, change_nickname.class);
        startActivityForResult(intent, 0);
        finish();
    }

    //跳转修改性别
    public void change_sex(View view) {
        Intent intent = new Intent(UserActivity.this, change_sex.class);
        startActivityForResult(intent, 1);
        finish();
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        switch (resultCode) {
            case 0:
                if (resultCode == RESULT_OK) {
                    TextView nickname_show = findViewById(R.id.user_nickname_show);
                    String nickname = data.getStringExtra("nickname");
                    nickname_show.setText(nickname);
                }
                break;
            case 1:
                if (resultCode == RESULT_OK) {
                    TextView nickname_show = findViewById(R.id.user_sex_show);
                    String nickname = data.getStringExtra("sex");
                    nickname_show.setText(nickname);
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
