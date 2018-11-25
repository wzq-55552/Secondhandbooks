package com.example.hasee.second_handbooks;


import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.hasee.second_handbooks.nav_item_activity.MycollectionActivity;
import com.example.hasee.second_handbooks.nav_item_activity.RecordActivity;
import com.example.hasee.second_handbooks.nav_item_activity.RecordAdapter;
import com.example.hasee.second_handbooks.nav_item_activity.SystemSetupActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String localhost = "https://0fe5e943.ngrok.io";

    private DrawerLayout mDrawerLayout;

    private TabLayout tab;

    private ViewPager mVp;

    private List<String> titles;

    private List<Fragment> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        tab = (TabLayout)findViewById(R.id.tab);
        mVp = (ViewPager)findViewById(R.id.pager);

        //标题
        titles = new ArrayList<>();
        titles.add("主页");
        titles.add("我的");

        //数据源
        data  = new ArrayList<>();
        data.add(new MyFragment01());
        data.add(new MyFragment02());

        //设置模式
        tab.setTabMode(TabLayout.MODE_FIXED);

        //添加名称
        tab.addTab(tab.newTab().setText(titles.get(0)));
        tab.addTab(tab.newTab().setText(titles.get(1)));

        mVpAdapter adapter = new mVpAdapter(getSupportFragmentManager(),titles,data);
        mVp.setAdapter(adapter);
        //Tab与ViewPager绑定
        tab.setupWithViewPager(mVp);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);//传入
        ActionBar actionBar = getSupportActionBar();//获得实例，ActionBar实例可以用来代替Toolbar
        NavigationView navView = (NavigationView)findViewById(R.id.na_view);

        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//显示
            actionBar.setHomeAsUpIndicator(R.drawable.head1);//传入滑动菜单的按钮图标
        }

        //滑动菜单的实现
        navView.setCheckedItem(R.id.nav_1);//默认选中
        navView.setItemIconTintList(null);

//        //字体颜色
//        int[][] states = new int[][]{
//
//                new int[]{android.R.attr.state_activated}, // enabled
//                new int[]{android.R.attr.state_active}, // disabled
//                new int[]{android.R.attr.state_checked}, // unchecked
//                new int[]{android.R.attr.state_focused}, // pressed
//                new int[]{android.R.attr.state_enabled}, // enabled
//                new int[]{-android.R.attr.state_enabled}, // disabled
//                new int[]{-android.R.attr.state_checked}, // unchecked
//                new int[]{android.R.attr.state_pressed}  // pressed
//        };
//        int[] colors = new int[]{
//                Color.BLACK,
//                Color.GRAY,
//                Color.GRAY,
//                Color.GRAY,
//                Color.BLACK,
//                Color.BLACK,
//                Color.BLACK,
//                Color.GRAY
//        };
//        ColorStateList colorStateList = new ColorStateList(states,colors);
//        navView.setItemTextColor(colorStateList);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {//监听器，相应逻辑
                switch (menuItem.getItemId()){
                    case R.id.nav_1:
                        Intent intent1 = new Intent(MainActivity.this,MycollectionActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_2:
                        Intent intent2 = new Intent(MainActivity.this,RecordActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_3:
                        /*Intent intent3 = new Intent(MainActivity.this,InformationActivity.class);
                        startActivity(intent3);*/
                        break;
                    case R.id.nav_4:
                        Toast.makeText(MainActivity.this,"暂无客服",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_5:
                        Intent intent5 = new Intent(MainActivity.this,SystemSetupActivity.class);
                        startActivity(intent5);
                        break;
                    default:
                        break;
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        //搜索按钮监听
        Button search = (Button) findViewById(R.id.main_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home://Toolbar按钮最左侧的按钮，就是滑动菜单的这个按钮默认都是这个id
                mDrawerLayout.openDrawer(GravityCompat.START);//显示
                break;
            default:
        }
        return true;
    }

//    按钮按下判断
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        按下返回键调用双击判断函数
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            ExitByTwoClick();
        }
        return false;
    }

//    双击判断函数
    private static Boolean isExit = false;
    private void ExitByTwoClick() {
        Timer tExit = null;
        if (!isExit) {
            Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);
        } else {
            finish();
        }
    }

    //点击首页悬浮按钮跳转AddMsgActivity
    public void main_fab(View view) {
        Intent intent = new Intent(MainActivity.this,AddMsgActivity.class);
        startActivity(intent);
    }

    //跳转个人中心
    public void login(View view) {
        Intent intent = new Intent(MainActivity.this,UserActivity.class);
        mDrawerLayout.closeDrawers();
        startActivity(intent);
    }

}