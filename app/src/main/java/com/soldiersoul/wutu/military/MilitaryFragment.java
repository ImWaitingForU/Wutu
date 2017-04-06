package com.soldiersoul.wutu.military;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.shuyu.common.CommonRecyclerAdapter;
import com.shuyu.common.CommonRecyclerManager;
import com.shuyu.common.listener.LoadMoreScrollListener;
import com.shuyu.common.listener.OnItemClickListener;
import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Holder.CardHolder;
import com.soldiersoul.wutu.Holder.EmptyHolder;
import com.soldiersoul.wutu.Holder.ImageHolder;
import com.soldiersoul.wutu.Holder.VideoHolder;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.itemDecoration.DividerItemDecoration;
import com.soldiersoul.wutu.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;


/**
 * 军事Fragment
 */
public class MilitaryFragment extends Fragment implements View.OnClickListener {

    //Context
    public Context context;
    //控件
    private Button btn_ad;
    private Button btn_policy;
    private Button btn_city;

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;

    //数据
    private List<RecyclerBaseModel> datas = new ArrayList<> ();
    //适配器
    private CommonRecyclerAdapter adapter;
    //网络加载锁
    private final Object lock = new Object ();
    //刷新标签
    private boolean isfresh;

    //    private List<MilitaryNewsBean> beanList;

    public MilitaryFragment () {

    }

