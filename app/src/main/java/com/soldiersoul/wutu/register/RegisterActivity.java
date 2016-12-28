package com.soldiersoul.wutu.register;

import android.os.Bundle;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        getSupportFragmentManager ().beginTransaction ().add (R.id.activity_register, new VerifyFragment ()).commit ();

    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_register;
    }

    @Override
    public void onBackPressed () {
        super.onBackPressed ();
    }

    
}
