package com.soldiersoul.wutu.weapon;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.WeaponBean;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * 展示武器详情的界面
 */
public class WeaponDetailActivity extends BaseActivity {

    @BindView (R.id.tvWeaponTitle) TextView title;
    @BindView (R.id.tvWeaponCountry) TextView country;
    @BindView (R.id.tvWeaponType) TextView type;
    @BindView (R.id.tvWeaponInfo) TextView info;
    @BindView (R.id.tvWeaponInfo2) TextView info2;
    @BindView (R.id.ivWeaponImg1) ImageView img1;
    @BindView (R.id.ivWeaponImg2) ImageView img2;

    private WeaponBean weapon;

    // TODO: 2017/4/26 添加加载失败页面 
    private void setData(){
        title.setText (weapon.getWeaponName ());
        country.setText ("国家:"+weapon.getCountry ());
        type.setText ("类型:"+weapon.getWeaponType ());
        info.setText (weapon.getWeaponInfo ());
        info2.setText (weapon.getWeaponInfo2 ());
        Picasso.with (this).load (weapon.getImg1 ()).into (img1);
        Picasso.with (this).load (weapon.getImg2 ()).into (img2);
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        setHomeButtonStaff ("武器详情");

        //获取传入的武器id
        String objectID = getIntent ().getStringExtra ("weaponId");

        BmobQuery<WeaponBean> query = new BmobQuery<> ();
        query.addWhereEqualTo ("objectId", objectID);
        query.findObjects (new FindListener<WeaponBean> () {
            @Override
            public void done (List<WeaponBean> list, BmobException e) {
                if (e == null){
                    if (weapon==null) weapon = list.get (0);
//                    setHomeButtonStaff (weapon.getWeaponName ());
                    setData ();
                }else{
                    Log.d ("Bmob","武器数据导入失败"+e.getMessage ());
                }
            }
        });
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_weapon_detail;
    }
}


