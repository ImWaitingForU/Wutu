package com.soldiersoul.wutu.register;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置密码的Fragment
 */
public class PwdFragment extends Fragment {

    @BindView (R.id.et_pwd1) EditText etPwd1;
    @BindView (R.id.et_pwd2) EditText etPwd2;
    @BindView (R.id.btn_finish_register) Button btnFinish;

    private Handler mHandler;
    private ToastUtil mToastUtil;

    public PwdFragment () {
    }

    public PwdFragment (Handler handler) {
        mHandler = handler;
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
            //TODO:服务器保存密码
        } else {
            mToastUtil.toastShort ("两次输入密码不一致");
        }
    }

}
