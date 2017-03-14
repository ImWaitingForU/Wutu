package com.soldiersoul.wutu.more;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.society.LocationActivity;
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
    @BindView (R.id.itemUserSociety) SimpleUserInfoItem itemUserSociety;
    @BindView (R.id.userAvatar) CircleImageView userAvatar;
    @BindView (R.id.userAvatarLayout) RelativeLayout userAvatarLayout;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        setHomeButtonStaff ("个人信息");

        initUserData ();
    }

    private void initUserData () {
        //// TODO: 2017/3/14 填充用户信息数据
        itemUserName.setItemName ("用户名");
        itemUserName.setUserData ("Iwfu");

        itemUserPhone.setItemName ("手机号");
        itemUserPhone.setUserData ("15079192155");

        itemUserSchool.setItemName ("学校");
        itemUserSchool.setUserData ("华东交通大学");

        itemUserSociety.setItemName ("我的社团");
        itemUserSociety.setUserData ("军事爱好者社团");
        userAvatar.setImageResource (R.mipmap.ic_launcher);
    }

    /**
     * 跳转到修改头像界面
     */
    @OnClick (R.id.userAvatarLayout)
    public void changeUserAvatar () {
        //        startActivity ();
    }

    /**
     * 修改用户名
     */
    @OnClick (R.id.itemUserName)
    public void changeUserName () {
        AlertDialog.Builder builder = new AlertDialog.Builder (this);
        View view = View.inflate (this, R.layout.user_info_changename, null);
        final EditText etNewName = (EditText) view.findViewById (R.id.etChangeDialog);
        TextView tvTitle = (TextView) view.findViewById (R.id.tvChangeDialog);
        tvTitle.setText ("修改用户名");
        builder.setView (view).setNegativeButton ("取消", new DialogInterface.OnClickListener () {
            @Override
            public void onClick (DialogInterface dialogInterface, int i) {
                dialogInterface.cancel ();
                mToastUtil.toastShort ("取消修改");
            }
        }).setPositiveButton ("修改", new DialogInterface.OnClickListener () {
            @Override
            public void onClick (DialogInterface dialogInterface, int i) {
                // TODO: 2017/3/14 修改用户名
                mToastUtil.toastShort ("修改完成");
                String newName = etNewName.getText ().toString ();
                if (!newName.equals ("")) {
                    itemUserName.setUserData (newName);
                } else {
                    mToastUtil.toastShort ("用户名不能为空");
                }
            }
        }).setCancelable (false).show ();
    }

    /**
     * 修改手机号
     */
    @OnClick (R.id.itemUserPhone)
    public void changeUserPhone () {
    }


    /**
     * 修改学校（跳转到定位界面修改）
     */
    @OnClick (R.id.itemUserSchool)
    public void changeUserSchool () {
        Intent intent = new Intent (this, LocationActivity.class);
        intent.setFlags (REQUEST_SCHOOL_CODE);
        startActivityForResult (intent, REQUEST_SCHOOL_CODE);
    }

    public static final int REQUEST_SCHOOL_CODE = 1;

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult (requestCode, resultCode, data);
        Log.d ("chan", "onActivityResult: requestCode=" + requestCode + ",resultCode=" + resultCode);
        if (requestCode == REQUEST_SCHOOL_CODE && resultCode == RESULT_OK && data != null) {
            String school = data.getStringExtra ("school");
            Log.d ("chan", "onActivityResult: school="+school);
            if (!school.equals ("")) {
                itemUserSchool.setUserData (school);
                mToastUtil.toastShort ("修改学校成功");
            } else {
                mToastUtil.toastShort ("修改学校失败");
            }
        }
    }

    /**
     * 修改社团
     */
    @OnClick (R.id.itemUserSociety)
    public void changeUserSociety () {
        AlertDialog.Builder builder = new AlertDialog.Builder (this);
        View view = View.inflate (this, R.layout.user_info_changename, null);
        final EditText etNewName = (EditText) view.findViewById (R.id.etChangeDialog);
        TextView tvTitle = (TextView) view.findViewById (R.id.tvChangeDialog);
        tvTitle.setText ("修改社团");
        builder.setView (view).setNegativeButton ("取消", new DialogInterface.OnClickListener () {
            @Override
            public void onClick (DialogInterface dialogInterface, int i) {
                dialogInterface.cancel ();
                mToastUtil.toastShort ("取消修改");
            }
        }).setPositiveButton ("修改", new DialogInterface.OnClickListener () {
            @Override
            public void onClick (DialogInterface dialogInterface, int i) {
                // TODO: 2017/3/14 修改社团名
                String newSocietyName = etNewName.getText ().toString ();
                if (!newSocietyName.equals ("")) {
                    itemUserSociety.setUserData (newSocietyName);
                    mToastUtil.toastShort ("修改完成");
                } else {
                    mToastUtil.toastShort ("社团名不能为空");
                }
            }
        }).setCancelable (false).show ();
    }


    @Override
    public int getContentViewId () {
        return R.layout.activity_user_info;
    }
}