    public MilitaryFragment (Context context) {
        this.context = context;
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        btn_ad.setOnClickListener (this);
        btn_policy.setOnClickListener (this);
        btn_city.setOnClickListener (this);

    }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initDatas ();
        View view = inflater.inflate (R.layout.fragment_military, container, false);
        btn_ad = (Button) view.findViewById (R.id.btn_ad);
        btn_policy = (Button) view.findViewById (R.id.btn_policy);
        btn_city = (Button) view.findViewById (R.id.btn_city);
        btn_ad.getBackground ().setAlpha (150);
        btn_policy.getBackground ().setAlpha (150);
        btn_city.getBackground ().setAlpha (150);
        refreshLayout = (SwipeRefreshLayout) view.findViewById (R.id.military_refresh);
        recyclerView = (RecyclerView) view.findViewById (R.id.military_news);
        //加载新闻列表
        init ();
        return view;
    }

    @Override
    public void onClick (View view) {

        switch (view.getId ()) {
            case R.id.btn_ad:
                startActivity (new Intent (context, MadActivity.class));
                break;
            case R.id.btn_policy:
                startActivity (new Intent (context, MpolicyActivity.class));
                break;
            case R.id.btn_city:
                startActivity (new Intent (context, McityActivity.class));
                break;
        }
    }


    public void init () {
        //初始化管理器
        CommonRecyclerManager commonRecyclerManager = new CommonRecyclerManager ();
        //添加四种类型
        commonRecyclerManager.addType (ImageHolder.ID, ImageHolder.class.getName ());
        commonRecyclerManager.addType (VideoHolder.ID, VideoHolder.class.getName ());
        //commonRecyclerManager.addType(ClickHolder.ID, ClickHolder.class.getName());
        //commonRecyclerManager.addType(MutilHolder.ID, MutilHolder.class.getName());
        commonRecyclerManager.addType (CardHolder.ID, CardHolder.class.getName ());
        //设置空页面的
        commonRecyclerManager.addType (EmptyHolder.ID, EmptyHolder.class.getName ());
        //适配器
        adapter = new CommonRecyclerAdapter (context, commonRecyclerManager, datas);
        //需要加载更多
        adapter.setNeedLoadMore (true);
        //需要显示空数据页面
        adapter.setShowNoData (true);
        //设置动画支持打开
        adapter.setNeedAnimation (true);
        //配置你自定义的空页面效果，不配置显示默认
        adapter.setNoDataLayoutId (EmptyHolder.ID);
        RecyclerBaseModel recyclerBaseModel = new RecyclerBaseModel ();
        recyclerBaseModel.setResLayoutId (EmptyHolder.ID);
        adapter.setNoDataModel (recyclerBaseModel);

        recyclerView.setLayoutManager (new LinearLayoutManager (context));
        recyclerView.addItemDecoration (new DividerItemDecoration (10, DividerItemDecoration.LIST));
        recyclerView.setAdapter (adapter);

        //设置上拉加载更多数据
        recyclerView.setOnScrollListener (new LoadMoreScrollListener () {
            @Override
            public void onLoadMore () {
                //注意加锁
                if (!isfresh) {
                    isfresh = true;
                    recyclerView.postDelayed (new Runnable () {
                        @Override
                        public void run () {
                            //TODO：数据加载，等待后台加入
                            loadMore ();
                        }

                    }, 2000);
                }
            }

            @Override
            public void onScrolled (int firstPosition) {
                super.onScrolled (firstPosition);
            }

        });
        //设置下拉刷新
        refreshLayout.setOnRefreshListener (new SwipeRefreshLayout.OnRefreshListener () {
            @Override
            public void onRefresh () {
                if (!isfresh) {
                    isfresh = true;
                    recyclerView.postDelayed (new Runnable () {
                        @Override
                        public void run () {
                            //TODO:下拉刷新同样等待后台更多数据的加入
                            refresh ();
                        }

                    }, 2000);
                }
            }
        });
        //设置item点击事件
        adapter.setOnItemClickListener (new OnItemClickListener () {
            @Override
            public void onItemClick (Context context, int position) {

                if ((position + 1) % 5 == 0) {
                    startActivity (new Intent (context, VideoListActivity.class));
                } else { startActivity (new Intent (context, CityContentActivity.class)); }
            }
        });
    }

    /**
     * dip转为PX
     */
    public static int dip2px (Context context, float dipValue) {
        float fontScale = context.getResources ().getDisplayMetrics ().density;
        return (int) (dipValue * fontScale + 0.5f);
    }

    /**
     * 上拉加载更多
     */
    private void loadMore () {
        List<RecyclerBaseModel> list = DataUtils.getLoadMoreData (datas);
        //组装好数据之后，再一次性给list，在加多个锁，这样能够避免和上拉数据更新冲突
        //数据要尽量组装好，避免多个异步操作同个内存，因为多个异步更新一个数据源会有问题。
        synchronized (lock) {
            //adapter.setLoadMoreState(LoadMoreHolder.NULL_DATA_STATE);
            adapter.addListData (list);
            isfresh = false;
        }
    }

    /**
     * 下拉刷新方法
     */
    private void refresh () {
        //        List<RecyclerBaseModel> list = DataUtils.getRefreshData (getActivity ());
        //组装好数据之后，再一次性给list，在加多个锁，这样能够避免和上拉数据更新冲突
        //数据要尽量组装好，避免多个异步操作同个内存，因为多个异步更新一个数据源会有问题。
        synchronized (lock) {
            doQuery ();
            //            datas = list;
            adapter.setListData (datas);
            refreshLayout.setRefreshing (false);
            isfresh = false;
        }
    }

    public void initDatas () {
        List<RecyclerBaseModel> list = DataUtils.getRefreshData (getActivity ());
        this.datas = list;

//        doQuery ();
        if (adapter != null) {
            adapter.setListData (datas);
        }
    }

    private void doQuery () {
        BmobQuery<MilitaryNewsBean> query = new BmobQuery<> ();
        query.setLimit (5);
        query.findObjects (new FindListener<MilitaryNewsBean> () {
            @Override
            public void done (List<MilitaryNewsBean> list, BmobException e) {
                if (e != null) {
                    e.printStackTrace ();
                    Toast.makeText (context, "获取数据失败", Toast.LENGTH_SHORT).show ();
                } else {
                    Log.d ("chan", "list" + list.size ());

                    //                    beanList = list;
                    for (RecyclerBaseModel model : list) {
                        datas.add (model);
                    }
                    Log.d ("chan", "data list" + datas.size ());


                }
            }
        });
        recyclerView.removeAllViews ();
        Log.d ("chan", "query success");
    }
}
