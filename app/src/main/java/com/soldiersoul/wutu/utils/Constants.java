package com.soldiersoul.wutu.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Chan on 2016/12/26 0026.
 * <p>
 * 存放常量
 */

public class Constants {

    /**
     * Bmob的appkey
     */
    public static final String BMOB_APPKEY = "2cc3116ad9187a3b8cca8f37da4338e0";

    /**
     * 武器类型
     */
    public static class WeaponType {
        public static final String SHOU_QIANG = "手枪";
        public static final String CHONG_FENG_QIANG = "冲锋枪";
        public static final String DAO_DAN = "导弹";
        public static final String TAN_KE = "坦克";
    }

    /**
     * 获取Activity的rootView
     */
    public static View getRootView (Activity context) {
        return ((ViewGroup) context.findViewById (android.R.id.content)).getChildAt (0);
    }

    /**
     * dip转为PX
     */
    public static int dip2px(Context context, float dipValue) {
        float fontScale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * fontScale + 0.5f);
    }

    /**
     * 返回昨天
     * @param today
     * @return
     */
    public static java.util.Date yesterday(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        return calendar.getTime();
    }

    /**
     * 返回明天
     * @param today
     * @return
     */
    public static java.util.Date tomorrow(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        return calendar.getTime();
    }


}
