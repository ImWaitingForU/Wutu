package com.soldiersoul.wutu.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.soldiersoul.wutu.R;

/**
 * Created by Chan on 2017/1/7 0007.
 * <p>
 * 主界面的底部导航
 */

public class BottomBar extends LinearLayout implements View.OnClickListener {

    /**
     * 图片资源路径
     */
    private static final int[] IMG_ARRAY =
            {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    public BottomBar (Context context) {
        super (context);
    }

    public BottomBar (Context context, AttributeSet attrs) {
        super (context, attrs);
        initBottom (context);
    }

    private void initBottom (Context context) {
        setOrientation (HORIZONTAL);
        setElevation (4.0f);

        for (int i = 0; i < IMG_ARRAY.length; i++) {
            addView (context, IMG_ARRAY[i], i);
        }
    }

    /**
     * 添加底部菜单
     *
     * @param context
     * @param resId
     */
    private void addView (Context context, int resId, int tag) {
        ImageView iv = new ImageView (context);
        iv.setImageResource (resId);
        iv.setScaleType (ImageView.ScaleType.CENTER_INSIDE);
        LayoutParams params = new LayoutParams (0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        iv.setLayoutParams (params);
        iv.setOnClickListener (this);
        iv.setTag (tag);
        addView (iv);
    }

    /**
     * 所有菜单恢复原样
     */
    private void resumeMenu () {
        for (int i = 0; i < getChildCount (); i++) {
            ImageView view = (ImageView) getChildAt (i);
            view.setImageResource (IMG_ARRAY[0]);
        }
    }

    @Override
    public void onClick (View v) {
        ImageView iv = (ImageView) v;
        resumeMenu ();
        switch ((int) v.getTag ()) {
            case 0:
                iv.setImageResource (R.drawable.ic_visibility_24dp);
                mListener.onBottomBar1Clicked ();
                break;
            case 1:
                iv.setImageResource (R.drawable.ic_visibility_24dp);
                mListener.onBottomBar2Clicked ();
                break;
            case 2:
                iv.setImageResource (R.drawable.ic_visibility_24dp);
                mListener.onBottomBar3Clicked ();
                break;
            case 3:
                iv.setImageResource (R.drawable.ic_visibility_24dp);
                mListener.onBottomBar4Clicked ();
                break;
            default:
                break;
        }
    }

    private BottomBarClickedListener mListener;

    public void setBottomBarClickedListener (BottomBarClickedListener listener) {
        this.mListener = listener;
    }

    public interface BottomBarClickedListener {

        /**
         * 切换到军事天地Fragment
         */
        void onBottomBar1Clicked ();

        /**
         * 切换到社团界面Fragment
         */
        void onBottomBar2Clicked ();

        /**
         * 切换到目标管理Fragment
         */
        void onBottomBar3Clicked ();

        /**
         * 切换到我的界面Fragment
         */
        void onBottomBar4Clicked ();
    }

}
