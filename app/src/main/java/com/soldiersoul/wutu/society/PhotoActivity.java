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
import com.soldiersoul.wutu.utils.BaseActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PhotoActivity extends BaseActivity {

    @BindView (R.id.rvPhoto) RecyclerView rvPhoto;

    //照片数据集
    private List<String> photoList;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        // TODO: 2017/3/10 设置相册名称
        setHomeButtonStaff ("相册名");

        initData ();
    }

    private void initData () {
        photoList = new ArrayList<> ();
        photoList.add ("http://img3.imgtn.bdimg.com/it/u=3468624775,1187831868&fm=21&gp=0.jpg");
        photoList.add ("http://image.tianjimedia.com/uploadImages/2011/283/9JX88YC3T5G5.jpg");
        photoList.add ("http://img2.niutuku.com/desk/1207/1343/bizhi-1343-25218.jpg");
        photoList.add ("http://tupian.enterdesk.com/2014/mxy/02/28/1/7.jpg");
        photoList.add ("http://pic1.win4000.com/wallpaper/e/539ebd97cb335.jpg");

        rvPhoto.setLayoutManager (new GridLayoutManager (this, 2, GridLayoutManager.VERTICAL, false));
        //        rvPhoto.setHasFixedSize (true);
        rvPhoto.setAdapter (new PhotoAdapter (this));
        rvPhoto.addOnItemTouchListener (new OnItemClickListener () {
            @Override
            public void SimpleOnItemClick (BaseQuickAdapter baseQuickAdapter, View view, int i) {
                showBigPic (photoList.get (i));
            }
        });
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_photo;
    }

    private class PhotoAdapter extends BaseQuickAdapter<String> {

        private Context context;

        public PhotoAdapter (Context context) {
            super (R.layout.society_photo, photoList);
            this.context = context;
        }

        @Override
        protected void convert (BaseViewHolder baseViewHolder, final String s) {
            Log.d (TAG, "converts: ====================");
            // TODO: 2017/3/10 picasso加载相册图片
            Picasso.with (context).load (s).placeholder (R.mipmap.ic_launcher)
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
