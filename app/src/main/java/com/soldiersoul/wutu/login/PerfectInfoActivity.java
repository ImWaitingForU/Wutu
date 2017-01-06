package com.soldiersoul.wutu.login;

import android.content.Intent;
import android.os.Bundle;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.home.MainActivity;
import com.soldiersoul.wutu.utils.BaseActivity;

/**
 * chan:完善资料Activity
 */
public class PerfectInfoActivity extends BaseActivity {

    /**
     * 判断是从注册界面跳转来还是账号界面跳转来
     * <p>
     * true--注册界面  false--账号界面
     */
    private boolean isFromRegister;
    /**
     * 从注册界面跳转到完善信息界面
     */
    public static final String REGISTER_TO_INFO = "fromRegister";
    /**
     * 从账号界面跳转到完善信息界面
     */
    public static final String SETTING_TO_INFO = "fromSetting";
    public static final String FROMWHERE = "fromWhere";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        fromWhere ();
    }

    private void fromWhere () {
        Intent i = getIntent ();
        String fromWhere = i.getStringExtra (FROMWHERE);

        if (fromWhere.equals (REGISTER_TO_INFO)) {
            isFromRegister = true;
        } else if (fromWhere.equals (SETTING_TO_INFO)) {
            isFromRegister = false;
        }
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_perfect_info;
    }

    @Override
    public void onBackPressed () {
        if (isFromRegister) {
            Intent intent = new Intent (this, MainActivity.class);
            intent.setFlags (Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity (intent);
            finish ();
        } else {
            super.onBackPressed ();
        }
    }
}
