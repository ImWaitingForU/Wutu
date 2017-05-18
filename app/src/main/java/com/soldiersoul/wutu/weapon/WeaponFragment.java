package com.soldiersoul.wutu.weapon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.soldiersoul.wutu.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 武器Fragment
 */
public class WeaponFragment extends Fragment implements View.OnClickListener {

    @BindView (R.id.ivPistol) ImageView ivPistol; //手枪
    @BindView (R.id.ivMusket) ImageView ivMusket; //冲锋枪
    @BindView (R.id.ivMissile) ImageView ivMissile; //导弹
    @BindView (R.id.ivTank) ImageView ivTank; //坦克
    @BindView (R.id.ivJujiqiang) ImageView ivJuji; //狙击枪

    @BindView (R.id.tvPistol) TextView tvPistol;
    @BindView (R.id.tvMusket) TextView tvMusket;
    @BindView (R.id.tvMissile) TextView tvMissile;
    @BindView (R.id.tvTank) TextView tvTank;
    @BindView (R.id.tvJujiqiang) TextView tvJuji;

    public WeaponFragment () {
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_weapon, container, false);
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);
        ivPistol.setOnClickListener (this);
        ivMusket.setOnClickListener (this);
        ivMissile.setOnClickListener (this);
        ivTank.setOnClickListener (this);
        ivJuji.setOnClickListener (this);

        tvPistol.setOnClickListener (this);
        tvMusket.setOnClickListener (this);
        tvMissile.setOnClickListener (this);
        tvTank.setOnClickListener (this);
        tvJuji.setOnClickListener (this);
    }

    private void startActivity (String type) {
        Intent i = new Intent (getActivity (), ShowWeaponActivity.class);
        i.putExtra ("WeaponType", type);
        startActivity (i);
    }

    @Override
    public void onClick (View v) {
        if (v.getId () == R.id.ivPistol || v.getId () == R.id.tvPistol) {
            startActivity ("手枪");
        } else if (v.getId () == R.id.ivMusket || v.getId () == R.id.tvMusket) {
            startActivity ("步枪");
        } else if (v.getId () == R.id.ivMissile || v.getId () == R.id.tvMissile) {
            startActivity ("导弹");
        } else if (v.getId () == R.id.ivTank || v.getId () == R.id.tvTank) {
            startActivity ("坦克");
        } else if (v.getId () == R.id.tvJujiqiang || v.getId () == R.id.tvJujiqiang) {
            startActivity ("狙击枪");
        }
    }
}
