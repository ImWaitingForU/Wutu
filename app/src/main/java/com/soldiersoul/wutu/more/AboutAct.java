package com.soldiersoul.wutu.more;

import android.os.Bundle;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;

import butterknife.BindView;

/**
 * 关于界面
 */
public class AboutAct extends BaseActivity {

    @BindView (R.id.tvAbout) TextView tvAbout;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setHomeButtonStaff ("关于");

        tvAbout.setText ("伍途 ：版本号V1.0 ;" +"                         ");
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_about;
    }
}
