package com.soldiersoul.wutu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by wxj on 2017/1/9.
 */

public class Military_Fragment_Adapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentsList;

    public Military_Fragment_Adapter(FragmentManager fm) {
        super(fm);
    }
    public Military_Fragment_Adapter(FragmentManager fm,ArrayList<Fragment> fragments) {
        super(fm);
        this.fragmentsList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
}
