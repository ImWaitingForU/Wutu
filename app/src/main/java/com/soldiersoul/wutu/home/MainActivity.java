package com.soldiersoul.wutu.home;

import android.os.Bundle;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_main;
    }
}
