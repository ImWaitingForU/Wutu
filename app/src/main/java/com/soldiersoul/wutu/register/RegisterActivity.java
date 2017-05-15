package com.soldiersoul.wutu.register;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.views.MisoperationDialog;

import cn.bmob.sms.BmobSMS;

public class RegisterActivity extends BaseActivity implements MisoperationDialog.MisoperationListener {

    private VerifyFragment mVerifyFragment;
    private PwdFragment mPwdFragment;
    private FragmentManager fm;

    private Boolean isFindPwd;

    private Handler mHandler = new Handler () {
        @Override
        public void handleMessage (Message msg) {
            if (msg.what == VerifyFragment.VERIFY_SUCCESS) {
                Log.d ("Chan", "handler:" + msg.arg1);
                showPwdFragment (msg.obj, isFindPwd, msg.arg1);
            }
        }
    };

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        fm = getSupportFragmentManager ();

        //判断是否是重置密码
        isFindPwd = getIntent ().getBooleanExtra ("isFindPwd", false);
        showVerifyFragment (isFindPwd);
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
    private void showVerifyFragment (Boolean isFindPwd) {
        FragmentTransaction transaction = fm.beginTransaction ();
        if (mVerifyFragment == null) {
            mVerifyFragment = new VerifyFragment (mHandler, isFindPwd);
            transaction.add (R.id.activity_register, mVerifyFragment);
        }
        setTitle ("验证手机号");
        transaction.commitAllowingStateLoss ();
    }

    /**
     * 显示填写密码Fragment
     */
    private void showPwdFragment (Object obj, Boolean isFindPwd, int verifyCode) {
        FragmentTransaction transaction = fm.beginTransaction ();
        if (mVerifyFragment != null) {
            transaction.remove (mVerifyFragment);
        }
        if (mPwdFragment == null) {
            mPwdFragment = new PwdFragment (mHandler, obj, isFindPwd, verifyCode);
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
        dialog.initMisoperationDialog (this, "确定不保存退出吗?", "退出", true);
    }

    @Override
    public void onPositiveClicked () {
        this.finish ();
    }
}
