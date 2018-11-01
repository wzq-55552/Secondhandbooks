package com.example.hasee.second_handbooks;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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


import java.util.ArrayList;
import java.util.List;

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddMsgActivity.class);
                startActivity(intent);
            }
        });

        Button search = (Button) findViewById(R.id.main_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}