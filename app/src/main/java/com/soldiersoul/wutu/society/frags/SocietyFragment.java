package com.soldiersoul.wutu.society.frags;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.UserBean;
import com.soldiersoul.wutu.society.bean.SocietyBean;
import com.soldiersoul.wutu.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

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
    private ToastUtil toastUtil;

    private UserBean user;

    /**
     * 一个全局的使用社团bean对象，传递给各个fragment
     **/
    private SocietyBean societyBean;

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
    public void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        user = BmobUser.getCurrentUser (UserBean.class);
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        toastUtil = new ToastUtil (getActivity ());
        ButterKnife.bind (this, view);

        //判断用户是否加入社团
        if (user.getSociety ().equals ("")) {
            return;
        }

        //通过user获取所在的社团,如果为空，则自动定位到学校的社团
        String societyName = user.getSociety ();
        if (!societyName.equals ("")) {
            Log.d ("Bmob", "您社团名:" + societyName);
            BmobQuery<SocietyBean> query = new BmobQuery<> ();
            query.addWhereEqualTo ("name", societyName);
            query.findObjects (new FindListener<SocietyBean> () {
                @Override
                public void done (List<SocietyBean> list, BmobException e) {
                    if (e == null && list.size () > 0) {
                        societyBean = list.get (0);
                        Log.d ("Bmob", "社团存在,社团名为" + societyBean.getName ());
                        if (mFragments != null && mFragments.isEmpty ()) {
                            mFragments.add (new SocietyBaseInfoFragment (societyBean));
                            mFragments.add (new SocietyPhotoFragment (societyBean));
                            mFragments.add (new SocietyActFragment (societyBean));
                            mFragments.add (new SocietyIntegralFragment (societyBean));
                        }

                        mAdapter = new MyPagerAdapter (getFragmentManager ());
                        vpSociety.setOffscreenPageLimit (4);
                        vpSociety.setAdapter (mAdapter);
                        stl.setViewPager (vpSociety);
                    } else {
                        toastUtil.toastShort ("查询失败");
                    }
                }
            });
        }
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //判断是当前用户是否包含社团信息，定位移动到个人信息界面
        if (user.getSociety ().equals ("")) {
            return inflater.inflate (R.layout.fragment_society_empty, container, false);
        } else {
            return inflater.inflate (R.layout.fragment_society, container, false);
        }
    }

}
