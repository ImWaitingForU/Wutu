package com.soldiersoul.wutu.weapon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.soldiersoul.wutu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 武器Fragment
 */
public class WeaponFragment extends Fragment implements View.OnClickListener {

    @BindView (R.id.ivPistol)  ImageView ivPistol; //手枪
    @BindView (R.id.ivMusket)  ImageView ivMusket; //冲锋枪
    @BindView (R.id.ivMissile)  ImageView ivMissile; //导弹
    @BindView (R.id.ivTank)  ImageView ivTank; //坦克

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
    }

    private void startActivity(String type) {
        Intent i = new Intent (getActivity (), ShowWeaponActivity.class);
        i.putExtra ("WeaponType",type);
        startActivity (i);
    }

    @Override
    public void onClick (View v) {
        switch (v.getId ()) {
            case R.id.ivPistol:
                startActivity("手枪");
                break;
            case R.id.ivMusket:
                startActivity("冲锋枪");
                break;
            case R.id.ivMissile:
                startActivity("导弹");
                break;
            case R.id.ivTank:
                startActivity("坦克");
                break;
            default:
                break;
        }
    }
}
