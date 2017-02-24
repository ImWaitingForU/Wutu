package com.soldiersoul.wutu.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by chan on 2017/2/24.
 * <p>
 * 使用Volley的封装,请求地址
 */

public class VolleyUtils {

    public static final String HOST = "";
    public static final String URL = "";
    private static final String TAG = "VolleyUtils";

	/* ....... */

    /**
     * 访问url获取jsonObject
     *
     * @param context
     * @param url
     * @param jsonObjectListener 自定义回调处理
     * @param errorListener      自定义错误处理
     */
    public static void getJsonObject (Context context, String url, Response.Listener<JSONObject> jsonObjectListener,
                                      Response.ErrorListener errorListener) {
        JsonObjectRequest request = new JsonObjectRequest (url, null, jsonObjectListener, errorListener);
        VolleySingleton.getInstance (context).addToRequestQueue (request);
    }

    /**
     * post请求，获取返回的String 字符串
     */
    public static void getSimplePostString (Context context, final Map params, String url,
                                            Response.Listener<String> listener, Response.ErrorListener errorListener) {
        StringRequest request = new StringRequest (Request.Method.POST, url, listener, errorListener) {
            @Override
            protected Map<String, String> getParams () throws AuthFailureError {
                if (params == null) {
                    Log.e (TAG, "getParams: params can not be null");
                    return null;
                }
                return params;
            }
        };
        VolleySingleton.getInstance (context).addToRequestQueue (request);
    }

	/* 图片使用Picasso */

    /**
     * 自定义Gson请求
     *
     * @param <T>
     */
    public class GsonRequest<T> extends Request<T> {

        private Response.Listener<T> mListener;
        private Gson mGson;
        private Class<T> mTClass;

        public GsonRequest (int method, String url, Class<T> tClass, Response.Listener<T> listener,
                            Response.ErrorListener errorListener) {
            super (method, url, errorListener);
            mGson = new Gson ();
            mTClass = tClass;
            mListener = listener;
        }

        @Override
        protected Response<T> parseNetworkResponse (NetworkResponse response) {
            try {
                String jsonString = new String (response.data, HttpHeaderParser.parseCharset (response.headers));
                return Response
                        .success (mGson.fromJson (jsonString, mTClass), HttpHeaderParser.parseCacheHeaders (response));

            } catch (UnsupportedEncodingException e) {
                return Response.error (new ParseError (e));
            }
        }

        @Override
        protected void deliverResponse (T response) {
            mListener.onResponse (response);
        }
    }
}
