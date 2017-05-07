package com.soldiersoul.wutu.society;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.society.bean.SocietyAlbumBean;
import com.soldiersoul.wutu.society.bean.SocietyPhoto;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class PhotoActivity extends BaseActivity {

    @BindView (R.id.rvPhoto) RecyclerView rvPhoto;

    //照片数据集
    private List<SocietyPhoto> photoList;

    //相册id
    private String albumId;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        setHomeButtonStaff (
                !getIntent ().getStringExtra ("albumName").equals ("") ? getIntent ().getStringExtra ("albumName") :
                        "相册名");

        albumId = getIntent ().getStringExtra ("albumId");
        Log.d ("Bmob", "albumId=====" + albumId);

    }

    @Override
    protected void onResume () {
        initData ();
        super.onResume ();
    }

    private void initData () {
        BmobQuery<SocietyPhoto> query = new BmobQuery<> ();
        SocietyAlbumBean albumBean = new SocietyAlbumBean ();
        //        albumBean.setObjectId ("1Sy92223");
        albumBean.setObjectId (albumId.trim ());
        query.addWhereEqualTo ("album", new BmobPointer (albumBean));
        query.findObjects (new FindListener<SocietyPhoto> () {
            @Override
            public void done (List<SocietyPhoto> list, BmobException e) {
                if (e == null) {
                    Log.d ("Bmob", "BmobScietyPhotoList===" + list.size ());

                    photoList = list;
                    rvPhoto.setLayoutManager (
                            new GridLayoutManager (PhotoActivity.this, 2, GridLayoutManager.VERTICAL, false));
                    //        rvPhoto.setHasFixedSize (true);
                    PhotoAdapter adapter = new PhotoAdapter (PhotoActivity.this);
                    adapter.setEmptyView (View.inflate (PhotoActivity.this, R.layout.societyalbum_empty_layout, null));
                    rvPhoto.setAdapter (adapter);
                    rvPhoto.addOnItemTouchListener (new OnItemClickListener () {
                        @Override
                        public void SimpleOnItemClick (BaseQuickAdapter baseQuickAdapter, View view, int i) {
                            showBigPic (photoList.get (i).getPhotoPath ());
                        }
                    });
                } else {
                    Log.d ("Bmob", "BmobQuery===" + e.getMessage ());
                }
            }
        });
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_photo;
    }

    private class PhotoAdapter extends BaseQuickAdapter<SocietyPhoto> {

        private Context context;

        public PhotoAdapter (Context context) {
            super (R.layout.society_photo, photoList);
            this.context = context;
        }

        @Override
        protected void convert (BaseViewHolder baseViewHolder, SocietyPhoto societyPhoto) {

            baseViewHolder.setText (R.id.tvPhotoName, societyPhoto.getPhotoName ());

            Picasso.with (context).load (societyPhoto.getPhotoPath ()).placeholder (R.drawable.ic_loadimg_failed)
                   .into ((ImageView) baseViewHolder.getView (R.id.ivSocietyPhoto));
        }
    }

    private void showBigPic (String url) {
        final AlertDialog dialog = new AlertDialog.Builder (this).create ();
        dialog.setCancelable (true);
        LayoutInflater inflater = LayoutInflater.from (this);
        View view = inflater.inflate (R.layout.bitshow_dialoglayout, null);
        ImageView bigIv = (ImageView) view.findViewById (R.id.large_image);
        bigIv.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                dialog.cancel ();
            }
        });
        Picasso.with (this).load (url).into (bigIv);
        dialog.setView (view);
        dialog.show ();
    }
}
