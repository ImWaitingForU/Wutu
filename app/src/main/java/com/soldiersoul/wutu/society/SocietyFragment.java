package com.soldiersoul.wutu.society;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soldiersoul.wutu.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 社团Fragment
 */
public class SocietyFragment extends Fragment {

    private static final String TAG = "SocietyFragment";


    public SocietyFragment () {
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_society, container, false);
    }

    /**
     * 跳转到定位界面
     */
    @OnClick (R.id.rlLocation)
    void gotoLocation () {
        startActivity (new Intent (getActivity (), LocationActivity.class));
    }

    /**
     * 社团特色活动
     */
    @OnClick (R.id.tvActivity)
    void goToActivity () {
        startActivity (new Intent (getActivity (),SocietyActActivity.class));
    }

    /**
     * 社团荣誉
     */
    @OnClick (R.id.tvHonor)
    void goToHonor () {
        startActivity (new Intent (getActivity (),HonorActivity.class));
    }

    /**
     * 社团图片
     */
    @OnClick (R.id.tvPhoto)
    void goToPhoto () {
        startActivity (new Intent (getActivity (),PhotoActivity.class));

    }

    /**
     * 社团人员资料
     */
    @OnClick (R.id.tvMember)
    void goToMember () {
        startActivity (new Intent (getActivity (),MemberActivity.class));
    }

    /**
     * 社团培训大厅
     */
    @OnClick (R.id.tvTrain)
    void goToTrain () {
        startActivity (new Intent (getActivity (),TrainActivity.class));

    }

    /**
     * 我的贡献
     */
    @OnClick (R.id.tvContribute)
    void goToContribute () {
        startActivity (new Intent (getActivity (),ContributeActivity.class));

    }

    /**
     * 积分兑换大厅
     */
    @OnClick (R.id.tvIntegral)
    void goToIntegral () {
        startActivity (new Intent (getActivity (),IntegralActivity.class));

    }


}
