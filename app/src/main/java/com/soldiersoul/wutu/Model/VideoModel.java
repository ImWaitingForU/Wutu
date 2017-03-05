package com.soldiersoul.wutu.Model;

import android.graphics.drawable.Drawable;

import com.shuyu.common.model.RecyclerBaseModel;

/**
 * Created by shuyu on 2016/11/23.
 */

public class VideoModel extends RecyclerBaseModel {
    private int fengmianRes  ;
    private int btnRes;

    public int getFengmianRes() {
        return fengmianRes;
    }

    public void setFengmianRes(int fengmianRes) {
        this.fengmianRes = fengmianRes;
    }

    public int getBtnRes() {
        return btnRes;
    }

    public void setBtnRes(int btnRes) {
        this.btnRes = btnRes;
    }
}

