package com.example.hasee.second_handbooks;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
/*
    mVp监听器
    放出来，简洁美观
 */
>>>>>>> 8d6fd9eb2072023c008cd541c7d407a4cfb0ec9f
public class mVpAdapter extends FragmentPagerAdapter {

    List<String> list;
    List<Fragment>fragments = new ArrayList<>();

    public mVpAdapter(FragmentManager fm, List<String> list, List<Fragment> fragments){
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