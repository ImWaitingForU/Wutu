package com.soldiersoul.wutu.Model;

import com.shuyu.common.model.RecyclerBaseModel;

/**
 * Created by shuyu on 2016/11/23.
 */

public class VideoModel extends RecyclerBaseModel {
    private String fengmianRes  ;
    private int btnRes;

    private String videoUrl;
    private String videoTitle;
    private String videoResouce;

    public String getVideoTitle () {
        return videoTitle;
    }

    public void setVideoTitle (String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoResouce () {
        return videoResouce;
    }

    public void setVideoResouce (String videoResouce) {
        this.videoResouce = videoResouce;
    }

    public String getVideoUrl () {
        return videoUrl;
    }

    public void setVideoUrl (String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getFengmianRes () {
        return fengmianRes;
    }

    public void setFengmianRes (String fengmianRes) {
        this.fengmianRes = fengmianRes;
    }

    public int getBtnRes() {
        return btnRes;
    }

    public void setBtnRes(int btnRes) {
        this.btnRes = btnRes;
    }
}

