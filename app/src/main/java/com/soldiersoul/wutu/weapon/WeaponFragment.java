package com.soldiersoul.wutu.weapon;

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
 * 武器Fragment
 */
public class WeaponFragment extends Fragment {

	public WeaponFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_weapon, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.bind(this, view);
	}


    @OnClick(R.id.ivPistol)
	public void goPisto() {
        Intent i = new Intent (getActivity (),ShowWeaponActivity.class);
        startActivity (i);
	}

}
