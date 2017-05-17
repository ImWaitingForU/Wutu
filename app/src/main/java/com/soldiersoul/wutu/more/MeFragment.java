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
import android.widget.Toast;

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
import cn.bmob.v3.listener.BmobUpdateListener;
import cn.bmob.v3.update.BmobUpdateAgent;
import cn.bmob.v3.update.UpdateResponse;
import cn.bmob.v3.update.UpdateStatus;

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
        intent.putExtra ("user",BmobUser.getCurrentUser (UserBean.class));
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
     * 检查更新
     */
    @OnClick (R.id.itemUpdate)
    public void checkForUpdate () {
//        BmobUpdateAgent.initAppVersion();
        BmobUpdateAgent.setUpdateOnlyWifi(false);
        BmobUpdateAgent.update (getActivity ());
        BmobUpdateAgent.setUpdateListener(new BmobUpdateListener () {

            @Override
            public void onUpdateReturned(int updateStatus, UpdateResponse updateInfo) {
                if (updateStatus == UpdateStatus.Yes) {//版本有更新

                }else if(updateStatus == UpdateStatus.No){
                    Toast.makeText(getActivity(), "版本无更新", Toast.LENGTH_SHORT).show();
                }else if(updateStatus==UpdateStatus.EmptyField){//此提示只是提醒开发者关注那些必填项，测试成功后，无需对用户提示
                    Toast.makeText(getActivity(), "请检查你AppVersion表的必填项，1、target_size（文件大小）是否填写；2、path或者android_url两者必填其中一项。", Toast.LENGTH_SHORT).show();
                }else if(updateStatus==UpdateStatus.IGNORED){
                    Toast.makeText(getActivity(), "该版本已被忽略更新", Toast.LENGTH_SHORT).show();
                }else if(updateStatus==UpdateStatus.ErrorSizeFormat){
                    Toast.makeText(getActivity(), "请检查target_size填写的格式，请使用file.length()方法获取apk大小。", Toast.LENGTH_SHORT).show();
                }else if(updateStatus==UpdateStatus.TimeOut){
                    Toast.makeText(getActivity(), "查询出错或查询超时", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
