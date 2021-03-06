package com.soldiersoul.wutu.register;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.UserBean;
import com.soldiersoul.wutu.home.MainActivity;
import com.soldiersoul.wutu.login.LoginActivity;
import com.soldiersoul.wutu.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * 设置密码的Fragment
 */
public class PwdFragment extends Fragment {

    @BindView (R.id.et_pwd1) EditText etPwd1;
    @BindView (R.id.et_pwd2) EditText etPwd2;
    @BindView (R.id.btn_finish_register) Button btnFinish;

    private Handler mHandler;
    private ToastUtil mToastUtil;
    private String userName;
    private Boolean isFindPwd;
    private int verifyCode;

    public PwdFragment () {
    }

    public PwdFragment (Handler handler, Object userName, Boolean isFindPwd, int verifyCode) {
        mHandler = handler;
        this.userName = (String) userName;
        this.isFindPwd = isFindPwd;
        this.verifyCode = verifyCode;
    }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        mToastUtil = new ToastUtil (getActivity ());
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_pwd, container, false);
    }

    @OnClick (R.id.btn_finish_register)
    public void finish () {
        String pwd1 = etPwd1.getText ().toString ();
        String pwd2 = etPwd2.getText ().toString ();
        if (pwd1.equals (pwd2)) {
            final UserBean user = new UserBean ("", "", null, "");
            user.setMobilePhoneNumber (userName);
            //初始用户名就是电话
            user.setUsername (userName);
            user.setPassword (etPwd2.getText ().toString ());
            //是注册还是修改密码
            if (isFindPwd) {
                Log.d ("Bmob", "pwd:" + String.valueOf (verifyCode));
                //更新密码
                BmobUser.resetPasswordBySMSCode (String.valueOf (verifyCode), etPwd2.getText ().toString (),
                                                 new UpdateListener () {
                                                     @Override
                                                     public void done (BmobException e) {
                                                         if (e == null) {
                                                             Intent intent =
                                                                     new Intent (getActivity (), LoginActivity.class);
                                                             startActivity (intent);
                                                             getActivity ().finish ();
                                                             mToastUtil.toastShort ("修改密码成功,请用新密码登陆吧。");
                                                         } else {
                                                             mToastUtil.toastShort ("修改密码失败~");
                                                             Log.d ("Bmob", e.getMessage ());
                                                         }
                                                     }
                                                 });


            } else {
                user.signUp (new SaveListener<String> () {
                    @Override
                    public void done (String s, BmobException e) {
                        if (e == null) {
                            mToastUtil.toastShort ("注册成功");
                            Intent intent = new Intent (getActivity (), MainActivity.class);
                            intent.setFlags (Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity (intent);
                            getActivity ().finish ();
                        } else {
                            // TODO: 2017/4/10 遗留一个bug，注册成功但是报错
                            mToastUtil.toastShort (e.getMessage ());
                            Log.d ("Bmob", "done: 注册失败" + e.getMessage ());
                            return;
                        }
                    }
                });
            }

        } else {
            mToastUtil.toastShort ("两次输入密码不一致");
            return;
        }

        //        AlertDialog.Builder builder = new AlertDialog.Builder (getActivity ());
        //        builder.setMessage ("恭喜您注册成功，现在去完善资料吧!").setCancelable (false)
        //               .setNegativeButton ("以后再说", new DialogInterface.OnClickListener () {
        //                   @Override
        //                   public void onClick (DialogInterface dialog, int which) {
        //                       //TODO:点击取消，进行登录，跳转到主界面
        //                       Intent intent = new Intent (getActivity (), MainActivity.class);
        //                       intent.setFlags (Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //                       startActivity (intent);
        //                       mToastUtil.toastShort ("注册成功");
        //                       getActivity ().finish ();
        //                   }
        //               }).setPositiveButton ("去完善", new DialogInterface.OnClickListener () {
        //            @Override
        //            public void onClick (DialogInterface dialog, int which) {
        //                //TODO:点击去完善，进行登录，跳转到完善信息界面
        //                Intent intent = new Intent (getActivity (), PerfectInfoActivity.class);
        //                //TODO:在完善信息界面判断如果是由注册界面跳转过去，返回则跳转到首页。
        //                intent.putExtra (PerfectInfoActivity.FROMWHERE, PerfectInfoActivity.REGISTER_TO_INFO);
        //                startActivity (intent);
        //                getActivity ().finish ();
        //            }
        //        }).show ();

    }

}
