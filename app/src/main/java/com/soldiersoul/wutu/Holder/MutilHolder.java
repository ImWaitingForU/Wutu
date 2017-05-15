package com.soldiersoul.wutu.Holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.shuyu.common.RecyclerBaseHolder;
import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Model.MutilModel;
import com.soldiersoul.wutu.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shuyu on 2016/11/24.
 */

public class MutilHolder extends RecyclerBaseHolder {

    public final static int ID = R.layout.mutil_item;
    @BindView(R.id.ivMadpic)
    ImageView itemImage1;
    @BindView(R.id.tvMadTitle)
    TextView madTitle;
    @BindView(R.id.tvMadContent)
    TextView madContent;
    @BindView(R.id.tvMadTime)
    TextView madTime;


    public MutilHolder(Context context, View v) {
        super(context, v);
    }

    @Override
    public void createView(View v) {
        ButterKnife.bind(this, v);
    }


    @Override
    public void onBind(RecyclerBaseModel model, int position) {
        MutilModel mutilModel = (MutilModel) model;

        Picasso.with (context).load (mutilModel.getImageUrl ()).into (itemImage1);
        madTitle.setText(mutilModel.getTitle ());
        //列表只显示15个字符内容..
        madContent.setText(mutilModel.getContent ().substring (0,15)+"...");
        madTime.setText(mutilModel.getTime ());
    }
}
