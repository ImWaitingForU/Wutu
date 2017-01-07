package com.soldiersoul.wutu.military;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.views.TopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;

public class MilitaryWorldActivity extends BaseActivity {

    //创建ToolBar
    @BindView(R.id.activity_military_world_toolbar)
    TopBar mTopBar;
    //创建Banner
    @BindView(R.id.banner_guide_content1)
    BGABanner mBanner1;
    @BindView(R.id.banner_guide_content2)
    BGABanner mBanner2;
    @BindView(R.id.banner_guide_content3)
    BGABanner mBanner3;
    @BindView(R.id.banner_guide_content4)
    BGABanner mBanner4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO:顶部标题栏
//        initToolbar(mToolbar);
//        mToolbar.setTitle(R.string.military_world);
//        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
        mTopBar.setLeftIsVisiable(true);

        //TODO:轮播图,待改进
        initBanner();
    }

    private void initBanner() {
        List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(this, R.drawable.holder));
        views.add(BGABannerUtil.getItemImageView(this, R.drawable.holder));
        views.add(BGABannerUtil.getItemImageView(this, R.drawable.holder));
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

    @Override
    public int getContentViewId() {
        return R.layout.activity_military_world;
    }


}
