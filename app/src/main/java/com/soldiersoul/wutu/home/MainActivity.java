package com.soldiersoul.wutu.home;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.military.MilitaryFragment;
import com.soldiersoul.wutu.more.MeFragment;
import com.soldiersoul.wutu.society.SocietyFragment;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.views.BottomBar;
import com.soldiersoul.wutu.weapon.WeaponFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomBar.BottomBarClickedListener {

    @BindView (R.id.bottomBar) BottomBar mBottomBar;

    private FragmentManager mFragmentManager;
    private MilitaryFragment mMilitaryFragment;
    private SocietyFragment mSocietyFragment;
    private WeaponFragment mWeaponFragment;
    private MeFragment mMeFragment;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        mFragmentManager = getSupportFragmentManager ();
        initFragments ();
    }

    private void initFragments () {

        mBottomBar.setBottomBarClickedListener (this);
        //初始化时添加军事天地fragment
        showMilitaryFragments ();
    }

    private void showMilitaryFragments () {
        FragmentTransaction transaction = mFragmentManager.beginTransaction ();
        if (mMilitaryFragment == null) {
            mMilitaryFragment = new MilitaryFragment (this);
            transaction.add (R.id.main_layout, mMilitaryFragment);
        }
        hideAllFragment ();
        transaction.show (mMilitaryFragment);
        transaction.commitAllowingStateLoss ();
    }

    private void showSocietyFragments () {
        FragmentTransaction transaction = mFragmentManager.beginTransaction ();
        if (mSocietyFragment == null) {
            mSocietyFragment = new SocietyFragment ();
            transaction.add (R.id.main_layout, mSocietyFragment);
        }
        hideAllFragment ();
        transaction.show (mSocietyFragment);
        transaction.commitAllowingStateLoss ();
    }

    private void showWeaponFragments () {
        FragmentTransaction transaction = mFragmentManager.beginTransaction ();
        if (mWeaponFragment == null) {
            mWeaponFragment = new WeaponFragment ();
            transaction.add (R.id.main_layout, mWeaponFragment);
        }
        hideAllFragment ();
        transaction.show (mWeaponFragment);
        transaction.commitAllowingStateLoss ();
    }

    private void showMeFragments () {
        FragmentTransaction transaction = mFragmentManager.beginTransaction ();
        if (mMeFragment == null) {
            mMeFragment = new MeFragment ();
            transaction.add (R.id.main_layout, mMeFragment);
        }
        hideAllFragment ();
        transaction.show (mMeFragment);
        transaction.commitAllowingStateLoss ();
    }

    /**
     * 隐藏所有Fragment
     */
    private void hideAllFragment () {
        FragmentTransaction transaction = mFragmentManager.beginTransaction ();
        if (mMilitaryFragment != null && mMilitaryFragment.isVisible ()) {
            transaction.hide (mMilitaryFragment);
        }

        if (mSocietyFragment != null && mSocietyFragment.isVisible ()) {
            transaction.hide (mSocietyFragment);
        }

        if (mWeaponFragment != null && mWeaponFragment.isVisible ()) {
            transaction.hide (mWeaponFragment);
        }

        if (mMeFragment != null && mMeFragment.isVisible ()) {
            transaction.hide (mMeFragment);
        }

        transaction.commitAllowingStateLoss ();
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_main;
    }

    @Override
    public void onBottomBar1Clicked () {
        showMilitaryFragments ();
    }

    @Override
    public void onBottomBar2Clicked () {
        showSocietyFragments ();
    }

    @Override
    public void onBottomBar3Clicked () {
        showWeaponFragments ();
    }

    @Override
    public void onBottomBar4Clicked () {
        showMeFragments ();
    }
}
