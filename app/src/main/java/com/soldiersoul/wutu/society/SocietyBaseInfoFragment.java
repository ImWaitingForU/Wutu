package com.soldiersoul.wutu.society;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.soldiersoul.wutu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 社团基本信息界面
 */
public class SocietyBaseInfoFragment extends Fragment {

    @BindView (R.id.ivSocietyLogo) ImageView ivSocietyLogo;
    @BindView (R.id.tvSocietyName) TextView tvSocietyName;
    @BindView (R.id.tvSocietyIntroduction) TextView tvSocietyIntro;
    @BindView (R.id.tvChairmanName) TextView tvChairmanName;
    @BindView (R.id.tvSocietyPhone) TextView tvSocietyPhone;
    @BindView (R.id.tvSocietyLocation) TextView tvSocietyLocation;
    @BindView (R.id.tvSocietyMemberCount) TextView tvSocietyMemberCount;
    @BindView (R.id.tvLocation) TextView tvLocation;

    public SocietyBaseInfoFragment () {
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate (R.layout.fragment_society_baseinfo, container, false);
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);
    }

    /**
     * 跳转到定位界面
     */
    @OnClick (R.id.llLocate)
    void gotoLocation () {
        startActivity (new Intent (getActivity (), LocationActivity.class));
    }

}
