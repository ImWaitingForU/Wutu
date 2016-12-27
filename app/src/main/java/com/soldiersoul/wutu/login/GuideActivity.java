package com.soldiersoul.wutu.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.soldiersoul.wutu.R;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * @author Chan
 * 导航页
 */
public class GuideActivity extends AppCompatActivity {

    private BGABanner mBanner;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_guide_activitiy);

        mBanner = (BGABanner) findViewById (R.id.banner);
        //TODO 设置banner轮播图片
    }
}
