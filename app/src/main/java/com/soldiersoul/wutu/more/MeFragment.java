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

import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.home.MainActivity;
import com.soldiersoul.wutu.military.VideoListActivity;
import com.soldiersoul.wutu.utils.ToastUtil;
import com.soldiersoul.wutu.views.SimpleMenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的界面Fragment
 */
public class MeFragment extends Fragment implements View.OnClickListener {

    @BindView (R.id.ivUserAvatar) ImageView ivUserAvatar;
    @BindView (R.id.tvUserName) TextView tvUserName;
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
        itemClearCache.setOnClickListener(this);
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
        Intent intent = new Intent (getActivity (), UserInfoAct.class);
        startActivity (intent);
    }

    /**
     * todo
     * 获取用户数据,手机号，学校等
     */
    private void getUserData () {
    }


    @Override
    public void onClick(View v) {
        GSYVideoManager.clearAllDefaultCache(getContext());
        ToastUtil util = new ToastUtil(getContext());
        util.toastShort("已清理视频缓存");
    }
}
