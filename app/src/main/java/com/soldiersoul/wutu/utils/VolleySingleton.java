package com.soldiersoul.wutu.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Rose on 2017/1/30.
 * <p>
 * 封装Volley的单例模式，使用时使用VolleyUtils.getInstance().addToRequestQueue();
 */

public class VolleySingleton {

    private String TAG = "VolleySingleton";

    private static Context mContext;

    /**
     * 总url
     */
    public static final String HOST = "";

    /* todo:各个模块url */
    public static final String URL = "";

    private static VolleySingleton mInstance;
    private RequestQueue mRequestQueue;

    private VolleySingleton (Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue ();
    }

    public static synchronized VolleySingleton getInstance (Context context) {
        if (mInstance == null) {
            mInstance = new VolleySingleton (context);
        }

        return mInstance;
    }

    public RequestQueue getRequestQueue () {
        if (mRequestQueue == null) {
            // 使用getApplicationContext避免内存泄漏
            mRequestQueue = Volley.newRequestQueue (mContext.getApplicationContext ());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue (Request<T> request) {
        getRequestQueue ().add (request);
    }

}
