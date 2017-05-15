package com.soldiersoul.wutu.login;

import android.os.Bundle;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;

/**
 * 重置密码界面
 */
public class FindPwdAct extends BaseActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_find_pwd;
    }
}
