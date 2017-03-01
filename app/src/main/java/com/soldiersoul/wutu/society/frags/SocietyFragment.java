package com.soldiersoul.wutu.society.frags;


import java.util.ArrayList;

import com.flyco.tablayout.SlidingTabLayout;
import com.soldiersoul.wutu.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 社团Fragment
 */
public class SocietyFragment extends Fragment {

    @BindView (R.id.tl) SlidingTabLayout stl;
    @BindView (R.id.vpSociety) ViewPager vpSociety;

    private static final String TAG = "SocietyFragment";
    private ArrayList<Fragment> mFragments = new ArrayList<> ();
    private final String[] mTitles = {"社团信息", "社团照片", "社团活动", "社团任务"};
    private MyPagerAdapter mAdapter;

//    private static boolean isHasSociety = false;
    private static boolean isHasSociety = true;

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter (FragmentManager fm) {
            super (fm);
        }

        @Override
        public int getCount () {
            return mFragments.size ();
        }

        @Override
        public CharSequence getPageTitle (int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem (int position) {
            return mFragments.get (position);
        }
    }

    public SocietyFragment () {
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);

        if (!isHasSociety) {
            return;
        }

        ButterKnife.bind (this, view);

        //todo:初始化Fragment集合
        if (mFragments != null && mFragments.isEmpty ()) {
            mFragments.add (new SocietyBaseInfoFragment ());
            mFragments.add (new SocietyPhotoFragment ());
            mFragments.add (new SocietyActFragment ());
            mFragments.add (new SocietyIntegralFragment ());
        }

        mAdapter = new MyPagerAdapter (getFragmentManager ());
        vpSociety.setOffscreenPageLimit (4);
        vpSociety.setAdapter (mAdapter);
        stl.setViewPager (vpSociety);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO:定位后判断学校内是否有该社团，有则显示社团信息，没有则显示提示

        if (isHasSociety) {
            return inflater.inflate (R.layout.fragment_society, container, false);
        } else {
            return inflater.inflate (R.layout.fragment_society_empty, container, false);
        }

    }

}
