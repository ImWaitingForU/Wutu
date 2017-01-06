package com.soldiersoul.wutu.views;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.soldiersoul.wutu.R;

/**
 * Created by Chan on 2016/12/28 0028.
 * <p>
 * 自定义倒计时获取验证码按钮
 */

public class CountDownButton extends Button implements View.OnClickListener {

    private static final long MILLIS_FUTURE = 60000;
    private static final long INTERVAL = 1000;

    private static final String GET_VERIFY = "获取验证码";
    private static final String VERIFYING = "秒后重新获取";

    private static boolean isCountdown = false;
    private CountDownTimer countDownTimer;

    public CountDownButton (Context context, AttributeSet attrs) {
        super (context, attrs);
        this.setOnClickListener (this);
    }

    public CountDownButton (Context context) {
        super (context);
    }

    private void startCountDown () {
        countDownTimer = new CountDownTimer (MILLIS_FUTURE, INTERVAL) {
            @Override
            public void onTick (long millisUntilFinished) {
                setText (String.valueOf (millisUntilFinished / 1000) + VERIFYING);
                setBackground (getResources ().getDrawable (R.color.colorPrimaryDark, null));
            }

            @Override
            public void onFinish () {
                setText (GET_VERIFY);
                setBackground (getResources ().getDrawable (R.color.colorPrimary, null));
                isCountdown = false;
            }
        };
        countDownTimer.start ();
        isCountdown = true;
    }

    /**
     * 取消到计时，在界面销毁调用
     */
    public void cancelCountDown () {
        if (countDownTimer != null) {
            countDownTimer.cancel ();
        }
        isCountdown = false;
    }


    @Override
    public void onClick (View v) {
        if (!isCountdown) {
            //TODO:在服务器回调成功后开始计时，而不是一点击就开始计时
            startCountDown ();
            mVerifyListener.onGettingVerify ();
        }
    }

    private GetVerifyListener mVerifyListener;

    public void setVerifyListener (GetVerifyListener verifyListener) {
        mVerifyListener = verifyListener;
    }

    /**
     * 获取验证码监听器
     */
    public interface GetVerifyListener {
        /**
         * 按下获取验证码后调用
         */
        void onGettingVerify ();
    }
}
