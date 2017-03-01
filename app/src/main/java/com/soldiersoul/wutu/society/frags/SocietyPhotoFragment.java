package com.soldiersoul.wutu.society.frags;


import java.util.ArrayList;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.society.PhotoActivity;
import com.soldiersoul.wutu.society.bean.SocietyPhotoAlbumBean;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 社团照片界面
 */
public class SocietyPhotoFragment extends Fragment {

    @BindView (R.id.rvSocietyPhoto) RecyclerView rvSocietyPhoto;
    private ArrayList<SocietyPhotoAlbumBean> dataList = new ArrayList<> ();
    private SocietyPhotoAlbumAdapter adapter;

    public SocietyPhotoFragment () {
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataList.add (new SocietyPhotoAlbumBean ("albumName1", "2016-1-1",null, "aaaa"));
        dataList.add (new SocietyPhotoAlbumBean ("albumName2", "2016-1-2",null, "bbbb"));
        dataList.add (new SocietyPhotoAlbumBean ("albumName3", "2016-1-3",null, "cccc"));
        adapter = new SocietyPhotoAlbumAdapter ();
        return inflater.inflate (R.layout.fragment_society_photo, container, false);
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);

        adapter.setEmptyView (View.inflate (getActivity (), R.layout.societyalbum_empty_layout, null));
        rvSocietyPhoto.setLayoutManager (new LinearLayoutManager (getActivity ()));
        rvSocietyPhoto.setAdapter (adapter);
        rvSocietyPhoto.addOnItemTouchListener (new OnItemChildClickListener () {
            @Override
            public void SimpleOnItemChildClick (BaseQuickAdapter baseQuickAdapter, View view, int i) {
                //跳转到相册展示界面
                Intent intent = new Intent (getActivity (), PhotoActivity.class);
                intent.putExtra ("position", i);
                startActivity (intent);
            }
        });
    }

    /**
     * 社团照片封面Adapter
     */
    public class SocietyPhotoAlbumAdapter extends BaseQuickAdapter<SocietyPhotoAlbumBean> {

        public SocietyPhotoAlbumAdapter () {
            super (R.layout.society_photo_album, dataList);
        }

        @Override
        protected void convert (BaseViewHolder baseViewHolder, SocietyPhotoAlbumBean societyPhotoAlbumBean) {
            baseViewHolder.setText (R.id.tvAlbumName, societyPhotoAlbumBean.getAlbumName ())
                          .setText (R.id.tvAlbumTime, societyPhotoAlbumBean.getAlbumTime ())
                          //todo：picasso加载网络图片 ,数据换成服务器获取的数据
                          .setImageResource (R.id.ivAlbumLogo, R.mipmap.ic_launcher).addOnClickListener (R.id.cvAlbum);
        }
    }

}


