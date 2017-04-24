package com.soldiersoul.wutu.weapon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.WeaponBean;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.weapon.openGL.GLRenderer;
import com.soldiersoul.wutu.weapon.openGL.GLView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * 武器展示Activity
 * <p>
 * 暂时使用图文列表代替3d模型
 */
public class ShowWeaponActivity extends BaseActivity {

    private boolean supportsEs2;
    private GLView glView;
    private float rotateDegree = 0;
    private GLRenderer glRenderer;
    private SeekBar seekBar;

    @BindView (R.id.rvWeapon) RecyclerView rvWeapon;

    private List<WeaponBean> weaponList;
    private WeaponAdapter adapter ;


    //根据传递的武器类型加载不同信息
    @Override
    protected void onCreate (Bundle savedInstanceSate) {
        super.onCreate (savedInstanceSate);
        //        checkSupported();

        //判断武器类型，加载不同数据
        Intent i = getIntent ();
        String type = i.getStringExtra ("WeaponType");
        if (i!=null && !type.equals ("")){
            setHomeButtonStaff (type);
            loadDate (type);
        }


        //        seekBar = (SeekBar) findViewById(R.id.seekBar);
        //        if (supportsEs2) {
        //            glView = (GLView) findViewById(R.id.glView);
        //            glRenderer = new GLRenderer(this);
        //            glView.setRenderer(glRenderer);
        //
        //        } else {
        //
        //            Toast.makeText(this, "当前设备不支持OpenGL ES 2.0!", Toast.LENGTH_SHORT).show();
        //        }
        //        seekBar.setMax(100);
        //
        //        seekBar.setProgress(80);
        //        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        //            @Override
        //            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //                glRenderer.setScale(1f * progress / 100);
        //            }
        //
        //            @Override
        //            public void onStartTrackingTouch(SeekBar seekBar) {
        //
        //            }
        //
        //            @Override
        //            public void onStopTrackingTouch(SeekBar seekBar) {
        //
        //            }
        //        });
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_show_weapon;
    }

    /**
     * 根据类型做筛选
     */
    private void loadDate (String type) {
        BmobQuery<WeaponBean> query = new BmobQuery<> ();
        query.addWhereEqualTo ("WeaponType", type);
        query.findObjects (new FindListener<WeaponBean> () {
            @Override
            public void done (List<WeaponBean> list, BmobException e) {
                if (e == null) {
                    Log.d ("Bmob","加载武器数据成功");
                    weaponList = list;
                    rvWeapon.setLayoutManager (new LinearLayoutManager (ShowWeaponActivity.this,LinearLayoutManager.VERTICAL,false));
                    rvWeapon.setAdapter (new WeaponAdapter (R.layout.weapon_list_layout,list));
                    rvWeapon.addOnItemTouchListener (new OnItemChildClickListener () {
                        @Override
                        public void SimpleOnItemChildClick (BaseQuickAdapter baseQuickAdapter, View view, int i) {
                        }
                    });
                } else {
                    Log.d ("Bmob","加载武器数据失败:"+e.getMessage ());
                }
            }
        });
    }

    public class WeaponAdapter extends BaseQuickAdapter<WeaponBean>{


        public WeaponAdapter (int layoutResId, List<WeaponBean> data) {
            super (layoutResId, data);
        }

        @Override
        protected void convert (BaseViewHolder baseViewHolder, WeaponBean weaponBean) {
            baseViewHolder.setText (R.id.tvWeaponTitle, weaponBean.getWeaponName ())
                          .setText (R.id.tvCountry, weaponBean.getCountry ())
                          .addOnClickListener (R.id.rlWeapon);

            Picasso.with (ShowWeaponActivity.this).load (weaponBean.getImg1 ())
                   .into ((ImageView) baseViewHolder.getConvertView ().findViewById (R.id.ivWeaponImg));
        }

    }

//    public void rotate (float degree) {
//        glRenderer.rotate (degree);
//        glView.invalidate ();
//    }
//
//    private Handler handler = new Handler () {
//        @Override
//        public void handleMessage (Message msg) {
//            rotate (rotateDegree);
//        }
//    };

    @Override
    protected void onResume () {
        super.onResume ();
        //        glRenderer.setScale(0.8f);
        //        if (glView != null) {
        //            glView.onResume();
        //
        //            //不断改变rotateDegreen值，实现旋转
        //            new Thread() {
        //                @Override
        //                public void run() {
        //                    while (true) {
        //                        try {
        //                            sleep(100);
        //
        //                            rotateDegree += 5;
        //                            handler.sendEmptyMessage(0x001);
        //                        } catch (Exception e) {
        //                            e.printStackTrace();
        //                        }
        //
        //                    }
        //                }
        //            }.start();
        //        }


    }

//    private void checkSupported () {
//        ActivityManager activityManager = (ActivityManager) getSystemService (ACTIVITY_SERVICE);
//        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo ();
//        supportsEs2 = configurationInfo.reqGlEsVersion >= 0x2000;
//
//        boolean isEmulator = Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1 &&
//                (Build.FINGERPRINT.startsWith ("generic") || Build.FINGERPRINT.startsWith ("unknown") ||
//                        Build.MODEL.contains ("google_sdk") || Build.MODEL.contains ("Emulator") ||
//                        Build.MODEL.contains ("Android SDK built for x86"));
//
//        supportsEs2 = supportsEs2 || isEmulator;
//    }
//
//    @Override
//    protected void onPause () {
//        super.onPause ();
//        //        if (glView != null) {
//        //            glView.onPause();
//        //        }
//    }

}
