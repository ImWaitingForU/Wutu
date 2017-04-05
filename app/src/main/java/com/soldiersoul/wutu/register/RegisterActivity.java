package com.soldiersoul.wutu.register;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.views.MisoperationDialog;

import cn.bmob.sms.BmobSMS;

public class RegisterActivity extends BaseActivity implements MisoperationDialog.MisoperationListener {

    private VerifyFragment mVerifyFragment;
    private PwdFragment mPwdFragment;
    private FragmentManager fm;

    private Handler mHandler = new Handler () {
        @Override
        public void handleMessage (Message msg) {
            if (msg.what == VerifyFragment.VERIFY_SUCCESS) {
                showPwdFragment (msg.obj);
            }
        }
    };

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        fm = getSupportFragmentManager ();
        showVerifyFragment ();
        BmobSMS.initialize (this, "2cc3116ad9187a3b8cca8f37da4338e0");

        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        getSupportActionBar ().setHomeButtonEnabled (true);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        if (item.getItemId () == android.R.id.home) {
            onBackPressed ();
        }
        return super.onOptionsItemSelected (item);
    }

    /**
     * 显示验证码Fragment
     */
    private void showVerifyFragment () {
        FragmentTransaction transaction = fm.beginTransaction ();
        if (mVerifyFragment == null) {
            mVerifyFragment = new VerifyFragment (mHandler);
            transaction.add (R.id.activity_register, mVerifyFragment);
        }
        setTitle ("验证手机号");
        transaction.commitAllowingStateLoss ();
    }

    /**
     * 显示填写密码Fragment
     */
    private void showPwdFragment (Object obj) {
        FragmentTransaction transaction = fm.beginTransaction ();
        if (mVerifyFragment != null) {
            transaction.remove (mVerifyFragment);
        }
        if (mPwdFragment == null) {
            mPwdFragment = new PwdFragment (mHandler, obj);
            transaction.add (R.id.activity_register, mPwdFragment);
        }
        setTitle ("设置密码");
        transaction.commitAllowingStateLoss ();
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_register;
    }

    @Override
    public void onBackPressed () {
        MisoperationDialog dialog = new MisoperationDialog (this);
        dialog.setMisoperationListener (this);
        dialog.initMisoperationDialog (this, "确认退出注册吗?", "退出注册", true);
    }

    @Override
    public void onPositiveClicked () {
        this.finish ();
    }
}
