package com.soldiersoul.wutu.military;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.shuyu.common.CommonRecyclerAdapter;
import com.shuyu.common.CommonRecyclerManager;
import com.shuyu.common.listener.LoadMoreScrollListener;
import com.shuyu.common.listener.OnItemClickListener;
import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Holder.ClickHolder;
import com.soldiersoul.wutu.Holder.EmptyHolder;
import com.soldiersoul.wutu.Holder.ImageHolder;
import com.soldiersoul.wutu.Holder.MutilHolder;
import com.soldiersoul.wutu.Holder.TextHolder;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.adapter.Military_Fragment_Adapter;
import com.soldiersoul.wutu.itemDecoration.DividerItemDecoration;
import com.soldiersoul.wutu.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 军事天地Fragment
 */
public class MilitaryFragment extends Fragment implements View.OnClickListener {

    //Context
    public Context context;
    //控件
    private Button btn_ad;
    private Button btn_policy;
    private Button btn_welfare;
    private Button btn_city;

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;

    //数据
    private List<RecyclerBaseModel> datas = new ArrayList<>();
    //适配器
    private CommonRecyclerAdapter adapter;
    //网络加载锁
    private final Object lock = new Object();
    //刷新标签
    private boolean isfresh;

    //创建ViewPager
    //@BindView(R.id.viewpager_military_fragment)
    //创建控件
//    @BindView(R.id.scrollbar_militaryworld)
//    HorizontalScrollView scrollbar_militaryworld;
//    @BindView(R.id.tv_military_advertise_tag)
//    TextView tv_advertise;
//    @BindView(R.id.tv_military_tips_tag)
//    TextView tv_tips;
//    @BindView(R.id.tv_military_news_tag)
//    TextView tv_news;
//    @BindView(R.id.tv_military_weapons_tag)
//    TextView tv_weapons;
//    @BindView(R.id.view_v1)
//    View v1;
//    @BindView(R.id.view_v2)
//    View v2;
//    @BindView(R.id.view_v3)
//    View v3;
//    @BindView(R.id.view_v4)
//    View v4;

    //创建四个子fragment
    //private ArrayList<Fragment> fragmentsList;
    //private FragmentManager mFragmentManager;

    //数据源
    //private ArrayList<View> downlines;
    //private ArrayList<TextView> tag_name;

    //屏幕宽度
    //private int width;

    public MilitaryFragment() {

    }

    public MilitaryFragment(Context context) {
        this.context = context;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ButterKnife.bind(context, view);
        //  ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");
        //width = getActivity().getWindowManager().getDefaultDisplay().getWidth();

        //注册事件
//        tv_advertise.setOnClickListener(this);
//        tv_tips.setOnClickListener(this);
//        tv_news.setOnClickListener(this);
//        tv_weapons.setOnClickListener(this);
        //初始化数据
        //initData();
        //初始化ViewPager
        //initViewPager();
        btn_ad.setOnClickListener(this);
        btn_policy.setOnClickListener(this);
        btn_welfare.setOnClickListener(this);
        btn_city.setOnClickListener(this);

    }

//    private void initViewPager() {
//        mFragmentManager = getFragmentManager();
//        fragmentsList = new ArrayList<Fragment>();
//        Fragment frag1 = new MilitaryAdFragment();
//        Fragment frag2 = new MilitaryTipFragment();
//        Fragment frag3 = new MilitaryNewsFragment();
//        Fragment frag4 = new MilitaryWpFragment();
//
//        fragmentsList.add(frag1);
//        fragmentsList.add(frag2);
//        fragmentsList.add(frag3);
//        fragmentsList.add(frag4);
//
//        mViewPager.setAdapter(new Military_Fragment_Adapter(mFragmentManager, fragmentsList));
//        mViewPager.setCurrentItem(0);
//        mViewPager.setOnPageChangeListener(this);
//    }

//    private void initData() {
//        tag_name = new ArrayList<TextView>();
//        tag_name.add(tv_advertise);
//        tag_name.add(tv_tips);
//        tag_name.add(tv_news);
//        tag_name.add(tv_weapons);
//        downlines = new ArrayList<View>();
//        downlines.add(v1);
//        downlines.add(v2);
//        downlines.add(v3);
//        downlines.add(v4);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_military, container, false);
        btn_ad = (Button) view.findViewById(R.id.btn_ad);
        btn_policy = (Button) view.findViewById(R.id.btn_policy);
        btn_welfare = (Button) view.findViewById(R.id.btn_welfare);
        btn_city = (Button) view.findViewById(R.id.btn_city);
        btn_ad.getBackground().setAlpha(150);
        btn_policy.getBackground().setAlpha(150);
        btn_welfare.getBackground().setAlpha(150);
        btn_city.getBackground().setAlpha(150);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.military_refresh);
        recyclerView = (RecyclerView) view.findViewById(R.id.military_news);
        //加载新闻列表
        init();
        initDatas();
        return view;
    }

    @Override
    public void onClick(View view) {
        //resetTextColorAndView();
        switch (view.getId()) {
//            case R.id.tv_military_advertise_tag:
//                mViewPager.setCurrentItem(0);
//                tv_advertise.setTextColor(Color.parseColor("#288C53"));
//                v1.setVisibility(View.VISIBLE);
//                break;
//            case R.id.tv_military_tips_tag:
//                mViewPager.setCurrentItem(1);
//                tv_tips.setTextColor(Color.parseColor("#288C53"));
//                v2.setVisibility(View.VISIBLE);
//                break;
//            case R.id.tv_military_news_tag:
//                mViewPager.setCurrentItem(2);
//                tv_news.setTextColor(Color.parseColor("#288C53"));
//                v3.setVisibility(View.VISIBLE);
//                break;
//            case R.id.tv_military_weapons_tag:
//                mViewPager.setCurrentItem(3);
//                tv_weapons.setTextColor(Color.parseColor("#288C53"));
//                v4.setVisibility(View.VISIBLE);
//                break;
            case R.id.btn_ad:
                startActivity(new Intent(context, MadActivity.class));
                break;
            case R.id.btn_policy:
                startActivity(new Intent(context, MpolicyActivity.class));
                break;
            case R.id.btn_welfare:
                startActivity(new Intent(context, MwelfareActivity.class));
                break;
            case R.id.btn_city:
                startActivity(new Intent(context, McityActivity.class));
                break;
        }
    }

