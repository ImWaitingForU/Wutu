package com.soldiersoul.wutu.more;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.UserBean;
import com.soldiersoul.wutu.society.LocationActivity;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.views.SimpleUserInfoItem;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;
import de.hdodenhof.circleimageview.CircleImageView;
import io.github.lijunguan.imgselector.ImageSelector;

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

    private UserBean user;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //获取当前用户
//        user = BmobUser.getCurrentUser (UserBean.class);

        //获取传入的用户，显示传入的用户信息，而不是只显示个人用户信息
        user = (UserBean) getIntent ().getSerializableExtra ("user");
        setHomeButtonStaff ("个人信息");
    }

    @Override
    protected void onResume () {
        super.onResume ();
        initUserData ();
    }

    @Override
    public void onBackPressed () {
        super.onBackPressed ();
        this.finish ();
    }

    private void initUserData () {
        itemUserName.setItemName ("用户名");
        itemUserName.setUserData (user.getUsername ());

        itemUserPhone.setItemName ("手机号");
        itemUserPhone.setUserData (user.getMobilePhoneNumber ());

        itemUserSchool.setItemName ("学校");
        itemUserSchool.setUserData (user.getSchool ());

        itemUserSociety.setItemName ("我的社团");
        // TODO: 2017/4/13 判空处理 
        itemUserSociety.setUserData (user.getSociety ().getName ());

        if (!user.getUserAvatar ().equals ("")) {
            Picasso.with (this).load (user.getUserAvatar ()).into (userAvatar);
        } else {
            userAvatar.setImageResource (R.drawable.ic_army);
        }
    }

    /**
     * 跳转到修改头像界面
     */
    @OnClick (R.id.userAvatarLayout)
    public void changeUserAvatar () {
        ImageSelector.getInstance ().setSelectModel (ImageSelector.AVATOR_MODE).setMaxCount (1).setGridColumns (3)
                     .setShowCamera (true).setToolbarColor (getResources ().getColor (R.color.colorPrimary))
                     .startSelect (this);
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
                final String newName = etNewName.getText ().toString ();
                if (!newName.equals ("")) {
                    UserBean saveBean = new UserBean ();
                    saveBean.setUsername (newName);
                    saveBean.update (user.getObjectId (),new UpdateListener () {
                        @Override
                        public void done (BmobException e) {
                            if (e == null) {
                                mToastUtil.toastShort ("修改完成");
                                itemUserName.setUserData (newName);
                            } else {
                                mToastUtil.toastLong (e.getMessage ());
                            }
                        }
                    });
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
        // TODO: 2017/3/14 验证手机号 ？是否允许修改？
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
        //修改学校
        if (requestCode == REQUEST_SCHOOL_CODE && resultCode == RESULT_OK && data != null) {
            String school = data.getStringExtra ("school");
            Log.d ("chan", "onActivityResult: school=" + school);
            if (!school.equals ("")) {
                itemUserSchool.setUserData (school);
                mToastUtil.toastShort ("修改学校成功");
            } else {
                mToastUtil.toastShort ("修改学校失败");
            }
        }

        //修改头像
        // TODO: 2017/4/12 存在网络状况不好时的程序重新进入页面错误。无法上传文件修改头像
        if (requestCode == ImageSelector.REQUEST_SELECT_IMAGE && resultCode == RESULT_OK) {
            final ArrayList<String> imagesPath = data.getStringArrayListExtra (ImageSelector.SELECTED_RESULT);
            if (imagesPath != null) {
                new Thread (){
                    @Override
                    public void run () {
                        super.run ();
                    }
                }.start ();
                final BmobFile bmobFile = new BmobFile (new File (imagesPath.get (0)));
                bmobFile.uploadblock (new UploadFileListener () {
                    @Override
                    public void done (BmobException e) {
                        if (e == null) {
                            UserBean saveBean = new UserBean ();
                            saveBean.setUserAvatar (bmobFile.getFileUrl ());
                            saveBean.update (user.getObjectId (),new UpdateListener () {
                                @Override
                                public void done (BmobException e) {
                                    if (e == null) {
                                        Log.d ("chan","result_ok-------------");
                                        userAvatar.setImageURI (Uri.parse (imagesPath.get (0)));
                                        mToastUtil.toastShort ("修改头像成功~");
                                    } else {
                                        mToastUtil.toastShort ("头像修改失败，请检查网络链接");
                                        e.printStackTrace ();
                                    }
                                }
                            });
                        } else {
                            mToastUtil.toastShort ("上传头像失败");
                            Log.d ("Bmob", e.getMessage ());
                        }
                    }
                });
            }
        }
    }

    /**
     * 修改社团  todo定位后自动修改社团
     */
    @OnClick (R.id.itemUserSociety)
    public void changeUserSociety () {
        mToastUtil.toastLong ("社团到定位学校后自动修改");
        //        AlertDialog.Builder builder = new AlertDialog.Builder (this);
        //        View view = View.inflate (this, R.layout.user_info_changename, null);
        //        final EditText etNewName = (EditText) view.findViewById (R.id.etChangeDialog);
        //        TextView tvTitle = (TextView) view.findViewById (R.id.tvChangeDialog);
        //        tvTitle.setText ("修改社团");
        //        builder.setView (view).setNegativeButton ("取消", new DialogInterface.OnClickListener () {
        //            @Override
        //            public void onClick (DialogInterface dialogInterface, int i) {
        //                dialogInterface.cancel ();
        //                mToastUtil.toastShort ("取消修改");
        //            }
        //        }).setPositiveButton ("修改", new DialogInterface.OnClickListener () {
        //            @Override
        //            public void onClick (DialogInterface dialogInterface, int i) {
        //                // TODO: 2017/3/14 修改社团名
        //                String newSocietyName = etNewName.getText ().toString ();
        //                if (!newSocietyName.equals ("")) {
        //                    itemUserSociety.setUserData (newSocietyName);
        //                    mToastUtil.toastShort ("修改完成");
        //                } else {
        //                    mToastUtil.toastShort ("社团名不能为空");
        //                }
        //            }
        //        }).setCancelable (false).show ();
    }


    @Override
    public int getContentViewId () {
        return R.layout.activity_user_info;
    }
}
