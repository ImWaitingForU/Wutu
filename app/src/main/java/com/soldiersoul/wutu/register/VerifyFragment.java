package com.soldiersoul.wutu.register;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.UserBean;
import com.soldiersoul.wutu.views.CountDownButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.sms.BmobSMS;
import cn.bmob.sms.exception.BmobException;
import cn.bmob.sms.listener.RequestSMSCodeListener;
import cn.bmob.sms.listener.VerifySMSCodeListener;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * 接收验证码的Fragment
 */
public class VerifyFragment extends Fragment implements CountDownButton.GetVerifyListener {

    @BindView (R.id.et_register_username) EditText etUsername;
    @BindView (R.id.et_register_verify) EditText etVerify;
    @BindView (R.id.btn_getVerify) CountDownButton btnVerify;
    @BindView (R.id.btn_verify_next) Button btnNext;

    private Handler mHandler;
    private static boolean isUsedPhone;
    public static final int VERIFY_SUCCESS = 0x111;
    private Boolean isFindPwd;

    private int smsCode;

    public VerifyFragment () {
    }

    public VerifyFragment (Handler handler, Boolean isFindPwd) {
        this.mHandler = handler;
        this.isFindPwd = isFindPwd;
    }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_verify, null, false);
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);
        btnVerify.setVerifyListener (this);
    }

    @Override
    public void onDestroy () {
        super.onDestroy ();
        btnVerify.cancelCountDown ();
    }

    /**
     * 检查手机号是否已经被注册
     *
     * @return
     */
    private boolean isUsedPhone (String phoneNumber) {
        BmobQuery<UserBean> query = new BmobQuery<> ();
        query.addWhereEqualTo ("mobilePhoneNumber", phoneNumber);
        query.findObjects (new FindListener<UserBean> () {
            @Override
            public void done (List<UserBean> list, cn.bmob.v3.exception.BmobException e) {
                if (list.size () > 0) {
                    isUsedPhone = true;
                } else {
                    isUsedPhone = false;
                }
            }
        });
        return isUsedPhone;
    }

    @Override
    public void onGettingVerify () {
        String userName = etUsername.getText ().toString ();
        if (!isFindPwd && isUsedPhone (userName)) {
            Toast.makeText (getActivity (), "手机号已被注册", Toast.LENGTH_SHORT).show ();
            return;
        }

        BmobSMS.requestSMSCode (getActivity (), userName, "WutuSms", new RequestSMSCodeListener () {

            @Override
            public void done (Integer smsId, BmobException ex) {
                if (ex == null) {//验证码发送成功
                    Log.i ("bmob", "短信id：" + smsId);//用于查询本次短信发送详情
                    Toast.makeText (getActivity (), "验证码发送成功", Toast.LENGTH_SHORT).show ();
                    smsCode = smsId;
                    btnVerify.startCountDown ();
                } else {
                    Log.e ("bmob", ex.getMessage ());
                    Toast.makeText (getActivity (), "验证码发送失败，请检查手机号是否正确", Toast.LENGTH_SHORT).show ();
                }
            }
        });
    }

    /**
     * 验证验证码并跳转到下一步
     */
    @OnClick (R.id.btn_verify_next)
    public void next () {
        final String userName = etUsername.getText ().toString ();
        final String verifyCode = etVerify.getText ().toString ();
        //如果是修改密码就不验证，否则验证码会失效
        if (isFindPwd && smsCode != 0 && !verifyCode.equals ("")) {
            Message message = new Message ();
            message.what = VERIFY_SUCCESS;
            message.arg1 = Integer.parseInt (verifyCode);
            message.obj = userName;
            mHandler.sendMessage (message);
        } else {
            BmobSMS.verifySmsCode (getActivity (), userName, verifyCode, new VerifySMSCodeListener () {

                @Override
                public void done (BmobException ex) {
                    if (ex == null) {//短信验证码已验证成功
                        Log.i ("bmob", "验证通过");
                        Toast.makeText (getActivity (), "验证通过", Toast.LENGTH_SHORT).show ();
                        Message message = new Message ();
                        message.what = VERIFY_SUCCESS;
                        message.arg1 = Integer.parseInt (verifyCode);
                        message.arg2 = Integer.parseInt (userName);
                        message.obj = userName;

                        mHandler.sendMessage (message);
                    } else {
                        Log.i ("bmob", "验证失败：code =" + ex.getErrorCode () + ",msg = " + ex.getLocalizedMessage ());
                        Toast.makeText (getActivity (), "验证码错误", Toast.LENGTH_SHORT).show ();
                    }
                }
            });
        }
    }

}
