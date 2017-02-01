package com.soldiersoul.wutu.society;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.soldiersoul.wutu.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 社团Fragment
 */
public class SocietyFragment extends Fragment {

    @BindView (R.id.tl) SlidingTabLayout stl;
    @BindView (R.id.vpSociety) ViewPager vpSociety;

    private static final String TAG = "SocietyFragment";
    private ArrayList<Fragment> mFragments = new ArrayList<> ();
    private final String[] mTitles = {"社团信息", "社团照片", "社团活动", "社团任务"};
    private MyPagerAdapter mAdapter;

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter (FragmentManager fm) {
            super (fm);
        }

        @Override
        public int getCount () {
            return mFragments.size ();
        }

        @Override
        public CharSequence getPageTitle (int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem (int position) {
            return mFragments.get (position);
        }
    }

    public SocietyFragment () {
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);

        //todo:初始化Fragment集合
        if (mFragments != null && mFragments.isEmpty ()) {
            mFragments.add (new SocietyBaseInfoFragment ());
            mFragments.add (new SocietyPhotoFragment ());
            mFragments.add (new SocietyActFragment ());
            mFragments.add (new SocietyIntegralFragment ());
        }

        mAdapter = new MyPagerAdapter (getFragmentManager ());
        vpSociety.setAdapter (mAdapter);
        stl.setViewPager (vpSociety);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_society, container, false);
    }

    //    /**
    //     * 跳转到定位界面
    //     */
    //    @OnClick (R.id.rlLocation)
    //    void gotoLocation () {
    //        startActivity (new Intent (getActivity (), LocationActivity.class));
    //    }
    //
    //    /**
    //     * 社团特色活动
    //     */
    //    @OnClick (R.id.tvActivity)
    //    void goToActivity () {
    //        startActivity (new Intent (getActivity (),SocietyActActivity.class));
    //    }
    //
    //    /**
    //     * 社团荣誉
    //     */
    //    @OnClick (R.id.tvHonor)
    //    void goToHonor () {
    //        startActivity (new Intent (getActivity (),HonorActivity.class));
    //    }
    //
    //    /**
    //     * 社团图片
    //     */
    //    @OnClick (R.id.tvPhoto)
    //    void goToPhoto () {
    //        startActivity (new Intent (getActivity (),PhotoActivity.class));
    //
    //    }
    //
    //    /**
    //     * 社团人员资料
    //     */
    //    @OnClick (R.id.tvMember)
    //    void goToMember () {
    //        startActivity (new Intent (getActivity (),MemberActivity.class));
    //    }
    //
    //    /**
    //     * 社团培训大厅
    //     */
    //    @OnClick (R.id.tvTrain)
    //    void goToTrain () {
    //        startActivity (new Intent (getActivity (),TrainActivity.class));
    //
    //    }
    //
    //    /**
    //     * 我的贡献
    //     */
    //    @OnClick (R.id.tvContribute)
    //    void goToContribute () {
    //        startActivity (new Intent (getActivity (),ContributeActivity.class));
    //
    //    }
    //
    //    /**
    //     * 积分兑换大厅
    //     */
    //    @OnClick (R.id.tvIntegral)
    //    void goToIntegral () {
    //        startActivity (new Intent (getActivity (),IntegralActivity.class));
    //
    //    }


}
