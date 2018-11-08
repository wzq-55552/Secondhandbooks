package com.example.hasee.second_handbooks;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MyFragment02 extends Fragment {
    Context mContext;

    private TabLayout tab;

    private ViewPager mVp;

    private List<String> titles;

    private List<Fragment> data;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment02, container, false);
        tab = (TabLayout)view.findViewById(R.id.fragment02_tab);
        mVp = (ViewPager)view.findViewById(R.id.fragment02_pager);

        //标题
        titles = new ArrayList<>();
        titles.add("我的需求");
        titles.add("我的申请");

        //数据源
        data  = new ArrayList<>();
        data.add(new Fragment1Myneeds());
        data.add(new Fragment1Myapply());

        //设置模式
        tab.setTabMode(TabLayout.MODE_FIXED);

        //添加名称
        tab.addTab(tab.newTab().setText(titles.get(0)));
        tab.addTab(tab.newTab().setText(titles.get(1)));


        FragmentManager fragmentManager=getFragmentManager();
        mVpAdapter adapter = new mVpAdapter(fragmentManager,titles,data);
        mVp.setAdapter(adapter);
        //Tab与ViewPager绑定
        tab.setupWithViewPager(mVp);

        return view;
    }
}
