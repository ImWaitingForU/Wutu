package com.soldiersoul.wutu.more;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.society.LocationActivity;
import com.soldiersoul.wutu.views.SimpleMenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的界面Fragment
 */
public class MeFragment extends Fragment {

    @BindView (R.id.ivUserAvatar) ImageView ivUserAvatar;
    @BindView (R.id.tvUserName) TextView tvUserName;
    @BindView (R.id.itemPhone) SimpleMenuItem itemPhone;
    @BindView (R.id.itemSchool) SimpleMenuItem itemSchool;
    @BindView (R.id.itemCollection) SimpleMenuItem itemCollection;
    @BindView (R.id.itemClearCache) SimpleMenuItem itemClearCache;
    @BindView (R.id.itemUpdate) SimpleMenuItem itemUpdate;
    @BindView (R.id.itemAbout) SimpleMenuItem itemAbout;
    @BindView (R.id.btnQuitLogin) Button btnQuitLogin;

    public MeFragment () {
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_me, container, false);
    }

    /**
     * 点击头像跳转到用户界面
     */
    @OnClick (R.id.ivUserAvatar)
    public void goToUserActivity () {

    }

    /**
     * todo
     * 获取用户数据,手机号，学校等
     */
    private void getUserData () {
    }

    /**
     * 跳转到修改手机号界面
     */
    @OnClick (R.id.itemPhone)
    public void goChangePhone () {

    }


    private static final int requestSchoolCode = 1;

    /**
     * 跳转到定位修改学校界面
     */
    @OnClick (R.id.itemSchool)
    public void goChangeSchool () {
        Intent intent = new Intent (getActivity (), LocationActivity.class);
        startActivityForResult (intent, requestSchoolCode);
    }

}
