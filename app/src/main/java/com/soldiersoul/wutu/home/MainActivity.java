package com.soldiersoul.wutu.home;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.UserBean;
import com.soldiersoul.wutu.login.LoginActivity;
import com.soldiersoul.wutu.military.MilitaryFragment;
import com.soldiersoul.wutu.more.MeFragment;
import com.soldiersoul.wutu.society.frags.SocietyFragment;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.utils.Constants;
import com.soldiersoul.wutu.utils.NetworkBroadcastReceiver;
import com.soldiersoul.wutu.views.BottomBar;
import com.soldiersoul.wutu.weapon.WeaponFragment;

import butterknife.BindView;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class MainActivity extends BaseActivity implements BottomBar.BottomBarClickedListener,
        NetworkBroadcastReceiver.NetEvent {

    @BindView (R.id.bottomBar) BottomBar mBottomBar;
    @BindView (R.id.networkEventView) View netWorkEventView;

    private FragmentManager mFragmentManager;
    private MilitaryFragment mMilitaryFragment;
    private SocietyFragment mSocietyFragment;
    private WeaponFragment mWeaponFragment;
    private MeFragment mMeFragment;

    private NetworkBroadcastReceiver networkBroadcastReceiver;

    //初始化bmob有关信息
    public void initBmob () {
        Bmob.initialize (this, Constants.BMOB_APPKEY);
    }


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        initBmob ();
        if (networkBroadcastReceiver == null) {
            networkBroadcastReceiver = new NetworkBroadcastReceiver ();
            networkBroadcastReceiver.setNetEvent (MainActivity.this);
            IntentFilter filter = new IntentFilter ();
            filter.addAction (WifiManager.NETWORK_STATE_CHANGED_ACTION);
            filter.addAction (WifiManager.WIFI_STATE_CHANGED_ACTION);
            filter.addAction (ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver (networkBroadcastReceiver, filter);
        }

        super.onCreate (savedInstanceState);
        mFragmentManager = getSupportFragmentManager ();
        initFragments ();
    }

    @Override
    protected void onResume () {
        super.onResume ();
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

    private void showManageFragments () {
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
    protected void onDestroy () {
        //退出后关闭网络广播监听
        if (networkBroadcastReceiver != null) {
            unregisterReceiver (networkBroadcastReceiver);
        }
        super.onDestroy ();
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
        if (BmobUser.getCurrentUser (UserBean.class) == null) {
            startActivity (new Intent (MainActivity.this, LoginActivity.class));
        } else {
            showSocietyFragments ();
        }
    }

    @Override
    public void onBottomBar3Clicked () {
        showManageFragments ();
    }

    @Override
    public void onBottomBar4Clicked () {
        //如果没登陆则进入登陆界面
        if (BmobUser.getCurrentUser (UserBean.class) == null) {
            startActivity (new Intent (MainActivity.this, LoginActivity.class));
//            this.finish ();
        } else {
            showMeFragments ();
        }
    }

    @Override
    public void onNetChange (boolean isConnected) {
        if (isConnected) {
            netWorkEventView.setVisibility (View.GONE);
        } else {
            netWorkEventView.setVisibility (View.VISIBLE);
        }
    }
}
