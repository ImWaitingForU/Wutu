package com.soldiersoul.wutu.utils;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Holder.ImageHolder;
import com.soldiersoul.wutu.Holder.MutilHolder;
import com.soldiersoul.wutu.Holder.VideoHolder;
import com.soldiersoul.wutu.Model.ClickModel;
import com.soldiersoul.wutu.Model.ImageModel;
import com.soldiersoul.wutu.Model.MutilModel;
import com.soldiersoul.wutu.Model.VideoModel;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.military.MilitaryAdBean;
import com.soldiersoul.wutu.military.MilitaryNewsBean;

import net.sf.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wxj on 2017/02/27.
 */

public class DataUtils {
    public static List list2 = new ArrayList<>();
    public static Bundle mBundle;
    public static List<Bundle> bundleList = new ArrayList<>();

    public static Bundle getmBundle() {
        return mBundle;
    }

    public static void setmBundle(Bundle mBundle) {
        DataUtils.mBundle = mBundle;
    }

    //新闻，政策，宣传模拟数据
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


    public static List<RecyclerBaseModel> getInitialNewsData() {
        List<RecyclerBaseModel> list = new ArrayList<>();
        ImageModel imageModel = new ImageModel();
        imageModel.setNewsTitle("题目");
        imageModel.setNewsContent("内容");
        imageModel.setNewsTime("2017.4.9");
        imageModel.setResLayoutId(ImageHolder.ID);
        imageModel.setResId(R.drawable.a1);
        list.add(imageModel);

        imageModel.setNewsTitle("题目");
        imageModel.setNewsContent("内容");
        imageModel.setNewsTime("2017.4.9");
        imageModel.setResLayoutId(ImageHolder.ID);
        imageModel.setResId(R.drawable.a2);
        list.add(imageModel);

        imageModel.setNewsTitle("题目");
        imageModel.setNewsContent("内容");
        imageModel.setNewsTime("2017.4.9");
        imageModel.setResLayoutId(ImageHolder.ID);
        imageModel.setResId(R.drawable.a1);
        list.add(imageModel);

        imageModel.setNewsTitle("题目");
        imageModel.setNewsContent("内容");
        imageModel.setNewsTime("2017.4.9");
        imageModel.setResLayoutId(ImageHolder.ID);
        imageModel.setResId(R.drawable.a2);
        list.add(imageModel);

        VideoModel videoModel = new VideoModel();
        videoModel.setResLayoutId(VideoHolder.ID);
        videoModel.setBtnRes(R.drawable.video_click_play_selector);
        videoModel.setFengmianRes(R.mipmap.xxx1);
        list.add(videoModel);
        return list;
    }


    private static List<RecyclerBaseModel> list = new ArrayList<>();
    private static List<RecyclerBaseModel> list5 = new ArrayList<>();

    public static String res = "";

