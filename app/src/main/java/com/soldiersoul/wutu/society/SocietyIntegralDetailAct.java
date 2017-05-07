package com.soldiersoul.wutu.society;

import android.os.Bundle;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.society.bean.SocietyIntegral;
import com.soldiersoul.wutu.utils.BaseActivity;

import butterknife.BindView;

/*社团任务详情界面*/
public class SocietyIntegralDetailAct extends BaseActivity {

    @BindView (R.id.tvIntegralName) TextView tvIntegralName;
    @BindView (R.id.tvIntegralContent) TextView tvIntegralContent;
    @BindView (R.id.tvIntegralDeadLine) TextView tvIntegralDeadLine;
    @BindView (R.id.tvIntegralPrice) TextView tvIntegralPrice;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        setHomeButtonStaff ("任务详情");

        SocietyIntegral si = (SocietyIntegral) getIntent ().getSerializableExtra ("SocietyIntegral");
        tvIntegralName.setText (si.getIntegralName ());
        tvIntegralDeadLine.setText ("截止时间:"+si.getDeadline ());
        tvIntegralPrice.setText ("任务奖励:"+si.getIntegralReward ());
        tvIntegralContent.setText (si.getIntegralContent ());
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_society_integral_detail;
    }
}
