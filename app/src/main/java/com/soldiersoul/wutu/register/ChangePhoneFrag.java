package com.soldiersoul.wutu.register;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.UserBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangePhoneFrag extends Fragment {
    private Handler mHandler;
    private int changedPhone;
    @BindView (R.id.etNewPhone) TextView etNewPhone;
    @BindView (R.id.btnFinishChange) Button btnFinish;

    @OnClick (R.id.btnFinishChange)
    void doChange () {
        BmobUser newUser = new BmobUser ();
        newUser.setMobilePhoneNumber (etNewPhone.getText ().toString ());
        BmobUser bmobUser = BmobUser.getCurrentUser (UserBean.class);
        newUser.update (bmobUser.getObjectId (), new UpdateListener () {
            @Override
            public void done (BmobException e) {
                if (e == null) {
                    Toast.makeText (getActivity (), "修改手机号成功~", Toast.LENGTH_SHORT).show ();
                    getActivity ().finish ();
                }else{
                    Toast.makeText (getActivity (), "修改手机号失败~", Toast.LENGTH_SHORT).show ();
                }
            }
        });

    }

    public ChangePhoneFrag () {
    }

    public ChangePhoneFrag (Handler handler,int changedPhone) {
        this.mHandler = handler;
        this.changedPhone = changedPhone;
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);
        etNewPhone.setText ("待修改手机号:"+changedPhone);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_change_phone, container, false);
    }

}
