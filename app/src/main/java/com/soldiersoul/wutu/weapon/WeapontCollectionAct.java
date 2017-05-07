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

/*武器收藏界面~*/
public class WeapontCollectionAct extends BaseActivity {
    @BindView (R.id.rvWeaponCollection) RecyclerView rvWeaponCollection;
    private List<WeaponBean> weaponList;
    private WeaponAdapter adapter;
    private UserBean currentUser;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setHomeButtonStaff ("武器收藏");
        currentUser = BmobUser.getCurrentUser (UserBean.class);

        rvWeaponCollection.setLayoutManager (new LinearLayoutManager (this, LinearLayoutManager.VERTICAL, false));
        rvWeaponCollection.addOnItemTouchListener (new OnItemChildClickListener () {
            @Override
            public void SimpleOnItemChildClick (BaseQuickAdapter baseQuickAdapter, View view, int i) {
                if (view.getId () == R.id.rlWeapon || view.getId () == R.id.tvWeaponTitle ||
                        view.getId () == R.id.tvWeaponCountry || view.getId () == R.id.ivWeaponImg) {
                    //跳转到武器详细介绍界面,传入武器的id
                    Intent intent = new Intent (WeapontCollectionAct.this, WeaponDetailActivity.class);
                    intent.putExtra ("weaponId", weaponList.get (i).getObjectId ());
                    startActivity (intent);
                } else if (view.getId () == R.id.ivLike) {
                    //避免使用外部布局时会和收藏按钮产生冲突
                }
            }
        });
        getData (currentUser.getObjectId ());
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_weapont_collection;
    }

    public class WeaponAdapter extends BaseQuickAdapter<WeaponBean> {


        public WeaponAdapter () {
            super (R.layout.weapon_list_layout, weaponList);
        }

        @Override
        protected void convert (final BaseViewHolder baseViewHolder, WeaponBean weaponBean) {
            baseViewHolder.setText (R.id.tvWeaponTitle, weaponBean.getWeaponName ())
                          .setText (R.id.tvWeaponCountry, weaponBean.getCountry ()).
                                  addOnClickListener (R.id.tvWeaponTitle).
                                  addOnClickListener (R.id.tvWeaponCountry).
                                  addOnClickListener (R.id.ivWeaponImg).
                                  addOnClickListener (R.id.ivLike);

            Picasso.with (WeapontCollectionAct.this).load (weaponBean.getImg1 ())
                   .into ((ImageView) baseViewHolder.getConvertView ().findViewById (R.id.ivWeaponImg));


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
    public void doLike (int position) {
        Log.d ("Bmob", "position===" + position);
        WeaponBean weapon = new WeaponBean ();
        WeaponBean curWeapon = weaponList.get (position);
        Log.d ("Bmob", "weapon===" + curWeapon.toString ());
        weapon.setUserBean (BmobUser.getCurrentUser (UserBean.class));
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
    public void doUnLike (int position) {
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

    private void getData (String userBean) {
        BmobQuery<WeaponBean> query = new BmobQuery<> ();
        query.addWhereEqualTo ("userBean", userBean);
        Log.d ("Bmob", "userBean===" + userBean);
        query.findObjects (new FindListener<WeaponBean> () {
            @Override
            public void done (List<WeaponBean> list, BmobException e) {
                if (e == null) {
                    Log.d ("Bmob", "加载武器收藏成功" + list.size ());
                    weaponList = list;

                    if (adapter == null) {
                        adapter = new WeaponAdapter ();
                        adapter.setEmptyView (
                                View.inflate (WeapontCollectionAct.this, R.layout.weaponlist_empty_layout, null));
                        rvWeaponCollection.setAdapter (adapter);
                    } else {
                        adapter.notifyDataSetChanged ();
                    }

                } else {
                    Log.d ("Bmob", "加载武器收藏数据失败:" + e.getMessage ());
                    mToastUtil.toastShort ("加载数据出了点问题，请稍后再来吧~");
                }
            }
        });
    }
}
