package com.soldiersoul.wutu.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

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


}
