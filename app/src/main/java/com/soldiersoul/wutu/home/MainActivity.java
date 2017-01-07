package com.soldiersoul.wutu.home;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.views.BottomBar;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomBar.BottomBarClickedListener {

    @BindView (R.id.bottomBar) BottomBar mBottomBar;

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        mFragmentManager = getSupportFragmentManager ();

        mBottomBar.setBottomBarClickedListener (this);
    }

    private void initFragments () {

    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_main;
    }

    @Override
    public void onBottomBar1Clicked () {

    }

    @Override
    public void onBottomBar2Clicked () {

    }

    @Override
    public void onBottomBar3Clicked () {

    }

    @Override
    public void onBottomBar4Clicked () {

    }
}
