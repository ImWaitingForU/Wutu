package com.soldiersoul.wutu.military;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 播放军事新闻视频的界面
 */
public class VideoPlayerAct extends BaseActivity {

    @BindView (R.id.videoplayer) JCVideoPlayerStandard videoPlayer;
    @BindView (R.id.tvVideoTitle) TextView title;
    @BindView (R.id.tvVideoResource) TextView resource;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        setHomeButtonStaff ("视频新闻");

        Intent intent = getIntent ();
        String url = intent.getStringExtra ("url");
        String titleText = intent.getStringExtra ("title");
        String logo = intent.getStringExtra ("logo");
        String resourceText = intent.getStringExtra ("resource");

        //配置视频信息
//        String url = "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4";
        videoPlayer.setUp (url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, titleText);
        videoPlayer.thumbImageView.setImageURI (Uri.parse (logo));
        title.setText (titleText);
        resource.setText ("  视频来源:" + resourceText);
    }

    @Override
    protected void onDestroy () {
        //退出时记录浏览位置
//        SpUtils sp = new SpUtils (this);
//        SpUtils.putInteger (SpUtils.KEY_LAST_POSITION,getIntent ().getIntExtra ("newsNo",0));
        super.onDestroy ();
    }

    @Override
    public void onBackPressed () {
        if (JCVideoPlayer.backPress ()) {
            return;
        }
        super.onBackPressed ();
    }

    @Override
    protected void onPause () {
        super.onPause ();
        JCVideoPlayer.releaseAllVideos ();
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_video_player;
    }
}
