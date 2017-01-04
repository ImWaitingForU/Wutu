package com.soldiersoul.wutu.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Chan on 2016/12/28 0028.
 * <p>
 * 防止误操作的Dialog,可以在很多地方使用到
 */

public class MisoperationDialog extends AlertDialog {


    protected MisoperationDialog (Context context, boolean cancelable, OnCancelListener cancelListener) {
        super (context, cancelable, cancelListener);
    }

    public MisoperationDialog (Context context) {
        super (context);
    }

    /**
     * 初始化误操作对话框
     *
     * @param msg
     * @param positiveMsg 退出
     */
    public void initMisoperationDialog (Context context, String msg, String positiveMsg, boolean cancelable) {
        Builder builder = new Builder (context);
        builder.setMessage (msg).setCancelable (cancelable).setNegativeButton ("取消", new OnClickListener () {
            @Override
            public void onClick (DialogInterface dialog, int which) {
                dialog.cancel ();
            }
        }).setPositiveButton (positiveMsg, new OnClickListener () {
            @Override
            public void onClick (DialogInterface dialog, int which) {
                mListener.onPositiveClicked ();
            }
        }).show ();
    }

    private MisoperationListener mListener;

    public void setMisoperationListener (MisoperationListener listener) {
        mListener = listener;
    }

    public interface MisoperationListener {
        /**
         * 确认按钮按下
         */
        void onPositiveClicked ();
    }
}
