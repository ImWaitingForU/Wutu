package com.soldiersoul.wutu.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by Rose on 2017/5/15.
 */

public class CustomerVideoView extends VideoView {

    public CustomerVideoView (Context context, AttributeSet attrs) {
        super (context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //我们重新计算高度
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}
