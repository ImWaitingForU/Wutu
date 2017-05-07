package com.soldiersoul.wutu.weapon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.UserBean;
import com.soldiersoul.wutu.beans.WeaponBean;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * 武器展示Activity
 * <p>
 * 暂时使用图文列表代替3d模型
 */
public class ShowWeaponActivity extends BaseActivity {

    //    private boolean supportsEs2;
    //    private GLView glView;
    //    private float rotateDegree = 0;
    //    private GLRenderer glRenderer;
    //    private SeekBar seekBar;

    @BindView (R.id.rvWeapon) RecyclerView rvWeapon;

    private List<WeaponBean> weaponList;
    private WeaponAdapter adapter;

    private UserBean currentUser;


    //根据传递的武器类型加载不同信息
    @Override
    protected void onCreate (Bundle savedInstanceSate) {
        super.onCreate (savedInstanceSate);
        //        checkSupported();

        currentUser = BmobUser.getCurrentUser (UserBean.class);

        //判断武器类型，加载不同数据
        Intent i = getIntent ();
        String type = i.getStringExtra ("WeaponType");
        if (i != null && !type.equals ("")) {
            setHomeButtonStaff (type);
            loadDate (type);
        }

        rvWeapon.setLayoutManager (
                new LinearLayoutManager (ShowWeaponActivity.this, LinearLayoutManager.VERTICAL, false));
        rvWeapon.addOnItemTouchListener (new OnItemChildClickListener () {
            @Override
            public void SimpleOnItemChildClick (BaseQuickAdapter baseQuickAdapter, View view, int i) {
                if (view.getId () == R.id.rlWeapon) {
                    //跳转到武器详细介绍界面,传入武器的id
                    Intent intent = new Intent (ShowWeaponActivity.this, WeaponDetailActivity.class);
                    intent.putExtra ("weaponId", weaponList.get (i).getObjectId ());
                    startActivity (intent);
                } else if (view.getId () == R.id.ivLike) {

                }
            }
        });


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
        query.addWhereEqualTo ("weaponType", type);
        Log.d ("Bmob", "WeaponType===" + type);
        query.findObjects (new FindListener<WeaponBean> () {
            @Override
            public void done (List<WeaponBean> list, BmobException e) {
                if (e == null) {
                    Log.d ("Bmob", "加载武器数据成功" + list.size ());
                    weaponList = list;

                    if (adapter == null) {
                        adapter = new WeaponAdapter ();
                        adapter.setEmptyView (View.inflate (ShowWeaponActivity.this, R.layout
                                .weaponlist_empty_layout, null));
                        rvWeapon.setAdapter (adapter);
                    } else {
                        adapter.notifyDataSetChanged ();
                    }

                } else {
                    Log.d ("Bmob", "加载武器数据失败:" + e.getMessage ());
                    mToastUtil.toastShort ("加载数据出了点问题，请稍后再来吧~");
                }
            }
        });
    }

    public class WeaponAdapter extends BaseQuickAdapter<WeaponBean> {


        public WeaponAdapter () {
            super (R.layout.weapon_list_layout, weaponList);
        }

        @Override
        protected void convert (final BaseViewHolder baseViewHolder, WeaponBean weaponBean) {
            baseViewHolder.setText (R.id.tvWeaponTitle, weaponBean.getWeaponName ())
                          .setText (R.id.tvWeaponCountry, weaponBean.getCountry ()).
                                  addOnClickListener (R.id.rlWeapon).
                                  addOnClickListener (R.id.ivLike);

            Picasso.with (ShowWeaponActivity.this).load (weaponBean.getImg1 ())
                   .into ((ImageView) baseViewHolder.getConvertView ().findViewById (R.id.ivWeaponImg));

            //            baseViewHolder.getView (R.id.rlWeapon).setOnClickListener (new View.OnClickListener () {
            //                @Override
            //                public void onClick (View v) {
            //                    Intent intent = new Intent(ShowWeaponActivity.this,WeaponDetailActivity.class);
            //                    intent.putExtra ("weaponId",weaponList.get (i).getObjectId ());
            //                    startActivity (intent);
            //                }
            //            });

            LikeButton likeButton = baseViewHolder.getView (R.id.ivLike);
            //根据收藏情况展示不同的心形布局
            Log.d ("Bmob", "武器收藏UserBean==" + weaponBean.getUserBean ().getObjectId ());
            if (weaponBean.getUserBean ().getObjectId ().equals (currentUser.getObjectId ())) {
                likeButton.setLiked (true);
                Log.d ("Bmob", "已收藏");
            } else {
                likeButton.setLiked (false);
                Log.d ("Bmob", "未收藏");
            }

            // TODO: 2017/4/27 添加武器收藏界面
            likeButton.setOnLikeListener (new OnLikeListener () {
                @Override
                public void liked (LikeButton likeButton) {
                    Log.d ("chan", "like");
                    doLike (baseViewHolder.getPosition ());
                }

                @Override
                public void unLiked (LikeButton likeButton) {
                    Log.d ("chan", "unLiked");
                    doUnLike (baseViewHolder.getPosition ());
                }
            });
        }

    }

    /**
     * 添加到收藏
     */
    private void doLike (int position) {
        Log.d ("Bmob", "position===" + position);
        WeaponBean weapon = new WeaponBean ();
        WeaponBean curWeapon = weaponList.get (position);
        Log.d ("Bmob", "weapon===" + curWeapon.toString ());
        weapon.setUserBean (currentUser);
        weapon.update (curWeapon.getObjectId (), new UpdateListener () {
            @Override
            public void done (BmobException e) {
                if (e == null) {
                    mToastUtil.toastShort ("收藏成功");
                    Log.d ("Bmob", "收藏成功");
                } else {
                    mToastUtil.toastShort ("添加收藏失败，请检查网络");
                    Log.d ("Bmob", "添加收藏失败===" + e.getMessage ());
                }
            }
        });
    }

    /**
     * 移除收藏
     */
    private void doUnLike (int position) {
        WeaponBean weapon = new WeaponBean ();
        WeaponBean curWeapon = weaponList.get (position);
        //需要new新的userbean，不能直接设置为空。
        weapon.setUserBean (new UserBean ());
        weapon.update (curWeapon.getObjectId (), new UpdateListener () {
            @Override
            public void done (BmobException e) {
                if (e == null) {
                    mToastUtil.toastShort ("取消收藏");
                    Log.d ("Bmob", "取消收藏");
                } else {
                    mToastUtil.toastShort ("取消收藏失败，请检查网络");
                    Log.d ("Bmob", "取消收藏失败===" + e.getMessage ());
                }
            }
        });
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
