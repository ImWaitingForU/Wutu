package com.soldiersoul.wutu.Model;

import com.shuyu.common.model.RecyclerBaseModel;

/**
 * Created by wxj on 2017/2/27.
 */

public class CardModel extends RecyclerBaseModel {

    private int img1;
    private String tv1="";
    private String tv2="";

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public String getTv2() {
        return tv2;
    }

    public void setTv2(String tv2) {
        this.tv2 = tv2;
    }

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }
}