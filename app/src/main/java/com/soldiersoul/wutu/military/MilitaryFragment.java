package com.soldiersoul.wutu.military;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.adapter.Military_Fragment_Adapter;

import java.util.ArrayList;

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
        //ButterKnife.bind(this, view);
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
}
