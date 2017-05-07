package com.soldiersoul.wutu.Model;

import com.shuyu.common.model.RecyclerBaseModel;

/**
 * Created by shuyu on 2016/11/23.
 */

public class VideoModel extends RecyclerBaseModel {
    private String fengmianRes  ;
    private int btnRes;

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

