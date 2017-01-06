package com.soldiersoul.wutu.utils;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.soldiersoul.wutu.R;


/**
 * Created by Chan on 2016/12/10 0010.
 * <p>
 * 自定义Toast工具类
 * (显示绿地白字的Toast)
 */

public class ToastUtil {

    private Toast mToast;
    private Context mContext;
    private View toastView;
    private TextView tv;

    public ToastUtil (Context context) {
        this.mContext = context;
        mToast = new Toast (mContext);
        //初始化Toast
        toastView = View.inflate (mContext, R.layout.toast_layout, null);
        mToast.setView (toastView);
        tv = (TextView) toastView.findViewById (R.id.tvToast);
    }

    public void setToastView (int layoutId) {
        mToast.setView (View.inflate (mContext, layoutId, null));
    }

    public void toastShort (String msg) {
        tv.setText (msg);
        mToast.setDuration (Toast.LENGTH_SHORT);
        mToast.show ();
    }

    public void toastLong (String msg) {
        tv.setText (msg);
        mToast.setDuration (Toast.LENGTH_LONG);
        mToast.show ();
    }

    public TextView getTv () {
        return tv;
    }

    public void setTv (TextView tv) {
        this.tv = tv;
    }
}
