package com.soldiersoul.wutu.society.frags;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.UserBean;
import com.soldiersoul.wutu.society.PhotoActivity;
import com.soldiersoul.wutu.society.bean.SocietyAlbumBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * 社团照片界面
 */
public class SocietyPhotoFragment extends Fragment {

    @BindView (R.id.rvSocietyPhoto) RecyclerView rvSocietyPhoto;
    private List<SocietyAlbumBean> dataList = new ArrayList<> ();
    private SocietyPhotoAlbumAdapter adapter;

    public SocietyPhotoFragment () {
    }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_society_photo, container, false);
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);
        BmobQuery<SocietyAlbumBean> query = new BmobQuery<> ();
        //获取到的Id是"  xxx",所以要去除空格
        Log.d ("Bmob","pointer Id==="+BmobUser.getCurrentUser (UserBean.class).getSociety ().getObjectId ().trim ());
        query.addWhereEqualTo ("societyBean", BmobUser.getCurrentUser (UserBean.class).getSociety ().getObjectId ().trim ());
        query.findObjects (new FindListener<SocietyAlbumBean> () {
            @Override
            public void done (List<SocietyAlbumBean> list, BmobException e) {
                if (e == null) {
                    dataList = list;
                    adapter = new SocietyPhotoAlbumAdapter ();
                    adapter.notifyDataSetChanged ();
                    rvSocietyPhoto.setAdapter (adapter);
                    adapter.setEmptyView (View.inflate (getActivity (), R.layout.societyalbum_empty_layout, null));
                    rvSocietyPhoto.setLayoutManager (new LinearLayoutManager (getActivity ()));
                    rvSocietyPhoto.addOnItemTouchListener (new OnItemChildClickListener () {
                        @Override
                        public void SimpleOnItemChildClick (BaseQuickAdapter baseQuickAdapter, View view, int i) {
                            //跳转到相册展示界面
                            Intent intent = new Intent (getActivity (), PhotoActivity.class);
                            intent.putExtra ("albumName", dataList.get (i).getAlbumName ());
                            intent.putExtra ("albumId", dataList.get (i).getObjectId ());
                            startActivity (intent);
                        }
                    });
                    Log.d ("Bmob", "dataList===" + list.size ());
                } else {
                    Log.d ("Bmob", e.getMessage ());
                }
            }
        });

    }

    /**
     * 社团照片封面Adapter
     */
    public class SocietyPhotoAlbumAdapter extends BaseQuickAdapter<SocietyAlbumBean> {

        public SocietyPhotoAlbumAdapter () {
            super (R.layout.society_photo_album, dataList);
        }

        @Override
        protected void convert (BaseViewHolder baseViewHolder, SocietyAlbumBean societyAlbumBean) {
            Log.d ("chan", "SocietyPhotoAlbumAdapter===");
            baseViewHolder.setText (R.id.tvAlbumName, societyAlbumBean.getAlbumName ())
                          .setText (R.id.tvAlbumTime, societyAlbumBean.getAlbumTime ())
                          .addOnClickListener (R.id.cvAlbum);

            Picasso.with (getActivity ()).load (societyAlbumBean.getAlbumLogoPath ())
                   .into ((ImageView) baseViewHolder.getConvertView ().findViewById (R.id.ivAlbumLogo));
        }
    }

}


