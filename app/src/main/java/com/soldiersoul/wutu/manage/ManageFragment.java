package com.soldiersoul.wutu.manage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soldiersoul.wutu.R;

/**
 * 时间/目标管理Fragment
 */
public class ManageFragment extends Fragment {


    public ManageFragment () {
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_manage, container, false);
    }

}
