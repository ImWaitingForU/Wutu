package com.soldiersoul.wutu.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.EditText;

import com.maksim88.passwordedittext.PasswordEditText;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.UserBean;
import com.soldiersoul.wutu.home.MainActivity;
import com.soldiersoul.wutu.register.RegisterActivity;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.utils.Constants;
import com.soldiersoul.wutu.utils.LogUtils;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.LogInListener;


public class LoginActivity extends BaseActivity {

    @BindView (R.id.et_userName) EditText etPhone;
    @BindView (R.id.et_pwd) PasswordEditText etPwd;

    /**
     * 登录
     */
    @OnClick (R.id.btn_login)
    void login () {
        BmobUser.loginByAccount (etPhone.getText ().toString (), etPwd.getText ().toString (), new LogInListener<UserBean> () {

                                     @Override
                                     public void done (UserBean userBean, cn.bmob.v3.exception.BmobException e) {
                                         if (userBean != null) {
                                             mToastUtil.toastShort ("登录成功");
                                             startActivity (new Intent (LoginActivity.this, MainActivity.class));
                                             finish ();
                                         } else {
                                             mToastUtil.toastShort ("登录失败，请检查用户名和密码");
                                         }
                                     }
                                 });
    }

    /**
     * 注册
     */
    @OnClick (R.id.btn_register)
    void register () {
        startActivity (new Intent (this, RegisterActivity.class));
        LogUtils.d ("注册");
    }

    /**
     * 重置密码 , 直接使用注册界面的功能
     */
    @OnClick(R.id.tv_goToFindPwd)
    void goFindPwd(){
        Intent intent = new Intent (this,RegisterActivity.class);
        intent.putExtra ("isFindPwd",true);
        startActivity (intent);
    }

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        Bmob.initialize (this, Constants.BMOB_APPKEY);
        //检查是否有缓存登录用户
        UserBean bmobUser = BmobUser.getCurrentUser (UserBean.class);
        if (bmobUser != null) {
            // 允许用户使用应用
            startActivity (new Intent (this, MainActivity.class));
            finish ();
            Log.d ("chan","已存在用户");
        } else {
            //缓存用户对象为空时， 可打开用户注册界面…
            mToastUtil.toastShort ("您还没有登录，请登录/注册账号");
        }
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_login;
    }
}
