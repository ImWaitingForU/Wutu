package com.soldiersoul.wutu.utils;


import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Holder.CardHolder;
import com.soldiersoul.wutu.Holder.ClickHolder;
import com.soldiersoul.wutu.Holder.ImageHolder;
import com.soldiersoul.wutu.Holder.MutilHolder;
import com.soldiersoul.wutu.Holder.TextHolder;
import com.soldiersoul.wutu.Model.CardModel;
import com.soldiersoul.wutu.Model.ClickModel;
import com.soldiersoul.wutu.Model.ImageModel;
import com.soldiersoul.wutu.Model.MutilModel;
import com.soldiersoul.wutu.Model.TextModel;
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
        cardModel.setTv2("内容");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容");
        list.add(cardModel);

        cardModel.setResLayoutId(MutilHolder.ID);
        cardModel.setImage1(R.mipmap.ic_launcher);
        cardModel.setTv1("标题");
        cardModel.setTv2("内容");
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

        TextModel textModel = new TextModel();
        textModel.setResLayoutId(TextHolder.ID);
        textModel.setText("视频点这里看");
        list.add(textModel);


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

        textModel = new TextModel();
        textModel.setResLayoutId(TextHolder.ID);
        textModel.setText("视频点这里看");
        list.add(textModel);


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

            } else if (recyclerBaseModel instanceof TextModel) {
                newModel = new TextModel();
                TextModel textModel = (TextModel) newModel;
                textModel.setResLayoutId(recyclerBaseModel.getResLayoutId());
                textModel.setText("我就老视频哈哈哈哈！！！！！ " + i);
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
                mutilModel.setTv2("内容");
                list.add(newModel);
            }
        }
        return list;
    }

}