    //获取新闻界面下拉刷新数据
    public static List<RecyclerBaseModel> getRefreshData(final Context context) {

        RequestQueue mQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://jhwt.freestu2004.com/index.php/Api/military/article?uid=1&num=0&category_id=36&city_id=0",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        List<Map> list1 = new DataUtils().parseJson(response);
                        Log.d("chan", "onResponse: " + response);
                        Log.d("chan", "s: " + list1);

                        for (Map m : list1) {
                            MilitaryNewsBean bean = new MilitaryNewsBean();
                            bean.setNewsTitle(m.get("title").toString());
                            bean.setNewsContent(m.get("description").toString());
                            bean.setNewsDate(m.get("create_time").toString());
                            if (bean.getVideoUrl() != null) {
                                VideoModel videoModel = new VideoModel();
                                videoModel.setResLayoutId(VideoHolder.ID);
                                videoModel.setBtnRes(R.drawable.video_click_play_selector);
                                //videoModel.setFengmianRes (bean.getNewsImageUrl ());
                                Log.d("chan", bean.getNewsImageUrl() + "");
                                list.add(videoModel);

                            } else {
                                ImageModel imageModel = new ImageModel();
                                imageModel.setResLayoutId(ImageHolder.ID);
                                imageModel.setImgUrl(bean.getNewsImageUrl());
                                imageModel.setNewsTitle(bean.getNewsTitle());
                                imageModel.setNewsContent(bean.getNewsContent());
                                imageModel.setNewsTime(bean.getNewsDate());
                                //传数据
                                mBundle = new Bundle();
                                mBundle.putString("newsTitle", bean.getNewsTitle());
                                mBundle.putString("newsContent", bean.getNewsContent());
                                mBundle.putString("newsDate", bean.getNewsDate());
                                DataUtils.list.add(imageModel);
                                bundleList.add(mBundle);
                            }
                        }
                        if (list2.size() > 0) {
                            List list3 = list2;
                            list2 = new ArrayList();
                            list2.add(bundleList);
                            for (int i = 0; i < list3.size(); i++) {
                                List<Bundle> list4 = (List<Bundle>) list3.get(i);
                                list2.add(list4);
                            }
                        } else {
                            list2.add(bundleList);
                        }
                      /*  res=s;*/
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("chan", "onErrorResponse: " + "no wang luo");
            }
        });
        mQueue.add(stringRequest);
        return list;

    }

    //获取军事宣传下拉刷新数据
    public static List<RecyclerBaseModel> getRefreshAdData(final Context context) {
        RequestQueue mQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://jhwt.freestu2004.com/index.php/Api/military/article?uid=1&num=0&category_id=36&city_id=0",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        List<Map> list1 = new DataUtils().parseJson(response);
                        //Log.d("wxj", "onResponse: " + response);
                        //Log.d("chan", "s: " + list1);
                        for (Map m : list1) {
                            MilitaryAdBean bean = new MilitaryAdBean();
                            bean.setTv1(m.get("title").toString());
                            bean.setTv2(m.get("description").toString());
                            bean.setTv3(m.get("create_time").toString());

                            MutilModel mutilModel = new MutilModel();
                            mutilModel.setResLayoutId(MutilHolder.ID);
                            //mutilModel.setImage1(bean.getNewsImageUrl());
                            mutilModel.setTv1(bean.getTv1());
                            mutilModel.setTv2(bean.getTv2());
                            mutilModel.setTv3(bean.getTv3());
                            list5.add(mutilModel);

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(stringRequest);
        return list5;
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
//                videoModel.setFengmianRes ();
                list.add(newModel);
            } else if (recyclerBaseModel instanceof ImageModel) {
                newModel = new ImageModel();
                ImageModel imageModel = (ImageModel) newModel;
                imageModel.setResLayoutId(recyclerBaseModel.getResLayoutId());
//                imageModel.setResId (((ImageModel) recyclerBaseModel).getResId ());
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

    //获取社团成员数据
    public static List<Map<String, Object>> getSocietyMemberInfo(final Context context){
         List<Map<String, Object>> listems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> listem = new HashMap<String, Object>();
            listem.put("name", "小明");
            listem.put("phone","156116111616156");
            listems.add(listem);
        }
        return listems;
    }
    //获取社团任务数据
//    public static List<SocietyIntegral> getSocietyIntegralInfo(final Context context){
//        List<SocietyIntegral> dataList = new ArrayList<>();
//        dataList.add(new SocietyIntegral("抓小鸡", "在操场玩老鹰抓小鸡", "2017.4.10", "奖励一根冰棒"));
//        dataList.add(new SocietyIntegral("抓小鸡", "在操场玩老鹰抓小鸡", "2017.4.10", "奖励一根冰棒"));
//        dataList.add(new SocietyIntegral("抓小鸡", "在操场玩老鹰抓小鸡", "2017.4.10", "奖励一根冰棒"));
//        dataList.add(new SocietyIntegral("抓小鸡", "在操场玩老鹰抓小鸡", "2017.4.10", "奖励一根冰棒"));
//        dataList.add(new SocietyIntegral("抓小鸡", "在操场玩老鹰抓小鸡", "2017.4.10", "奖励一根冰棒"));
//        dataList.add(new SocietyIntegral("抓小鸡", "在操场玩老鹰抓小鸡", "2017.4.10", "奖励一根冰棒"));
//        dataList.add(new SocietyIntegral("抓小鸡", "在操场玩老鹰抓小鸡", "2017.4.10", "奖励一根冰棒"));
//        return dataList;
//    }
    //utf-8 to string
    public static String getUTF8XMLString(String xml) {
        // A StringBuffer Object
        StringBuffer sb = new StringBuffer();
        sb.append(xml);
        String xmString = "";
        String xmlUTF8 = "";
        try {
            xmString = new String(sb.toString().getBytes("UTF-8"));
            xmlUTF8 = URLEncoder.encode(xmString, "UTF-8");
            System.out.println("utf-8 编码：" + xmlUTF8);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // return to String Formed
        return xmlUTF8;
    }

    /**
     * unicode 转字符串
     */
    public static String unicode2String(String unicode) {

        //StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        /*for (int i = 1; i < hex.length; i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 8);

            // 追加成string
            string.append((char) data);
        }*/

        return hex[0];
    }

    public List<Map> parseJson(String response) {
        List list = new ArrayList();
        JSONObject json = JSONObject.fromObject(response);
        int size = json.getJSONArray("data").size();
        for (int i = 0; i < size; i++) {
            Map map = new HashMap();
            String title = unicode2String(json.getJSONArray("data").getJSONObject(i).get("title").toString());
            String seotitle = unicode2String(json.getJSONArray("data").getJSONObject(i).get("seotitle").toString());
            String description = unicode2String(json.getJSONArray("data").getJSONObject(i).get("description").toString());
            Date date = new Date(Long.parseLong(json.getJSONArray("data").getJSONObject(i).get("create_time").toString()));
            DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            map.put("title", title);
            map.put("seotitle", seotitle);
            map.put("create_time", format2.format(date));
            map.put("description", description);
            list.add(map);
        }
        return list;
    }
}
