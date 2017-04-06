package com.soldiersoul.wutu.Holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.shuyu.common.RecyclerBaseHolder;
import com.shuyu.common.model.RecyclerBaseModel;
import com.shuyu.gsyvideoplayer.utils.ListVideoUtil;
import com.soldiersoul.wutu.Model.VideoModel;
import com.soldiersoul.wutu.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shuyu on 2016/11/23.
 */

public class VideoHolder extends RecyclerBaseHolder {

    public final static int ID = R.layout.text_item;

    ListVideoUtil listVideoUtil;
    @BindView(R.id.list_item_container)
    ImageView fengmian;
    @BindView(R.id.list_item_btn)
    ImageView btn_start;

    ImageView imageView;

    public VideoHolder(Context context, View v) {
        super(context, v);
        imageView = new ImageView(context);
        listVideoUtil = new ListVideoUtil(context);
    }

    @Override
    public void createView(View v) {
        ButterKnife.bind(this, v);
    }

    @Override
    public void onBind(RecyclerBaseModel model,final int position) {
        VideoModel videoModel = (VideoModel) (model);
//        fengmian.setBackgroundResource(videoModel.getFengmianRes());
        Picasso.with (context).load (model.getResLayoutId ()).into (fengmian);
        btn_start.setBackgroundResource(videoModel.getBtnRes());

        //添加播放
//        listVideoUtil.addVideoPlayer(position, imageView, "RecyclerView2List", fengmian, btn_start);
//        //开始播放
//        btn_start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("aa","isIn");
//                //getRecyclerBaseAdapter().notifyDataSetChanged();
//                //listVideoUtil.setLoop(true);
//                listVideoUtil.setPlayPositionAndTag(position, "RecyclerView2List");
//                final String url = "http://baobab.wdjcdn.com/14564977406580.mp4";
//                //listVideoUtil.setCachePath(new File(FileUtils.getPath()));
//                listVideoUtil.startPlay(url);
//            }
//        });
    }


}
