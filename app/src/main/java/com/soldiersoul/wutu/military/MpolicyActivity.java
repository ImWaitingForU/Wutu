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

import com.shuyu.common.CommonRecyclerAdapter;
import com.shuyu.common.CommonRecyclerManager;
import com.shuyu.common.listener.OnItemClickListener;
import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Holder.EmptyHolder;
import com.soldiersoul.wutu.Holder.PolicyHolder;
import com.soldiersoul.wutu.Model.MutilModel;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.itemDecoration.DividerItemDecoration;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.utils.DataUtils;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

/**
 * 军事政策界面，政策福利没有动态性，不设置下拉刷新和上拉加载
 */
public class MpolicyActivity extends BaseActivity {

    private Handler mHandler = new Handler () {
        @Override
        public void handleMessage (Message msg) {
            //防止初次进入时加载不出新闻
            if (adapter != null && msg.what == 0x111) {
                adapter.setListData (datas);
                loadingView.hide ();
                //                refreshLayout.setVisibility (View.VISIBLE);
                recyclerView.setVisibility (View.VISIBLE);
                Log.d ("chan", "handler == set adapter data:" + datas.size ());
            }
        }
    };

    private AVLoadingIndicatorView loadingView;

    private RecyclerView recyclerView;
    //适配器
    private CommonRecyclerAdapter adapter;
    //数据
    private List<RecyclerBaseModel> datas = new ArrayList<> ();
    //刷新标签
    private boolean isfresh;
    //网络加载锁
    private final Object lock = new Object ();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setHomeButtonStaff ("福利政策");
        initViews ();
        //加载新闻列表
        init ();
        initDatas ();
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_mpolicy;
    }

    private void initViews () {
        loadingView = (AVLoadingIndicatorView) findViewById (R.id.loading_view);
        loadingView.show ();
        recyclerView = (RecyclerView) findViewById (R.id.military_mpolicy_recyclerview);
    }

    public void init () {
        //初始化管理器
        CommonRecyclerManager commonRecyclerManager = new CommonRecyclerManager ();
        //添加card类型
        commonRecyclerManager.addType (PolicyHolder.ID, PolicyHolder.class.getName ());

        //设置空页面的
        commonRecyclerManager.addType (EmptyHolder.ID, EmptyHolder.class.getName ());
        //适配器
        adapter = new CommonRecyclerAdapter (this, commonRecyclerManager, datas);
        //需要加载更多
        //adapter.setNeedLoadMore(true);
        //需要显示空数据页面
        //adapter.setShowNoData(true);
        //设置动画支持打开
        adapter.setNeedAnimation (true);
        //配置你自定义的空页面效果，不配置显示默认
        adapter.setNoDataLayoutId (EmptyHolder.ID);
        RecyclerBaseModel recyclerBaseModel = new RecyclerBaseModel ();
        recyclerBaseModel.setResLayoutId (EmptyHolder.ID);
        adapter.setNoDataModel (recyclerBaseModel);

        recyclerView.setLayoutManager (new LinearLayoutManager (this));
        recyclerView.addItemDecoration (new DividerItemDecoration (10, DividerItemDecoration.LIST));
        recyclerView.setAdapter (adapter);

        //设置上拉加载更多数据
        //设置下拉刷新
        //        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
        //            @Override
        //            public void onRefresh() {
        //                if (!isfresh) {
        //                    isfresh = true;
        //                    recyclerView.postDelayed(new Runnable() {
        //                        @Override
        //                        public void run() {
        //                            //TODO:下拉刷新同样等待后台更多数据的加入
        //                            refresh();
        //                        }
        //
        //                    }, 2000);
        //                }
        //            }
        //        });
        //设置item点击事件
        adapter.setOnItemClickListener (new OnItemClickListener () {
            @Override
            public void onItemClick (Context context, int position) {
                MutilModel policy = (MutilModel) datas.get (position);
                Intent intent = new Intent (MpolicyActivity.this, CityContentActivity.class);
                intent.putExtra ("actTitle","政策");
                intent.putExtra ("newsTitle",policy.getTitle ());
                intent.putExtra ("newsContent",policy.getContent ());
                //来源放在时间的位置
                intent.putExtra ("newsDate","来源:"+policy.getResource ());

                startActivity (intent);
            }
        });
    }

    public void initDatas () {
        List<RecyclerBaseModel> list = DataUtils.getRefreshPolicyData (this, datas, mHandler);
        this.datas = list;
        //        if (adapter != null) {
        //            adapter.setListData (datas);
        //        }
    }

    //    /**
    //     * 上拉加载更多
    //     */
    //    private void loadMore() {
    ////        List<RecyclerBaseModel> list = DataUtils.getLoadMoreData(datas);
    //        //组装好数据之后，再一次性给list，在加多个锁，这样能够避免和上拉数据更新冲突
    //        //数据要尽量组装好，避免多个异步操作同个内存，因为多个异步更新一个数据源会有问题。
    //        synchronized (lock) {
    //            //adapter.setLoadMoreState(LoadMoreHolder.NULL_DATA_STATE);
    ////            adapter.setListData(list);
    //            isfresh = false;
    //        }
    //    }

    //    /**
    //     * 下拉刷新方法
    //     */
    //    private void refresh() {
    ////        List<RecyclerBaseModel> list = DataUtils.getRefreshPolicyData(this);
    //        //组装好数据之后，再一次性给list，在加多个锁，这样能够避免和上拉数据更新冲突
    //        //数据要尽量组装好，避免多个异步操作同个内存，因为多个异步更新一个数据源会有问题。
    //        synchronized (lock) {
    ////            datas = list;
    //            adapter.setListData(datas);
    //            refreshLayout.setRefreshing(false);
    //            isfresh = false;
    //        }
    //    }


}
