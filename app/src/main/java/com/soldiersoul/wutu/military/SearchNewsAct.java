package com.soldiersoul.wutu.military;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.shuyu.common.CommonRecyclerAdapter;
import com.shuyu.common.CommonRecyclerManager;
import com.shuyu.common.listener.OnItemClickListener;
import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Holder.CardHolder;
import com.soldiersoul.wutu.Holder.EmptyHolder;
import com.soldiersoul.wutu.Holder.ImageHolder;
import com.soldiersoul.wutu.Holder.VideoHolder;
import com.soldiersoul.wutu.Model.ImageModel;
import com.soldiersoul.wutu.Model.VideoModel;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.itemDecoration.DividerItemDecoration;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.utils.DataUtils;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 搜索布局
 */
public class SearchNewsAct extends BaseActivity {

    private Handler mHandler = new Handler () {
        @Override
        public void handleMessage (Message msg) {
            //防止初次进入时加载不出新闻
            if (adapter != null && msg.what == 0x111) {
                adapter.setListData (datas);
                loadingView.hide ();
                rv.setVisibility (View.VISIBLE);
                Log.d ("chan", "handler == set adapter data:" + datas.size ());
            }
        }
    };

//    @BindView (R.id.btnSearch) Button btn;
    @BindView (R.id.etSearchNews) EditText searchInput;
    @BindView (R.id.rvSearch) RecyclerView rv;
    @BindView (R.id.search_loading_view) AVLoadingIndicatorView loadingView;

    /**
     * 模糊搜索新闻，应允许标题和时间搜索
     */
    @OnClick(R.id.btnSearch)
    void doSearch(){
        datas.clear ();

        //关键词为空则不搜索
        if(searchInput.getText ().toString ().equals ("")){
            mToastUtil.toastShort ("请输入搜索关键字");
            return ;
        }

        loadingView.setVisibility (View.VISIBLE);
        List<RecyclerBaseModel> list = DataUtils.getSearchData (this,datas,mHandler,searchInput.getText ().toString ());
        this.datas = list;
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setHomeButtonStaff ("搜索新闻");
        init ();
    }

    //数据
    private List<RecyclerBaseModel> datas = new ArrayList<> ();
    //适配器
    private CommonRecyclerAdapter adapter;
    public void init () {
        //初始化管理器
        CommonRecyclerManager commonRecyclerManager = new CommonRecyclerManager ();
        //添加四种类型
        commonRecyclerManager.addType (ImageHolder.ID, ImageHolder.class.getName ());
        commonRecyclerManager.addType (VideoHolder.ID, VideoHolder.class.getName ());
        commonRecyclerManager.addType (CardHolder.ID, CardHolder.class.getName ());
        //设置空页面的
        commonRecyclerManager.addType (EmptyHolder.ID, EmptyHolder.class.getName ());
        //适配器
        adapter = new CommonRecyclerAdapter (this, commonRecyclerManager, datas);
        //需要加载更多
        adapter.setNeedLoadMore (false);
        //需要显示空数据页面
        adapter.setShowNoData (true);
        //设置动画支持打开
        adapter.setNeedAnimation (true);
        //配置你自定义的空页面效果，不配置显示默认
        adapter.setNoDataLayoutId (EmptyHolder.ID);
        RecyclerBaseModel recyclerBaseModel = new RecyclerBaseModel ();
        recyclerBaseModel.setResLayoutId (EmptyHolder.ID);
        adapter.setNoDataModel (recyclerBaseModel);

        LinearLayoutManager llm = new LinearLayoutManager (this);
        llm.setReverseLayout (true);
        rv.setLayoutManager (llm);
        rv.addItemDecoration (new DividerItemDecoration (10, DividerItemDecoration.LIST));
        rv.setAdapter (adapter);

        //设置item点击事件
        adapter.setOnItemClickListener (new OnItemClickListener () {
            @Override
            public void onItemClick (Context context, int position) {
                String clsName = datas.get (position).getClass ().getName ();
                Log.d ("chan", "clsName === " + clsName);
                //判断是图片新闻还是视频新闻
                if (clsName.equals ("com.soldiersoul.wutu.Model.ImageModel")) {
                    Intent intent = new Intent (context, CityContentActivity.class);
                    ImageModel curNews = (ImageModel) datas.get (position);
                    intent.putExtra ("newsTitle", curNews.getNewsTitle ());
                    intent.putExtra ("actTitle", "新闻");
                    intent.putExtra ("newsContent", curNews.getNewsContent ());
                    intent.putExtra ("newsDate", curNews.getNewsTime ());
                    intent.putExtra ("newsImg", curNews.getImgUrl ());
                    startActivity (intent);
                } else {
                    //视频新闻(更换新视频播放框架)
                    Intent intent = new Intent (context, VideoPlayerAct.class);
                    VideoModel videoModel = (VideoModel) datas.get (position);
                    intent.putExtra ("url",videoModel.getVideoUrl ());
                    intent.putExtra ("title",videoModel.getVideoTitle ());
                    intent.putExtra ("logo",videoModel.getFengmianRes ());
                    intent.putExtra ("resource",videoModel.getVideoResouce ());
                    startActivity (intent);
                }


                //原方法按照数据判断，每五个插入一条视频新闻。
                //                if ((position + 1) % 5 == 0) {
                //                    startActivity (new Intent (context, VideoListActivity.class));
                //                } else { startActivity (new Intent (context, CityContentActivity.class)); }
            }
        });
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_search_news;
    }
}
