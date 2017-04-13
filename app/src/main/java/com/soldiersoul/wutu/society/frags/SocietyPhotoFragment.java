package com.soldiersoul.wutu.society.frags;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.society.PhotoActivity;
import com.soldiersoul.wutu.society.bean.SocietyAlbumBean;
import com.soldiersoul.wutu.society.bean.SocietyBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * 社团照片界面
 */
public class SocietyPhotoFragment extends Fragment {

    @BindView (R.id.rvSocietyPhoto) RecyclerView rvSocietyPhoto;
    private List<SocietyAlbumBean> dataList = new ArrayList<> ();
    private SocietyPhotoAlbumAdapter adapter;

    private SocietyBean society;

    public SocietyPhotoFragment () {
    }

    public SocietyPhotoFragment (SocietyBean society) {
        this.society = society;
        BmobQuery<SocietyAlbumBean> query = new BmobQuery<> ();
        SocietyAlbumBean album = new SocietyAlbumBean ();
        album.setObjectId ("wLXg888C");
        query.addWhereEqualTo ("albumList", new BmobPointer ());
        query.findObjects (new FindListener<SocietyAlbumBean> () {
            @Override
            public void done (List<SocietyAlbumBean> list, BmobException e) {
                if (e == null) {
                    dataList = list;
                }
            }
        });
    }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


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
    public class SocietyPhotoAlbumAdapter extends BaseQuickAdapter<SocietyAlbumBean> {

        public SocietyPhotoAlbumAdapter () {
            super (R.layout.society_photo_album, dataList);
        }

        @Override
        protected void convert (BaseViewHolder baseViewHolder, SocietyAlbumBean societyAlbumBean) {
            baseViewHolder.setText (R.id.tvAlbumName, societyAlbumBean.getAlbumName ())
                          .setText (R.id.tvAlbumTime, societyAlbumBean.getAlbumTime ())
                          .addOnClickListener (R.id.cvAlbum);

            Picasso.with (getActivity ()).load (societyAlbumBean.getAlbumLogoPath ())
                   .into ((ImageView) baseViewHolder.getConvertView ().findViewById (R.id.ivBigPhoto));
        }
    }

}


