package com.soldiersoul.wutu.views;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private int[] imgArray = {R.drawable.ic_military_pressed, R.drawable.ic_society_pressed, R.drawable.ic_manage_pressed, R
            .drawable.ic_me_pressed};

    public BottomBar (Context context) {
        super (context);
    }

    public BottomBar (Context context, AttributeSet attrs) {
        super (context, attrs);
        initBottom (context);
    }

    private void initBottom (Context context) {
        setOrientation (HORIZONTAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setElevation (4.0f);
        }

        for (int i = 0; i < imgArray.length; i++) {
            addView (context, imgArray[i], i);
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
        if (tag == 0) {
            //默认显示第一页
            iv.setImageResource (R.drawable.ic_military);
        } else {
            iv.setImageResource (resId);
        }
        iv.setScaleType (ImageView.ScaleType.CENTER);

        TextView tv = new TextView (context);
        tv.setTextColor (Color.LTGRAY);
        tv.setTextSize (12f);
        tv.setGravity (Gravity.CENTER_HORIZONTAL);
        switch (tag) {
            case 0:
                tv.setText ("军事");
                break;
            case 1:
                tv.setText ("社团");
                break;
            case 2:
                tv.setText ("武器");
                break;
            case 3:
                tv.setText ("更多");
                break;
            default:
                break;
        }

        LinearLayout ll = new LinearLayout (context);
        ll.setOrientation (VERTICAL);
        ll.setGravity (Gravity.CENTER_HORIZONTAL);
        LayoutParams params = new LayoutParams (0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        ll.setLayoutParams (params);
        ll.setTag (tag);
        ll.setOnClickListener (this);

        LayoutParams p = new LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        p.gravity = Gravity.CENTER;
        p.setMargins (0,10,0,10);
        ll.addView (iv, p);
        ll.addView (tv, p);

        addView (ll);
    }

    /**
     * 所有菜单恢复原样
     */
    private void resumeMenu () {
        for (int i = 0; i < getChildCount (); i++) {
            LinearLayout view = (LinearLayout) getChildAt (i);
            ImageView iv = (ImageView) view.getChildAt (0);
            iv.setImageResource (imgArray[i]);
            TextView tv = (TextView) view.getChildAt (1);
            tv.setTextColor (Color.LTGRAY);
        }
    }

    /**
     * 设置选中后的ui效果
     *
     * @param iv
     * @param resId
     * @param tv
     */
    private void setSelectedUi (ImageView iv, int resId, TextView tv) {
        iv.setImageResource (resId);
        tv.setTextColor (Color.WHITE);
    }

    @Override
    public void onClick (View v) {
        LinearLayout ll = (LinearLayout) v;
        ImageView iv = (ImageView) ll.getChildAt (0);
        TextView tv = (TextView) ll.getChildAt (1);
        resumeMenu ();
        switch ((int) v.getTag ()) {
            case 0:
                setSelectedUi (iv, R.drawable.ic_military, tv);
                mListener.onBottomBar1Clicked ();
                break;
            case 1:
                setSelectedUi (iv, R.drawable.ic_society, tv);
                mListener.onBottomBar2Clicked ();
                break;
            case 2:
                setSelectedUi (iv, R.drawable.ic_manage, tv);
                mListener.onBottomBar3Clicked ();
                break;
            case 3:
                setSelectedUi (iv, R.drawable.ic_me, tv);
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
