package com.soldiersoul.wutu.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Chan on 2016/12/28 0028.
 * <p>
 * SharedPreference有关工具类
 */

public class SpUtils {

    /**
     * SharedPreferrence名
     */
    public static final String SP_NAME = "WutuSp";

    /**
     * 用户名KEY
     */
    public static final String KEY_USERNAME = "username";
    /**
     * 密码KEY
     */
    public static final String KEY_PWD = "pwd";
    /**
     * 是否第一次登录KEY
     */
    public static final String KEY_IS_FIRST_LOGIN = "IsFirstLogin";

    /**
     * 是否第一次使用
     */
    public static final String KEY_IS_FIRST_USE = "IsFirstLogin";

    private static SharedPreferences sp;

    public SpUtils (Context context) {
        sp = context.getSharedPreferences (SP_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 往WutuSp存入String值
     */
    public static void putString (String key, String value) {
        SharedPreferences.Editor editor = sp.edit ();
        editor.putString (key, value);
        editor.apply ();
    }

    /**
     * 从WutuSp拿出String
     */
    public static String getString (String key, String defValue) {
        return sp.getString (key, defValue);
    }

    /**
     * 往WutuSp存入boolean值
     */
    public static void putBoolean (String key, boolean value) {
        SharedPreferences.Editor editor = sp.edit ();
        editor.putBoolean (key, value);
        editor.apply ();
    }

    /**
     * 从WutuSp拿出String
     */
    public static Boolean getBoolean (String key, Boolean defValue) {
        return sp.getBoolean (key, defValue);
    }

    /**
     * 往WutuSp存入int值
     */
    public static void putInteger (String key, int value) {
        SharedPreferences.Editor editor = sp.edit ();
        editor.putInt (key, value);
        editor.apply ();
    }

    /**
     * 从WutuSp拿出int值
     */
    public static int getInteger (String key, int defValue) {
        return sp.getInt (key, defValue);
    }

}
