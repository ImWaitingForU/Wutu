package com.soldiersoul.wutu.utils;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Holder.ImageHolder;
import com.soldiersoul.wutu.Holder.MutilHolder;
import com.soldiersoul.wutu.Holder.VideoHolder;
import com.soldiersoul.wutu.Model.ClickModel;
import com.soldiersoul.wutu.Model.ImageModel;
import com.soldiersoul.wutu.Model.MutilModel;
import com.soldiersoul.wutu.Model.VideoModel;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.military.MilitaryNewsBean;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by wxj on 2017/02/27.
 */

public class DataUtils {

    public static List<RecyclerBaseModel> getInitialData () {
        List<RecyclerBaseModel> list = new ArrayList<> ();

        MutilModel cardModel = new MutilModel ();
        cardModel.setResLayoutId (MutilHolder.ID);
        cardModel.setImage1 (R.mipmap.ic_launcher);
        cardModel.setTv1 ("标题");
        cardModel.setTv2 ("内容-------------------------------------------------------" +
                                  "-----------------------------------------------------------------" +
                                  "-------------------------------------------------------------------" +
                                  "-----------------------------------------------------------");
        cardModel.setTv3 ("2017.2.28");
        list.add (cardModel);

        cardModel.setResLayoutId (MutilHolder.ID);
        cardModel.setImage1 (R.mipmap.ic_launcher);
        cardModel.setTv1 ("标题");
        cardModel.setTv2 ("内容-------------------------------------------------------" +
                                  "-----------------------------------------------------------------" +
                                  "-------------------------------------------------------------------" +
                                  "-----------------------------------------------------------");
        cardModel.setTv3 ("2017.2.28");
        list.add (cardModel);

        cardModel.setResLayoutId (MutilHolder.ID);
        cardModel.setImage1 (R.mipmap.ic_launcher);
        cardModel.setTv1 ("标题");
        cardModel.setTv2 ("内容-------------------------------------------------------" +
                                  "-----------------------------------------------------------------" +
                                  "-------------------------------------------------------------------" +
                                  "-----------------------------------------------------------");
        cardModel.setTv3 ("2017.2.28");
        list.add (cardModel);

        cardModel.setResLayoutId (MutilHolder.ID);
        cardModel.setImage1 (R.mipmap.ic_launcher);
        cardModel.setTv1 ("标题");
        cardModel.setTv2 ("内容-------------------------------------------------------" +
                                  "-----------------------------------------------------------------" +
                                  "-------------------------------------------------------------------" +
                                  "-----------------------------------------------------------");
        cardModel.setTv3 ("2017.2.28");
        list.add (cardModel);

        cardModel.setResLayoutId (MutilHolder.ID);
        cardModel.setImage1 (R.mipmap.ic_launcher);
        cardModel.setTv1 ("标题");
        cardModel.setTv2 ("内容-------------------------------------------------------" +
                                  "-----------------------------------------------------------------" +
                                  "-------------------------------------------------------------------" +
                                  "-----------------------------------------------------------");
        cardModel.setTv3 ("2017.2.28");
        list.add (cardModel);

        cardModel.setResLayoutId (MutilHolder.ID);
        cardModel.setImage1 (R.mipmap.ic_launcher);
        cardModel.setTv1 ("标题");
        cardModel.setTv2 ("内容-------------------------------------------------------" +
                                  "-----------------------------------------------------------------" +
                                  "-------------------------------------------------------------------" +
                                  "-----------------------------------------------------------");
        cardModel.setTv3 ("2017.2.28");
        list.add (cardModel);

        cardModel.setResLayoutId (MutilHolder.ID);
        cardModel.setImage1 (R.mipmap.ic_launcher);
        cardModel.setTv1 ("标题");
        cardModel.setTv2 ("内容-------------------------------------------------------" +
                                  "-----------------------------------------------------------------" +
                                  "-------------------------------------------------------------------" +
                                  "-----------------------------------------------------------");
        cardModel.setTv3 ("2017.2.28");
        list.add (cardModel);

        cardModel.setResLayoutId (MutilHolder.ID);
        cardModel.setImage1 (R.mipmap.ic_launcher);
        cardModel.setTv1 ("标题");
        cardModel.setTv2 ("内容-------------------------------------------------------" +
                                  "-----------------------------------------------------------------" +
                                  "-------------------------------------------------------------------" +
                                  "-----------------------------------------------------------");
        cardModel.setTv3 ("2017.2.28");
        list.add (cardModel);

        return list;
    }

