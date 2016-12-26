package com.soldiersoul.wutu.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.home.MainActivity;
import com.soldiersoul.wutu.utils.LogUtils;
import com.soldiersoul.wutu.utils.ToastUtil;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin;
    private EditText etUserName;
    private EditText etPwd;
    private TextView tvGoRegister;
    private TextView tvFindPwd;
    private CheckBox cb_login_showPwd;
    private ToastUtil mToastUtil;
    private LogUtils mLogUtil;

    private SharedPreferences sp;

    private void initViews () {
        btnLogin = (Button) findViewById (R.id.btn_login);
        etUserName = (EditText) findViewById (R.id.et_userName);
        etPwd = (EditText) findViewById (R.id.et_pwd);
        tvGoRegister = (TextView) findViewById (R.id.tv_goToRegister);
        tvFindPwd = (TextView) findViewById (R.id.tv_goToFindPwd);
        cb_login_showPwd = (CheckBox) findViewById (R.id.cb_login_showPwd);

        btnLogin.setOnClickListener (this);
        tvGoRegister.setOnClickListener (this);
        tvFindPwd.setOnClickListener (this);

        cb_login_showPwd.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    etPwd.setInputType (InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    etPwd.setInputType (InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                }
            }
        });
    }

//    /**
//     * 初始化Bmob的信息
//     */
//    private void initBmob () {
//        Bmob.initialize (this, "33e110e2fdb455b8edeb19168b2b195d");
//    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
//        initBmob ();
//        setContentView (R.layout.activity_login);
//        mToastUtil = new ToastUtil (this);
//        mLogUtil = new LogUtil (this.getClass ());
        initViews ();
        checkFirstUse ();
    }

//    /**
//     * 检查是否第一次用，第一次则从引导页开始,否则再判断是否有登录信息
//     */
//    private void checkFirstUse () {
//        if (sp == null) {
//            sp = getSharedPreferences (SpUtil.SP_NAME, MODE_PRIVATE);
//        }
//
//        if (sp.getBoolean (SpUtil.IS_FIRST_USE, false)) {
//            startActivity (new Intent (this, GuideActivity.class));
//        } else if (sp.getBoolean (SpUtil.SP_IS_LOGIN, false)) {
//            startActivity (new Intent (this, MainActivity.class));
//            finish ();
//        }
//    }


//    /**
//     * 验证登录的用户名密码
//     */
//    private void checkAccount () {
//        final String username = etUserName.getText ().toString ();
//        final String pwd = etPwd.getText ().toString ();
//        BmobUser.loginByAccount (this, username, pwd, new LogInListener<User> () {
//            @Override
//            public void done (User user, BmobException e) {
//                if (user != null) {
//                    mToastUtil.toastShort ("登陆成功");
//                    startActivity (new Intent (LoginActivity.this, MainActivity.class));
//                    // 保存登录信息，下次自动登录
//                    SharedPreferences.Editor editor = sp.edit ();
//                    editor.putString (SpUtil.SP_KEY_USERNAME, username);
//                    editor.putString (SpUtil.SP_KEY_PWD, pwd);
//                    editor.putBoolean (SpUtil.SP_IS_LOGIN, true);
//                    editor.apply ();
//                    finish ();
//                } else {
//                    mToastUtil.toastShort ("登录失败,请检查用户名和密码");
//                }
//            }
//        });
//    }
//
//    @Override
//    public void onClick (View v) {
//        switch (v.getId ()) {
//            case R.id.btn_login:
//                checkAccount ();
//                break;
//            case R.id.tv_goToRegister:
//                startActivity (new Intent (LoginActivity.this, RegisterActivity.class));
//                break;
//            case R.id.tv_goToFindPwd:
//                startActivity (new Intent (LoginActivity.this, FindPwdActivity.class));
//                break;
//            default:
//                break;
//        }
//    }
}