//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        scrollbar_militaryworld.scrollTo((width * position + positionOffsetPixels) / 8, 0);
//    }

//    @Override
//    public void onPageSelected(int position) {
//        resetTextColorAndView();
//        switch (position) {
//            case 0:
//                tv_advertise.setTextColor(Color.parseColor("#288C53"));
//                v1.setVisibility(View.VISIBLE);
//                break;
//            case 1:
//                tv_tips.setTextColor(Color.parseColor("#288C53"));
//                v2.setVisibility(View.VISIBLE);
//                break;
//            case 2:
//                tv_news.setTextColor(Color.parseColor("#288C53"));
//                v3.setVisibility(View.VISIBLE);
//                break;
//            case 3:
//                tv_weapons.setTextColor(Color.parseColor("#288C53"));
//                v4.setVisibility(View.VISIBLE);
//                break;
//            default:
//                break;
//        }
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }
//
//
//    /**
//     * 重设滚动条颜色
//     */
//    private void resetTextColorAndView() {
//        tv_advertise.setTextColor(Color.BLACK);
//        tv_tips.setTextColor(Color.BLACK);
//        tv_news.setTextColor(Color.BLACK);
//        tv_weapons.setTextColor(Color.BLACK);
//
//        v1.setVisibility(View.GONE);
//        v2.setVisibility(View.GONE);
//        v3.setVisibility(View.GONE);
//        v4.setVisibility(View.GONE);
//
//    }

    public void init(){
        //初始化管理器
        CommonRecyclerManager commonRecyclerManager = new CommonRecyclerManager();
        //添加四种类型
        commonRecyclerManager.addType(ImageHolder.ID, ImageHolder.class.getName());
        commonRecyclerManager.addType(TextHolder.ID, TextHolder.class.getName());
        commonRecyclerManager.addType(ClickHolder.ID, ClickHolder.class.getName());
        commonRecyclerManager.addType(MutilHolder.ID, MutilHolder.class.getName());
        //设置空页面的
        commonRecyclerManager.addType(EmptyHolder.ID, EmptyHolder.class.getName());
        //适配器
        adapter = new CommonRecyclerAdapter(context, commonRecyclerManager, datas);
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

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new DividerItemDecoration(dip2px(context, 10), DividerItemDecoration.LIST));
        recyclerView.setAdapter(adapter);

        //设置上拉加载更多数据
        recyclerView.setOnScrollListener(new LoadMoreScrollListener(){
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
                //TODO:需要减去你的header和刷新的view的数量
                Toast.makeText(context, "点击了！！　" + (position - 2), Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     * dip转为PX
     */
    public static int dip2px(Context context, float dipValue) {
        float fontScale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * fontScale + 0.5f);
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
            adapter.addListData(list);
            isfresh = false;
        }
    }

    /**
     * 下拉刷新方法
     */
    private void refresh() {
        List<RecyclerBaseModel> list = DataUtils.getRefreshData();
        //组装好数据之后，再一次性给list，在加多个锁，这样能够避免和上拉数据更新冲突
        //数据要尽量组装好，避免多个异步操作同个内存，因为多个异步更新一个数据源会有问题。
        synchronized (lock) {
            datas = list;
            adapter.setListData(datas);
            refreshLayout.setRefreshing(false);
            isfresh = false;
        }
    }
    public void initDatas() {
        List<RecyclerBaseModel> list = DataUtils.getRefreshData();
        this.datas = list;
        if (adapter != null) {
            adapter.setListData(datas);
        }
    }
}
