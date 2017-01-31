package com.soldiersoul.wutu.society;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 社团主要人员资料界面 by Chan
 */
public class MemberActivity extends BaseActivity {

    @BindView (R.id.rvMember) RecyclerView rvMember;
    @BindView (R.id.tvAddNew) TextView tvAddNew;

    /**
     * TODO:添加新届社团
     */
    @OnClick (R.id.tvAddNew)
    void addNew () {

    }

    /**
     * TODO:判断是否是社长或者管理员
     *
     * @return
     */
    private boolean isPresident () {
        return true;
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //判断是否是社长，不是社长隐藏添加功能
        if (!isPresident ()){
            tvAddNew.setVisibility (View.GONE);
        }

//        rvMember.setAdapter ();

    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_member;
    }

//    private class MemberRvAdapter extends BaseQuickAdapter<>


}
