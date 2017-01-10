package com.soldiersoul.wutu.views;

/**
 * Created by chan on 2017/1/10.
 * <p>
 * 自动显示跑马灯效果的TextView
 */

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Chan on 2016/3/17.
 * 实现跑马灯效果的TextView
 */
public class MarqueeTextView extends TextView {

    public MarqueeTextView (Context context) {
        super (context);
    }

    public MarqueeTextView (Context context, AttributeSet attrs) {
        super (context, attrs);
    }

    public MarqueeTextView (Context context, AttributeSet attrs, int defStyleAttr) {
        super (context, attrs, defStyleAttr);
    }

    //返回textview是否处在选中的状态
    //而只有选中的textview才能够实现跑马灯效果
    @Override
    public boolean isFocused () {
        return true;
    }
}