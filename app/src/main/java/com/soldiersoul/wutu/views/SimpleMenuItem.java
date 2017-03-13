package com.soldiersoul.wutu.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.soldiersoul.wutu.R;

/**
 * Created by Rose on 2017/2/26.
 * <p>
 * 简单的条形菜单项,设置一个图片和点击事件
 */

public class SimpleMenuItem extends RelativeLayout {

    private TextView tv;

    public SimpleMenuItem (Context context) {
        super (context);
    }

    @RequiresApi (api = Build.VERSION_CODES.LOLLIPOP)
    public SimpleMenuItem (Context context, AttributeSet attrs) {
        super (context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes (attrs, R.styleable.SimpleMenuItem);
        String text = typedArray.getString (R.styleable.SimpleMenuItem_itemText);
        Drawable drawable = typedArray.getDrawable (R.styleable.SimpleMenuItem_imgSrc);

        setBackgroundResource (R.drawable.white_btn_selector);
        setPadding (40, 40, 40, 40);
        setElevation (4);

        tv = new TextView (context);
        ImageView iv = new ImageView (context);
        ImageView iv2 = new ImageView (context);

        tv.setText (text);
        tv.setTextColor (Color.BLACK);
        iv.setImageDrawable (drawable);
        iv2.setImageResource (R.drawable.ic_right);

        LayoutParams p1 = new LayoutParams (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LayoutParams p2 = new LayoutParams (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LayoutParams p3 = new LayoutParams (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        p1.addRule (RelativeLayout.ALIGN_PARENT_LEFT);
        p2.addRule (RelativeLayout.CENTER_IN_PARENT);
        p3.addRule (RelativeLayout.ALIGN_PARENT_RIGHT);
        iv.setLayoutParams (p1);
        tv.setLayoutParams (p2);
        iv2.setLayoutParams (p3);


        addView (iv);
        addView (tv);
        addView (iv2);
        typedArray.recycle ();
    }

    /**
     * 设置中间item的文字
     */
    public void setItemText (String text) {
        if (tv != null) {
            tv.setText (text);
        }
    }

}
