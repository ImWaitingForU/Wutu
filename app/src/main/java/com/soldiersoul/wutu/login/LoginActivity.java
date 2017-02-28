package com.soldiersoul.wutu.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.maksim88.passwordedittext.PasswordEditText;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.register.RegisterActivity;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.utils.LogUtils;

import butterknife.BindView;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity {

    @BindView (R.id.et_userName) EditText etPhone;
    @BindView (R.id.et_pwd) PasswordEditText etPwd;

    /**
     * 登录
     */
    @OnClick (R.id.btn_login)
    void login () {
        //TODO:登录
        LogUtils.d ("登录");
    }

    /**
     * 注册
     */
    @OnClick (R.id.btn_register)
    void register () {
        //TODO:跳转到注册界面注册
        startActivity (new Intent (this, RegisterActivity.class));
        LogUtils.d ("注册");
    }

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        initHandler (new Handler.Callback () {
            @Override
            public boolean handleMessage (Message msg) {
                return false;
            }
        });
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_login;
    }
}
