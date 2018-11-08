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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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

        //字体颜色
        int[][] states = new int[][]{

                new int[]{android.R.attr.state_activated}, // enabled
                new int[]{android.R.attr.state_active}, // disabled
                new int[]{android.R.attr.state_checked}, // unchecked
                new int[]{android.R.attr.state_focused}, // pressed
                new int[]{android.R.attr.state_enabled}, // enabled
                new int[]{-android.R.attr.state_enabled}, // disabled
                new int[]{-android.R.attr.state_checked}, // unchecked
                new int[]{android.R.attr.state_pressed}  // pressed
        };
        int[] colors = new int[]{
                Color.BLACK,
                Color.GRAY,
                Color.GRAY,
                Color.GRAY,
                Color.BLACK,
                Color.BLACK,
                Color.BLACK,
                Color.GRAY
        };
        ColorStateList colorStateList = new ColorStateList(states,colors);
        navView.setItemTextColor(colorStateList);

        View headerView = navView.inflateHeaderView(R.layout.nav_header);
        //点击跳至个人中心
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UserActivity.class);
                startActivity(intent);
            }
        });
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {//监听器，相应逻辑
                switch (menuItem.getItemId()){
                    case R.id.nav_1:
                        /*Intent intent1 = new Intent(MainActivity.this,InformationActivity.class);
                        startActivity(intent1);
                        break;*/
                    case R.id.nav_2:
                        /*Intent intent2 = new Intent(MainActivity.this,InformationActivity.class);
                        startActivity(intent2);
                        break;*/
                    case R.id.nav_3:
                        /*Intent intent3 = new Intent(MainActivity.this,InformationActivity.class);
                        startActivity(intent3);
                        break;*/
                    case R.id.nav_4:
                        /*Intent intent4 = new Intent(MainActivity.this,InformationActivity.class);
                        startActivity(intent4);
                        break;*/
                    case R.id.nav_5:
                        /*Intent intent5 = new Intent(MainActivity.this,InformationActivity.class);
                        startActivity(intent5);*/
                        break;
                    default:
                        break;
                }
                return true;
            }
        });


        //点击悬浮按钮跳转AddMsgActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddMsgActivity.class);
                startActivity(intent);
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

}