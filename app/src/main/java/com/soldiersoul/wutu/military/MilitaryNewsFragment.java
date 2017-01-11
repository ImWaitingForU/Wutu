package com.soldiersoul.wutu.military;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseViewHolder;
import com.soldiersoul.wutu.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;

/**
 * MilitaryNewsFragment
 */
public class MilitaryNewsFragment extends Fragment {

    //创建轮播图,顶部新闻轮播
    private BGABanner mBanner1;
    //创建新闻列表
    private RecyclerView rvMilitaryNewsList;
    private MilitaryRvAdapter mAdapter;
    //创建下拉刷新
    private SwipeRefreshLayout mSwipeRefreshLayout;


    public MilitaryNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_military_news_fragment, container, false);
        //TODO:轮播图,待改进
        mBanner1 = (BGABanner) view.findViewById(R.id.banner_guide_content1);
        initBanner();
        //初始化下拉刷新
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.sr_military_news);
        initFresh();
        //TODO:初始化新闻列表
        rvMilitaryNewsList = (RecyclerView) view.findViewById(R.id.rvMilitaryNewsList);

        initRvList();

        return view;
    }

    private void initFresh() {
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //TODO:模拟网络刷新
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });

    }

    private void initRvList() {
        //模拟数据
        List<MilitaryNewsBean> data = new List<MilitaryNewsBean>() {
            @Override
            public void add(int i, MilitaryNewsBean militaryNewsBean) {

            }

            @Override
            public boolean add(MilitaryNewsBean militaryNewsBean) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends MilitaryNewsBean> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends MilitaryNewsBean> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public MilitaryNewsBean get(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @NonNull
            @Override
            public Iterator<MilitaryNewsBean> iterator() {
                return null;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<MilitaryNewsBean> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<MilitaryNewsBean> listIterator(int i) {
                return null;
            }

            @Override
            public MilitaryNewsBean remove(int i) {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public MilitaryNewsBean set(int i, MilitaryNewsBean militaryNewsBean) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @NonNull
            @Override
            public List<MilitaryNewsBean> subList(int i, int i1) {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }
        };
        final MilitaryNewsBean bean1 = new MilitaryNewsBean("title1", "www.baidu.com", "2017111", "baidu", "content");
        final MilitaryNewsBean bean2 = new MilitaryNewsBean("title2", "www.baidu.com", "2017111", "baidu", "content");
        final MilitaryNewsBean bean3 = new MilitaryNewsBean("title3", "www.baidu.com", "2017111", "baidu", "content");
        final MilitaryNewsBean bean4 = new MilitaryNewsBean("title4", "www.baidu.com", "2017111", "baidu", "content");
        final MilitaryNewsBean bean5 = new MilitaryNewsBean("title5", "www.baidu.com", "2017111", "baidu", "content");
        data.add(bean1);
        data.add(bean2);
        data.add(bean3);
        data.add(bean4);
        data.add(bean5);
        mAdapter = new MilitaryRvAdapter(R.layout.fragment_mtnews_item, data) {
            @Override
            protected void convert(BaseViewHolder baseViewHolder, MilitaryNewsBean militaryNewsBean) {
                super.convert(baseViewHolder, militaryNewsBean);
                baseViewHolder.setText(R.id.tv_mtnews_title, militaryNewsBean.getNewsTitle());
                baseViewHolder.setText(R.id.tv_mtnews_time, militaryNewsBean.getNewsDate());
            }
        };
        rvMilitaryNewsList.setAdapter(mAdapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    private void initBanner() {
        List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.holder));
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.holder));
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.holder));
        mBanner1.setData(views);


        mBanner1.setDelegate(new BGABanner.Delegate<ImageView, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, ImageView itemView, String model, int position) {
                Toast.makeText(banner.getContext(), "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
