package com.soldiersoul.wutu.more;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.UserBean;
import com.soldiersoul.wutu.login.LoginActivity;
import com.soldiersoul.wutu.utils.ToastUtil;
import com.soldiersoul.wutu.views.SimpleMenuItem;
import com.soldiersoul.wutu.weapon.WeapontCollectionAct;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;

/**
 * 我的界面Fragment
 */
public class MeFragment extends Fragment {

    @BindView (R.id.ivUserAvatar) ImageView ivUserAvatar;
    @BindView (R.id.tvUserName) TextView tvUserName;
    @BindView (R.id.itemCollection) SimpleMenuItem itemCollection;
    @BindView (R.id.itemClearCache) SimpleMenuItem itemClearCache;
    @BindView (R.id.itemUpdate) SimpleMenuItem itemUpdate;
    @BindView (R.id.itemAbout) SimpleMenuItem itemAbout;
    @BindView (R.id.btnQuitLogin) Button btnQuitLogin;

    private ToastUtil toastUtil;

    public MeFragment () {
    }

    @Override
    public void onResume () {
        super.onResume ();
        UserBean user = BmobUser.getCurrentUser (UserBean.class);
        if (user != null) {
            if (!user.getUserAvatar ().equals ("")) {
                Picasso.with (getActivity ()).load (user.getUserAvatar ()).into (ivUserAvatar);
            }
            tvUserName.setText (user.getUsername ());
        }
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        toastUtil = new ToastUtil (getActivity ());
        ButterKnife.bind (this, view);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_me, container, false);
    }

    /**
     * 点击头像跳转到用户界面
     */
    @OnClick ({R.id.ivUserAvatar, R.id.tvUserName})
    public void goToUserActivity () {
        Intent intent = new Intent (getActivity (), UserInfoAct.class);
        startActivity (intent);
    }

    /**
     * 我的收藏
     */
    @OnClick (R.id.itemCollection)
    public void myCollection () {
        Intent intent = new Intent (getActivity (),WeapontCollectionAct.class);
//        intent.putExtra ("userBean", BmobUser.getCurrentUser (UserBean.class).getObjectId ());
        startActivity (intent);
    }

    /**
     * todo
     * 更换主题
     */
    @OnClick (R.id.itemChangeSkin)
    public void changeTheme () {
    }

    /**
     * 清除视频缓存
     */
    @OnClick (R.id.itemClearCache)
    public void clearCache () {
        GSYVideoManager.clearAllDefaultCache (getContext ());
        ToastUtil util = new ToastUtil (getContext ());
        util.toastShort ("已清理视频缓存");
    }

    /**
     * todo检查更新
     */
    @OnClick (R.id.itemUpdate)
    public void checkForUpdate () {

    }

    /**
     * todo关于
     */
    @OnClick (R.id.itemAbout)
    public void about () {

    }

    /**
     * 退出登录
     */
    @OnClick (R.id.btnQuitLogin)
    public void quitLogin () {
        AlertDialog.Builder builder = new AlertDialog.Builder (getActivity ());
        builder.setMessage ("确定要退出登陆吗?").setPositiveButton ("退出登录", new DialogInterface.OnClickListener () {
            @Override
            public void onClick (DialogInterface dialogInterface, int i) {
                doQuitLogin ();
            }
        }).setNegativeButton ("取消", new DialogInterface.OnClickListener () {
            @Override
            public void onClick (DialogInterface dialogInterface, int i) {
                dialogInterface.cancel ();
            }
        }).show ();
    }

    private void doQuitLogin () {
        BmobUser.logOut ();   //清除缓存用户对象
        BmobUser currentUser = BmobUser.getCurrentUser (); // 现在的currentUser是null了
        getActivity ().finish ();
        startActivity (new Intent (getActivity (), LoginActivity.class));
        toastUtil.toastShort ("退出登录成功");
    }

}
