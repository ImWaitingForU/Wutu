package com.soldiersoul.wutu.weapon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soldiersoul.wutu.R;

/**
 * @deprecated
 * 时间/目标管理Fragment
 *
 * 武器Fragment
 */
public class ManageFragment extends Fragment {


    public ManageFragment () {
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_manage, container, false);
    }

}
