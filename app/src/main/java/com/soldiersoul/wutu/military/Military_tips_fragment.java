package com.soldiersoul.wutu.military;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.soldiersoul.wutu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;

/**
 * Military_tips_fragment
 */
public class Military_tips_fragment extends Fragment {

    //创建轮播图
    private BGABanner mBanner1;
    private BGABanner mBanner2;
    private BGABanner mBanner3;
    private BGABanner mBanner4;

    public Military_tips_fragment() {
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
        View view = inflater.inflate(R.layout.banner_military_fragment, container, false);
        //TODO:轮播图,待改进
        mBanner1 = (BGABanner) view.findViewById(R.id.banner_guide_content1);
        mBanner2 = (BGABanner) view.findViewById(R.id.banner_guide_content2);
        mBanner3 = (BGABanner) view.findViewById(R.id.banner_guide_content3);
        mBanner4 = (BGABanner) view.findViewById(R.id.banner_guide_content4);
        initBanner();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void initBanner() {
        List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.holder));
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.holder));
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.holder));
        mBanner1.setData(views);
        mBanner2.setData(R.drawable.holder, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        mBanner3.setData(R.drawable.holder, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        mBanner4.setData(R.drawable.holder, R.mipmap.ic_launcher, R.mipmap.ic_launcher);

        mBanner1.setDelegate(new BGABanner.Delegate<ImageView, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, ImageView itemView, String model, int position) {
                Toast.makeText(banner.getContext(), "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }


}
