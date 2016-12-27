package com.soldiersoul.wutu.login;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.maksim88.passwordedittext.PasswordEditText;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;

import butterknife.BindView;


public class LoginActivity extends BaseActivity {

    @BindView (R.id.et_userName) EditText etPhone;
    @BindView (R.id.et_pwd)  PasswordEditText etPwd;
    @BindView (R.id.btn_login) Button btnLogin;

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
