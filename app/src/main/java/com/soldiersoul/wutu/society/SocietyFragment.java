package com.soldiersoul.wutu.society;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soldiersoul.wutu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 社团Fragment
 */
public class SocietyFragment extends Fragment {

    private static final String TAG = "SocietyFragment";

    @BindView (R.id.rvSocietyList) RecyclerView rvSocietyList;

    /**
     * 添加新社团
     */
    @OnClick (R.id.ivAdd)
    void addNewSociety () {
        Log.d (TAG, "--addNewSociety--");
    }

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

}
