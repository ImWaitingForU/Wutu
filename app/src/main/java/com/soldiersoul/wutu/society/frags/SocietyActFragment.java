package com.soldiersoul.wutu.society.frags;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baoyachi.stepview.VerticalStepView;
import com.soldiersoul.wutu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 社团活动界面
 */
public class SocietyActFragment extends Fragment {

    @BindView (R.id.stepView) VerticalStepView stepView;

    private void text () {
        List<String> list0 = new ArrayList<> ();
        list0.add ("活动1");
        list0.add ("活动2");
        list0.add ("活动3");
        list0.add ("活动4");
        list0.add ("活动5");
        list0.add ("活动6");
        list0.add ("活动7");
        list0.add ("活动8");
        list0.add ("活动9");
        stepView.setStepsViewIndicatorComplectingPosition (list0.size () - 2)// 设置完成的步数
                .reverseDraw (true)// default is true
                .setStepViewTexts (list0)// 总步骤
                .setLinePaddingProportion (0.85f)// 设置indicator线与线间距的比例系数
                .setStepsViewIndicatorCompletedLineColor (
                        ContextCompat.getColor (getActivity (), android.R.color.white))// 设置StepsViewIndicator完成线的颜色
                .setStepsViewIndicatorUnCompletedLineColor (
                        ContextCompat.getColor (getActivity (), R.color.uncompleted_text_color))
                // 设置StepsViewIndicator未完成线的颜色
                .setStepViewComplectedTextColor (
                        ContextCompat.getColor (getActivity (), android.R.color.white))// 设置StepsView
                // text完成线的颜色
                .setStepViewUnComplectedTextColor (
                        ContextCompat.getColor (getActivity (), R.color.uncompleted_text_color))// 设置StepsView
                // text未完成线的颜色
                .setStepsViewIndicatorCompleteIcon (
                        ContextCompat.getDrawable (getActivity (), R.drawable.complted))// 设置StepsViewIndicator
                // CompleteIcon
                .setStepsViewIndicatorDefaultIcon (
                        ContextCompat.getDrawable (getActivity (), R.drawable.default_icon))// 设置StepsViewIndicator
                // DefaultIcon
                .setStepsViewIndicatorAttentionIcon (
                        ContextCompat.getDrawable (getActivity (), R.drawable.attention));// 设置StepsViewIndicator
        // AttentionIcon
    }

    public SocietyActFragment () {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);
        text ();
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_society_act, container, false);
    }

}
