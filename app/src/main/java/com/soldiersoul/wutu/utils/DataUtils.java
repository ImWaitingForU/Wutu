package com.soldiersoul.wutu.utils;


import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Holder.CardHolder;
import com.soldiersoul.wutu.Holder.ImageHolder;
import com.soldiersoul.wutu.Holder.MutilHolder;
import com.soldiersoul.wutu.Holder.VideoHolder;
import com.soldiersoul.wutu.Model.CardModel;
import com.soldiersoul.wutu.Model.ClickModel;
import com.soldiersoul.wutu.Model.ImageModel;
import com.soldiersoul.wutu.Model.MutilModel;
import com.soldiersoul.wutu.Model.VideoModel;
import com.soldiersoul.wutu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxj on 2017/02/27.
 */

public class DataUtils {

    public static List<RecyclerBaseModel> getInitialData() {
        List<RecyclerBaseModel> list = new ArrayList<>();

        MutilModel cardModel = new MutilModel();
        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容-------------------------------------------------------" +
                "-----------------------------------------------------------------" +
                "-------------------------------------------------------------------" +
                "-----------------------------------------------------------");
        cardModel.setTv3("2017.2.28");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容-------------------------------------------------------" +
                "-----------------------------------------------------------------" +
                "-------------------------------------------------------------------" +
                "-----------------------------------------------------------");
        cardModel.setTv3("2017.2.28");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容-------------------------------------------------------" +
                "-----------------------------------------------------------------" +
                "-------------------------------------------------------------------" +
                "-----------------------------------------------------------");
        cardModel.setTv3("2017.2.28");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容-------------------------------------------------------" +
                "-----------------------------------------------------------------" +
                "-------------------------------------------------------------------" +
                "-----------------------------------------------------------");
        cardModel.setTv3("2017.2.28");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容-------------------------------------------------------" +
                "-----------------------------------------------------------------" +
                "-------------------------------------------------------------------" +
                "-----------------------------------------------------------");
        cardModel.setTv3("2017.2.28");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容-------------------------------------------------------" +
                "-----------------------------------------------------------------" +
                "-------------------------------------------------------------------" +
                "-----------------------------------------------------------");
        cardModel.setTv3("2017.2.28");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容-------------------------------------------------------" +
                "-----------------------------------------------------------------" +
                "-------------------------------------------------------------------" +
                "-----------------------------------------------------------");
        cardModel.setTv3("2017.2.28");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容-------------------------------------------------------" +
                "-----------------------------------------------------------------" +
                "-------------------------------------------------------------------" +
                "-----------------------------------------------------------");
        cardModel.setTv3("2017.2.28");
        list.add(cardModel);

        return list;
    }

    //获取下拉刷新数据
    public static List<RecyclerBaseModel> getRefreshData() {

        List<RecyclerBaseModel> list = new ArrayList<>();

        ImageModel imageModel = new ImageModel();
        //TODO:网络数据
        imageModel.setResLayoutId(ImageHolder.ID);
        imageModel.setResId(R.drawable.a1);
        imageModel.setNewsTitle("新闻标题");
        imageModel.setNewsContent("内容---------------------------------------------------------------");
        imageModel.setNewsTime("2017.2.27");
        list.add(imageModel);

        imageModel.setResLayoutId(ImageHolder.ID);
        imageModel.setResId(R.drawable.a1);
        imageModel.setNewsTitle("新闻标题");
        imageModel.setNewsContent("内容---------------------------------------------------------------");
        imageModel.setNewsTime("2017.2.27");
        list.add(imageModel);

        imageModel = new ImageModel();
        imageModel.setResLayoutId(ImageHolder.ID);
        imageModel.setResId(R.drawable.a2);
        imageModel.setNewsTitle("新闻标题");
        imageModel.setNewsContent("内容---------------------------------------------------------------");
        imageModel.setNewsTime("2017.2.27");
        list.add(imageModel);

        imageModel = new ImageModel();
        imageModel.setResLayoutId(ImageHolder.ID);
        imageModel.setResId(R.drawable.a2);
        imageModel.setNewsTitle("新闻标题");
        imageModel.setNewsContent("内容---------------------------------------------------------------");
        imageModel.setNewsTime("2017.2.27");
        list.add(imageModel);

        VideoModel videoModel = new VideoModel();
        videoModel.setResLayoutId(VideoHolder.ID);
        videoModel.setBtnRes(R.drawable.video_click_play_selector);
        videoModel.setFengmianRes(R.mipmap.xxx1);
        list.add(videoModel);


//        ClickModel clickModel = new ClickModel();
//        clickModel.setResLayoutId(ClickHolder.ID);
//        clickModel.setBtnText("我是老按键，按啊按啊按啊····");
//        list.add(clickModel);
        imageModel.setResLayoutId(ImageHolder.ID);
        imageModel.setResId(R.drawable.a1);
        imageModel.setNewsTitle("新闻标题");
        imageModel.setNewsContent("内容---------------------------------------------------------------");
        imageModel.setNewsTime("2017.2.27");
        list.add(imageModel);

        imageModel.setResLayoutId(ImageHolder.ID);
        imageModel.setResId(R.drawable.a1);
        imageModel.setNewsTitle("新闻标题");
        imageModel.setNewsContent("内容---------------------------------------------------------------");
        imageModel.setNewsTime("2017.2.27");
        list.add(imageModel);

        imageModel = new ImageModel();
        imageModel.setResLayoutId(ImageHolder.ID);
        imageModel.setResId(R.drawable.a2);
        imageModel.setNewsTitle("新闻标题");
        imageModel.setNewsContent("内容---------------------------------------------------------------");
        imageModel.setNewsTime("2017.2.27");
        list.add(imageModel);

        imageModel = new ImageModel();
        imageModel.setResLayoutId(ImageHolder.ID);
        imageModel.setResId(R.drawable.a2);
        imageModel.setNewsTitle("新闻标题");
        imageModel.setNewsContent("内容---------------------------------------------------------------");
        imageModel.setNewsTime("2017.2.27");
        list.add(imageModel);

        videoModel = new VideoModel();
        videoModel.setResLayoutId(VideoHolder.ID);
        videoModel.setBtnRes(R.drawable.video_click_play_selector);
        videoModel.setFengmianRes(R.mipmap.xxx1);
        list.add(videoModel);


        CardModel cardModel = new CardModel();
        cardModel.setResLayoutId(CardHolder.ID);
        cardModel.setImg1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容");

        return list;
    }


    //获取上拉加载数据
    public static List<RecyclerBaseModel> getLoadMoreData(List<RecyclerBaseModel> datas) {
        List<RecyclerBaseModel> list = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            RecyclerBaseModel recyclerBaseModel = datas.get(i);
            RecyclerBaseModel newModel;
            if (recyclerBaseModel instanceof ClickModel) {

            } else if (recyclerBaseModel instanceof VideoModel) {
                newModel = new VideoModel();
                VideoModel videoModel = (VideoModel) newModel;
                videoModel.setResLayoutId(recyclerBaseModel.getResLayoutId());
                videoModel.setBtnRes(R.drawable.video_click_play_selector);
                videoModel.setFengmianRes(R.mipmap.xxx1);
                list.add(newModel);
            } else if (recyclerBaseModel instanceof ImageModel) {
                newModel = new ImageModel();
                ImageModel imageModel = (ImageModel) newModel;
                imageModel.setResLayoutId(recyclerBaseModel.getResLayoutId());
                imageModel.setResId(((ImageModel) recyclerBaseModel).getResId());
                list.add(newModel);
            } else if (recyclerBaseModel instanceof MutilModel) {
                newModel = new MutilModel();
                MutilModel mutilModel = (MutilModel) newModel;
                mutilModel.setResLayoutId(recyclerBaseModel.getResLayoutId());
                mutilModel.setImage1(R.mipmap.ic_launcher);
                mutilModel.setTv1("标题");
                mutilModel.setTv2("内容-------------------------------------------------------" +
                        "-----------------------------------------------------------------" +
                        "-------------------------------------------------------------------" +
                        "-----------------------------------------------------------");
                mutilModel.setTv3("2017.2.28");
                list.add(newModel);
            }
        }
        return list;
    }

}
