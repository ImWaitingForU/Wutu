package com.soldiersoul.wutu.military;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soldiersoul.wutu.R;

/**
 * 军事天地Fragment
 */
public class MilitaryFragment extends Fragment {


    public MilitaryFragment () {
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_military, container, false);
    }

}
