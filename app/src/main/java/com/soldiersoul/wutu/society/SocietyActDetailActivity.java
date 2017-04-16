package com.soldiersoul.wutu.society;

import android.os.Bundle;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.society.bean.SocietyAct;
import com.soldiersoul.wutu.utils.BaseActivity;

import butterknife.BindView;

/**
 * 社团活动详细界面
 */
public class SocietyActDetailActivity extends BaseActivity {

    @BindView (R.id.tvSocietyActName) TextView tvActName;
    @BindView (R.id.tvSocietyActPlanner) TextView tvActPlanner;
    @BindView (R.id.tvSocietyActStartTime) TextView tvStartTime;
    @BindView (R.id.tvSocietyActEndTime) TextView tvEndTime;
    @BindView (R.id.tvSocietyActLocation) TextView tvActLocation;
    @BindView (R.id.tvSocietyActContent) TextView tvActContent;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        getSupportActionBar ().setTitle ("社团活动");
        getSupportActionBar ().setHomeButtonEnabled (true);

        SocietyAct act = (SocietyAct) getIntent ().getSerializableExtra ("societyAct");
        if (act == null) { return; }
        tvActName.setText (act.getActName ());
        tvActContent.setText (act.getActContent ());
        tvStartTime.setText (act.getStartTime ());
        tvEndTime.setText (act.getEndTime ());
        tvActLocation.setText (act.getActLocation ());
        tvActPlanner.setText (act.getActPlanner ());
    }

    @Override
    protected void onResume () {
        super.onResume ();
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_society_act_detail;
    }
}
