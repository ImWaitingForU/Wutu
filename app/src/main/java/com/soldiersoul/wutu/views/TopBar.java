package com.soldiersoul.wutu.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.soldiersoul.wutu.R;

/**
 * Created by Chan on 2017/1/2 0002.
 * 顶部通用导航栏
 */

public class TopBar extends RelativeLayout {
    //new出我们要用到的控件
    private Button leftButton, rightButton;
    private TextView tvTitle;

    //在代码里实例化要用到的属性
    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    private float titleTextSize;
    private int titleTextColor;
    private String title;

    private LayoutParams leftParams, rightParams, titleParams;

    private TopbarClickListener listener;

    //Button单击的回调接口
    public interface TopbarClickListener {
        void leftClick ();

        void rightClick ();
    }

    public void setOnTopbarClickListener (TopbarClickListener listener) {
        this.listener = listener;
    }

    //1、因为要获取我们刚刚自定义的一些属性，所以我们选择android提供的两个参数的构造函数
    public TopBar (Context context, AttributeSet attrs) {
        super (context, attrs);

        TypedArray ta = context.obtainStyledAttributes (attrs, R.styleable.TopBar);

        leftTextColor = ta.getColor (R.styleable.TopBar_left_text_color, 0);
        leftBackground = ta.getDrawable (R.styleable.TopBar_left_text_background);
        leftText = ta.getString (R.styleable.TopBar_left_text);

        rightTextColor = ta.getColor (R.styleable.TopBar_right_text_color, 0);
        rightBackground = ta.getDrawable (R.styleable.TopBar_right_text_background);
        rightText = ta.getString (R.styleable.TopBar_right_text);

        title = ta.getString (R.styleable.TopBar_title_text);
        titleTextColor = ta.getColor (R.styleable.TopBar_title_text_color, 0);
        titleTextSize = ta.getDimension (R.styleable.TopBar_title_text_size, 14.0f);

        ta.recycle ();

        leftButton = new Button (context);
        rightButton = new Button (context);
        tvTitle = new TextView (context);

        leftButton.setTextColor (leftTextColor);
        leftButton.setBackground (leftBackground);
        leftButton.setText (leftText);
        leftButton.setCompoundDrawables (context.getDrawable (R.drawable.top_back), null, null, null);

        rightButton.setTextColor (rightTextColor);
        rightButton.setBackground (rightBackground);
        rightButton.setText (rightText);

        tvTitle.setText (title);
        tvTitle.setTextColor (titleTextColor);
        tvTitle.setTextSize (titleTextSize);
        tvTitle.setGravity (Gravity.CENTER);

        leftParams = new LayoutParams (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftParams.addRule (RelativeLayout.ALIGN_PARENT_LEFT, TRUE);

        addView (leftButton, leftParams);

        rightParams = new LayoutParams (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightParams.addRule (RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);

        addView (rightButton, rightParams);

        titleParams = new LayoutParams (LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        titleParams.addRule (RelativeLayout.CENTER_IN_PARENT, TRUE);

        addView (tvTitle, titleParams);

        //为左右Button添加单击事件
        leftButton.setOnClickListener (new OnClickListener () {
            @Override
            public void onClick (View v) {
                listener.leftClick ();
            }
        });
        rightButton.setOnClickListener (new OnClickListener () {
            @Override
            public void onClick (View v) {
                listener.rightClick ();
            }
        });
    }

    //设置左Button是否可见
    public void setLeftIsVisiable (boolean flag) {
        if (flag) {
            leftButton.setVisibility (VISIBLE);
        } else {
            leftButton.setVisibility (GONE);
        }
    }
}
