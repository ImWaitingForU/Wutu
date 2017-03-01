package com.soldiersoul.wutu.society;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PagerContainer;

/**
 * 原社区荣誉界面，舍不得删...
 */
public class HonorActivity extends BaseActivity {

    @BindView (R.id.tvDailyStar) TextView tvDailyStar;
    @BindView (R.id.pcDailyStar) PagerContainer pcDailyStar;
    @BindView (R.id.tvGoodMember) TextView tvGoodMember;
    @BindView (R.id.pcGoodMember) PagerContainer pcGoodMember;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        ArrayList<Bitmap> bitmaps = new ArrayList<> ();
        bitmaps.add (BitmapFactory.decodeResource (getResources (), R.drawable.back1));
        bitmaps.add (BitmapFactory.decodeResource (getResources (), R.drawable.back2));
        bitmaps.add (BitmapFactory.decodeResource (getResources (), R.drawable.back3));
        bitmaps.add (BitmapFactory.decodeResource (getResources (), R.drawable.back4));
        bitmaps.add (BitmapFactory.decodeResource (getResources (), R.drawable.back5));

        initPicShow (pcDailyStar, bitmaps, tvDailyStar);
        initPicShow (pcGoodMember, bitmaps, tvGoodMember);
    }

    /**
     * 初始化每日之星,优秀社员图片展示
     */
    private void initPicShow (PagerContainer pagerContainer, ArrayList<Bitmap> bitmaps, final TextView tvShow) {

        pagerContainer.setOverlapEnabled (false);
        ViewPager viewpager = pagerContainer.getViewPager ();
        viewpager.setOffscreenPageLimit (5);
        viewpager.setClipChildren (false);
        viewpager.setAdapter (new MyViewPagerAdapter (bitmaps));
        viewpager.addOnPageChangeListener (new ViewPager.OnPageChangeListener () {
            @Override
            public void onPageScrolled (int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected (int position) {
                tvShow.setText ("i:" + position);
            }

            @Override
            public void onPageScrollStateChanged (int state) {

            }
        });

        new CoverFlow.Builder ().with (viewpager).scale (0.3f).pagerMargin (0f).spaceSize (0f).rotationY (25f).build ();
    }

    /**
     * 每日之星，优秀社员图片展示使用
     */
    private class MyViewPagerAdapter extends PagerAdapter {

        private ArrayList<Bitmap> mBitmaps;

        public MyViewPagerAdapter (ArrayList<Bitmap> bitmaps) {
            mBitmaps = bitmaps;
        }

        @Override
        public int getCount () {
            return mBitmaps.size ();
        }

        @Override
        public boolean isViewFromObject (View view, Object object) {
            return (view == object);
        }

        @Override
        public Object instantiateItem (ViewGroup container, int position) {
            View view = LayoutInflater.from (HonorActivity.this).inflate (R.layout.honor_img, null);
            ImageView iv = (ImageView) view.findViewById (R.id.ivHonor);
            iv.setImageBitmap (mBitmaps.get (position));
            iv.setScaleType (ImageView.ScaleType.CENTER_CROP);
            container.addView (view);
            return view;
        }

        @Override
        public void destroyItem (ViewGroup container, int position, Object object) {
            container.removeView ((View) object);
        }
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_honor;
    }
}
