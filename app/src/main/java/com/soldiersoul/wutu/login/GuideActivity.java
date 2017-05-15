package com.soldiersoul.wutu.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.LogUtils;
import com.soldiersoul.wutu.utils.SpUtils;

/**
 * // * 引导视频 -- 2017中国征兵视频
 * <p>
 * 引导视频改为引导gif。
 */
public class GuideActivity extends AppCompatActivity {

    //    private CustomerVideoView videoPlayer;
    private SpUtils spUtils;

    //定时5秒后进入
    Handler handler = new Handler () ;

    Runnable runnable = new Runnable () {
        @Override
        public void run () {
            SpUtils.putBoolean (SpUtils.KEY_IS_FIRST_USE, false);
            goToLoginPage ();
        }
    };

    @Override
    protected void onPause () {
        handler.removeCallbacks (runnable);
        super.onPause ();
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //设置无标题
        requestWindowFeature (Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow ().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView (R.layout.activity_guide_activitiy);
        spUtils = new SpUtils (this);

        //        videoPlayer = (CustomerVideoView) findViewById (R.id.vp);
        //        String uri = "android.resource://" + getPackageName () + "/" + R.raw.guide;
        //        videoPlayer.setVideoURI (Uri.parse (uri));

        //播放完成进入APP
        //        videoPlayer.setOnCompletionListener (new MediaPlayer.OnCompletionListener () {
        //            @Override
        //            public void onCompletion (MediaPlayer mediaPlayer) {
        //                SpUtils.putBoolean (SpUtils.KEY_IS_FIRST_USE, false);
        //            }
        //        });

        if (SpUtils.getBoolean (SpUtils.KEY_IS_FIRST_USE, true)) {
            //第一次使用播放视频
            //            videoPlayer.start ();
            //            LogUtils.d ("播放引导视频");
            handler.postDelayed (runnable,4000);
            LogUtils.d ("播放引导gif");
        } else {
            //直接跳转到登录界面
            goToLoginPage ();
            LogUtils.d ("直接跳转登陆");
        }

    }

    private void goToLoginPage () {
        startActivity (new Intent (this, LoginActivity.class));
        this.finish ();
    }
}