    private static List<RecyclerBaseModel> list = new ArrayList<> ();

    //获取下拉刷新数据
    public static List<RecyclerBaseModel> getRefreshData (final Context context) {

        BmobQuery<MilitaryNewsBean> query = new BmobQuery<> ();
        query.setLimit (5);
        query.findObjects (new FindListener<MilitaryNewsBean> () {
            @Override
            public void done (List<MilitaryNewsBean> resultList, BmobException e) {
                if (e != null) {
                    e.printStackTrace ();
                    Toast.makeText (context, "获取数据失败", Toast.LENGTH_SHORT).show ();
                } else {
                    Log.d ("chan", "list" + resultList.size ());

                    for (int i = 0; i < resultList.size (); i++) {
                        MilitaryNewsBean bean = resultList.get (i);
                        if (bean.getVideoUrl () != null) {
                            VideoModel videoModel = new VideoModel ();
                            videoModel.setResLayoutId (VideoHolder.ID);
                            videoModel.setBtnRes (R.drawable.video_click_play_selector);
                            videoModel.setFengmianRes (bean.getNewsImageUrl ());
                            list.add (videoModel);
                        } else {
                            ImageModel imageModel = new ImageModel ();
                            imageModel.setResLayoutId (ImageHolder.ID);
                            imageModel.setImgUrl (bean.getNewsImageUrl ());
                            imageModel.setNewsTitle (bean.getNewsTitle ());
                            imageModel.setNewsContent (bean.getNewsContent ());
                            imageModel.setNewsTime (bean.getNewsDate ());
                            list.add (imageModel);
                        }
                    }

                }
            }
        });
        Log.d ("chan", "query success");
        return list;
    }


    //获取上拉加载数据
    public static List<RecyclerBaseModel> getLoadMoreData (List<RecyclerBaseModel> datas) {
        List<RecyclerBaseModel> list = new ArrayList<> ();
        for (int i = 0; i < datas.size (); i++) {
            RecyclerBaseModel recyclerBaseModel = datas.get (i);
            RecyclerBaseModel newModel;
            if (recyclerBaseModel instanceof ClickModel) {

            } else if (recyclerBaseModel instanceof VideoModel) {
                newModel = new VideoModel ();
                VideoModel videoModel = (VideoModel) newModel;
                videoModel.setResLayoutId (recyclerBaseModel.getResLayoutId ());
                videoModel.setBtnRes (R.drawable.video_click_play_selector);
//                videoModel.setFengmianRes ();
                list.add (newModel);
            } else if (recyclerBaseModel instanceof ImageModel) {
                newModel = new ImageModel ();
                ImageModel imageModel = (ImageModel) newModel;
                imageModel.setResLayoutId (recyclerBaseModel.getResLayoutId ());
//                imageModel.setResId (((ImageModel) recyclerBaseModel).getResId ());
                list.add (newModel);
            } else if (recyclerBaseModel instanceof MutilModel) {
                newModel = new MutilModel ();
                MutilModel mutilModel = (MutilModel) newModel;
                mutilModel.setResLayoutId (recyclerBaseModel.getResLayoutId ());
                mutilModel.setImage1 (R.mipmap.ic_launcher);
                mutilModel.setTv1 ("标题");
                mutilModel.setTv2 ("内容-------------------------------------------------------" +
                                           "-----------------------------------------------------------------" +
                                           "-------------------------------------------------------------------" +
                                           "-----------------------------------------------------------");
                mutilModel.setTv3 ("2017.2.28");
                list.add (newModel);
            }
        }
        return list;
    }


}
