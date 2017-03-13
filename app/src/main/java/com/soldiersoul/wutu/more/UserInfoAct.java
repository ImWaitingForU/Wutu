package com.soldiersoul.wutu.more;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.views.SimpleUserInfoItem;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 用户信息界面
 */
public class UserInfoAct extends BaseActivity {

    @BindView (R.id.itemUserName) SimpleUserInfoItem itemUserName;
    @BindView (R.id.itemUserPhone) SimpleUserInfoItem itemUserPhone;
    @BindView (R.id.itemUserSchool) SimpleUserInfoItem itemUserSchool;
    @BindView (R.id.userAvatar) CircleImageView userAvatar;
    @BindView (R.id.userAvatarLayout) RelativeLayout userAvatarLayout;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        getSupportActionBar ().setTitle ("个人信息");
        getSupportActionBar ().setHomeButtonEnabled (true);

        initUserData ();
    }

    private void initUserData () {
        itemUserName.setItemName ("用户名");
        itemUserName.setUserData ("Iwfu");

        itemUserPhone.setItemName ("手机号");
        itemUserPhone.setUserData ("15079192155");

        itemUserSchool.setItemName ("学校");
        itemUserSchool.setUserData ("华东交通大学");

        userAvatar.setImageResource (R.mipmap.ic_launcher);
    }

    /**
     * 跳转到修改头像界面
     */
    @OnClick (R.id.userAvatarLayout)
    public void changeUserAvatar () {
        startActivity ();
    }

    /**
     * 修改用户名
     */
    @OnClick (R.id.itemUserName)
    public void changeUserName () {

    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_user_info;
    }
}
