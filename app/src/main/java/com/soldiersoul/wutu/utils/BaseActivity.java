package com.soldiersoul.wutu.utils;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Chan on 2016/12/27 0027.
 * <p>
 * 简单的封装Activity基类
 */

public abstract class BaseActivity extends AppCompatActivity {

    Handler mHandler = new Handler ();

    //工具
    protected ToastUtil mToastUtil;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        setContentView (getContentViewId ());
        //注册butterKnife只能在setContentView之后
        ButterKnife.bind (this);
        initTools ();

    }

    /**
     * 初始化工具类
     */
    private void initTools () {
        String tag = this.getComponentName ().getClassName ();
        LogUtils.getBuilder ().setTag (tag).create ();
        mToastUtil = new ToastUtil (this);
    }

    public abstract int getContentViewId ();

    @Override
    protected void onDestroy () {
        super.onDestroy ();
    }

    /**
     * 几乎每个页面都会进行网络通信,会涉及到handler
     */
    protected void initHandler (Handler.Callback callback) {
        this.mHandler = new Handler (callback);
    }

    public Handler getHandler () {
        return mHandler;
    }

    /**
     * 初始化Toolbar
     *
     * @param toolbar
     */
    protected void initToolbar (Toolbar toolbar) {
        // 设置导航栏
        setSupportActionBar (toolbar);
        getSupportActionBar ().setDisplayShowTitleEnabled (false);

        toolbar.setNavigationOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                onBackPressed ();
            }
        });
    }

    /**
     * 设置页面的标题
     *
     * @param title
     */
    protected void setPageTitle (Toolbar toolbar, String title) {
        toolbar.setTitle (title);
    }

    /**
     * @param title
     */
    protected void setPageTitle (Toolbar toolbar, CharSequence title) {
        toolbar.setTitle (title);
    }

    /**
     * @param resId
     */
    protected void setNavigationIcon (Toolbar toolbar, int resId) {
        toolbar.setNavigationIcon (resId);
    }

}
