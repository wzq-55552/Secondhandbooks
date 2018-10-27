package com.example.hasee.second_handbooks;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private TabLayout tab;

    private ViewPager mVp;

    private List<String> titles;

    private List<Fragment> data;
    
    private TextView textView;
    
    private boolean fabOpened = false;

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

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(),titles,data);
        mVp.setAdapter(adapter);
        //Tab与ViewPager绑定
        tab.setupWithViewPager(mVp);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//传入
        ActionBar actionBar = getSupportActionBar();//获得实例，ActionBar实例可以用来代替Toolbar
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);//显示导航按钮
        }
        
        //悬浮按钮功能的实现
        textView = (TextView)findViewById(R.id.cloud);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab!=null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fabOpened){
                    openMenu(view);
                }else{
                    closeMenu(view);
                }
            }
        });
        

    }
    
   public void openMenu(View view){
       ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",0,-155,-135);
       animator.setDuration(500);
       animator.start();
       textView.setVisibility(View.VISIBLE);
       AlphaAnimation alphaAnimation = new AlphaAnimation(0,0.7f);
       alphaAnimation.setDuration(500);
       alphaAnimation.setFillAfter(true);
       textView.startAnimation(alphaAnimation);
       fabOpened = true;
   }

    public void closeMenu(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",-135,20,0);
        animator.setDuration(500);
        animator.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.7f,0);
        alphaAnimation.setDuration(500);
        textView.startAnimation(alphaAnimation);
        textView.setVisibility(View.GONE);
        fabOpened = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);//加载菜单
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
                break;
            case android.R.id.home://Toolbar按钮最左侧的按钮，就是滑动菜单的这个按钮默认都是这个id
                mDrawerLayout.openDrawer(GravityCompat.START);//显示
                break;
            default:
        }
        return true;
    }
}

class MyAdapter extends FragmentPagerAdapter {

    List<String>list;
    List<Fragment>fragments = new ArrayList<>();

    public MyAdapter(FragmentManager fm, List<String> list, List<Fragment> fragments){
        super(fm);
        this.list = list;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
