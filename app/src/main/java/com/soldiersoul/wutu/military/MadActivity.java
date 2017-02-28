package com.soldiersoul.wutu.military;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.shuyu.common.CommonRecyclerAdapter;
import com.shuyu.common.CommonRecyclerManager;
import com.shuyu.common.listener.LoadMoreScrollListener;
import com.shuyu.common.listener.OnItemClickListener;
import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Holder.CardHolder;
import com.soldiersoul.wutu.Holder.ClickHolder;
import com.soldiersoul.wutu.Holder.EmptyHolder;
import com.soldiersoul.wutu.Holder.ImageHolder;
import com.soldiersoul.wutu.Holder.MutilHolder;
import com.soldiersoul.wutu.Holder.TextHolder;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.itemDecoration.DividerItemDecoration;
import com.soldiersoul.wutu.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MadActivity extends AppCompatActivity {

    //列表
    @BindView(R.id.military_mad_refresh)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.military_mad_recyclerview)
    RecyclerView recyclerView;
    //适配器
    private CommonRecyclerAdapter adapter;
    //数据
    private List<RecyclerBaseModel> datas = new ArrayList<>();
    //刷新标签
    private boolean isfresh;
    //网络加载锁
    private final Object lock = new Object();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad);
        ButterKnife.bind(this);

        //加载新闻列表
        init();
        initDatas();


    }


    public void init() {
        //初始化管理器
        CommonRecyclerManager commonRecyclerManager = new CommonRecyclerManager();
        //添加card类型
        commonRecyclerManager.addType(MutilHolder.ID, MutilHolder.class.getName());

        //设置空页面的
        commonRecyclerManager.addType(EmptyHolder.ID, EmptyHolder.class.getName());
        //适配器
        adapter = new CommonRecyclerAdapter(this, commonRecyclerManager, datas);
        //需要加载更多
        adapter.setNeedLoadMore(true);
        //需要显示空数据页面
        adapter.setShowNoData(true);
        //设置动画支持打开
        adapter.setNeedAnimation(true);
        //配置你自定义的空页面效果，不配置显示默认
        adapter.setNoDataLayoutId(EmptyHolder.ID);
        RecyclerBaseModel recyclerBaseModel = new RecyclerBaseModel();
        recyclerBaseModel.setResLayoutId(EmptyHolder.ID);
        adapter.setNoDataModel(recyclerBaseModel);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(10, DividerItemDecoration.LIST));
        recyclerView.setAdapter(adapter);

        //设置上拉加载更多数据
        recyclerView.setOnScrollListener(new LoadMoreScrollListener() {
            @Override
            public void onLoadMore() {
                //注意加锁
                if (!isfresh) {
                    isfresh = true;
                    recyclerView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //TODO：数据加载，等待后台加入
                            loadMore();
                        }

                    }, 2000);
                }
            }

            @Override
            public void onScrolled(int firstPosition) {
                super.onScrolled(firstPosition);
            }

        });
        //设置下拉刷新
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!isfresh) {
                    isfresh = true;
                    recyclerView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //TODO:下拉刷新同样等待后台更多数据的加入
                            refresh();
                        }

                    }, 2000);
                }
            }
        });
        //设置item点击事件
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Context context, int position) {
                startActivity(new Intent(MadActivity.this,CityContentActivity.class));
            }
        });
    }

    public void initDatas() {
        List<RecyclerBaseModel> list = DataUtils.getInitialData();
        this.datas = list;
        if (adapter != null) {
            adapter.setListData(datas);
        }
    }

    /**
     * 上拉加载更多
     */
    private void loadMore() {
        List<RecyclerBaseModel> list = DataUtils.getLoadMoreData(datas);
        //组装好数据之后，再一次性给list，在加多个锁，这样能够避免和上拉数据更新冲突
        //数据要尽量组装好，避免多个异步操作同个内存，因为多个异步更新一个数据源会有问题。
        synchronized (lock) {
            //adapter.setLoadMoreState(LoadMoreHolder.NULL_DATA_STATE);
            adapter.setListData(list);
            isfresh = false;
        }
    }

    /**
     * 下拉刷新方法
     */
    private void refresh() {
        List<RecyclerBaseModel> list = DataUtils.getInitialData();
        //组装好数据之后，再一次性给list，在加多个锁，这样能够避免和上拉数据更新冲突
        //数据要尽量组装好，避免多个异步操作同个内存，因为多个异步更新一个数据源会有问题。
        synchronized (lock) {
            datas = list;
            adapter.setListData(datas);
            refreshLayout.setRefreshing(false);
            isfresh = false;
        }
    }

    /**
     * dip转为PX
     */
    public static int dip2px(Context context, float dipValue) {
        float fontScale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * fontScale + 0.5f);
    }
}
