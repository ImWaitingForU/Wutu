package com.soldiersoul.wutu.society;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.society.bean.SocietyPhotoBean;
import com.soldiersoul.wutu.utils.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 社团照片Activity
 */
public class PhotoActivity extends BaseActivity {

    @BindView (R.id.rvPhoto) RecyclerView rvPhoto;
    @BindView (R.id.toolbar_photo) Toolbar mToolbar;

    private ArrayList<SocietyPhotoBean> photos;
    private AlertDialog.Builder dialogBuilder;
    private ImageView bigPhoto;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //初始化toolbar
        initToolbar (mToolbar);
        setPageTitle (mToolbar, "Custom title");
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);

        //初始化dialog
        dialogBuilder = new AlertDialog.Builder (this);
        View dialogView = View.inflate (this, R.layout.show_photo_dialog, null);
        dialogBuilder.setView (dialogView).setCancelable (true);
        final AlertDialog dialog = dialogBuilder.create ();
        bigPhoto = (ImageView) dialogView.findViewById (R.id.ivBigPhoto);
        dialogView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                dialog.cancel ();
            }
        });

        photos = new ArrayList<> ();
        photos.add (new SocietyPhotoBean ("a", "aaa"));
        photos.add (new SocietyPhotoBean ("b", "bbb"));
        photos.add (new SocietyPhotoBean ("c", "ccc"));
        photos.add (new SocietyPhotoBean ("d", "ddd"));
        photos.add (new SocietyPhotoBean ("e", "eee"));
        photos.add (new SocietyPhotoBean ("f", "fff"));
        photos.add (new SocietyPhotoBean ("g", "ggg"));
        photos.add (new SocietyPhotoBean ("h", "hhh"));

        //todo:实现toolbar设置相册封面

        //初始化recyclerView
        rvPhoto.setLayoutManager (new GridLayoutManager (this, 2));
        PhotoAdapter adapter = new PhotoAdapter ();
        adapter.openLoadAnimation (BaseQuickAdapter.SLIDEIN_BOTTOM);
        adapter.addFooterView (View.inflate (this, R.layout.footview_layout, null));
        rvPhoto.setAdapter (adapter);
        rvPhoto.addOnItemTouchListener (new OnItemChildClickListener () {
            @Override
            public void SimpleOnItemChildClick (BaseQuickAdapter baseQuickAdapter, View view, int i) {
                //todo:点击缩略图，dialog显示大图片
                if (!dialog.isShowing () && bigPhoto != null) {
                    dialogBuilder.show ();
                    bigPhoto.setImageDrawable (getDrawable (R.mipmap.ic_launcher));
                }
            }
        });
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_photo;
    }

    private class PhotoAdapter extends BaseQuickAdapter<SocietyPhotoBean> {
        public PhotoAdapter () {
            super (R.layout.society_photo_layout, photos);
        }

        @Override
        protected void convert (BaseViewHolder baseViewHolder, SocietyPhotoBean societyPhotoBean) {
            baseViewHolder.setText (R.id.photoName, societyPhotoBean.getPhotoName ())
                          .setImageDrawable (R.id.ivPhoto, getDrawable (R.mipmap.ic_launcher))
                          .addOnClickListener (R.id.ivPhoto);
            //todo:服务器获取数据显示:照片名和图片
        }
    }
}
