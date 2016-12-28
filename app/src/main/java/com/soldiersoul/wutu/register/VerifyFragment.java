package com.soldiersoul.wutu.register;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.views.CountDownButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 接收验证码的Fragment
 */
public class VerifyFragment extends Fragment implements CountDownButton.GetVerifyListener {

    @BindView (R.id.et_register_username) EditText etUsername;
    @BindView (R.id.et_register_verify) EditText etVerify;
    @BindView (R.id.btn_getVerify) CountDownButton btnVerify;
    @BindView (R.id.btn_verify_next) Button btnNext;

    public VerifyFragment () {
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

    @Override
    public void onGettingVerify () {
        Log.d ("chan", "onGettingVerify");
    }
}
