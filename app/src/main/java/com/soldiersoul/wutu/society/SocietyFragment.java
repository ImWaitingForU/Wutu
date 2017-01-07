package com.soldiersoul.wutu.society;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soldiersoul.wutu.R;

/**
 * 社团Fragment
 */
public class SocietyFragment extends Fragment {


    public SocietyFragment () {
        // Required empty public constructor
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_society, container, false);
    }

}
