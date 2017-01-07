package com.soldiersoul.wutu.military;


import android.os.Bundle;
<<<<<<< HEAD
import android.support.v4.app.Fragment;
=======
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
>>>>>>> Chan
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soldiersoul.wutu.R;

<<<<<<< HEAD
=======
import butterknife.BindView;
import butterknife.ButterKnife;

>>>>>>> Chan
/**
 * 军事天地Fragment
 */
public class MilitaryFragment extends Fragment {

<<<<<<< HEAD
=======
    @BindView (R.id.toolbar) Toolbar mToolbar;
>>>>>>> Chan

    public MilitaryFragment () {
    }

<<<<<<< HEAD
=======
    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);
        ((AppCompatActivity) getActivity ()).setSupportActionBar (mToolbar);
        ((AppCompatActivity) getActivity ()).getSupportActionBar ().setTitle ("");

    }
>>>>>>> Chan

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_military, container, false);
    }

}
