package com.soldiersoul.wutu.military;

import cn.bmob.v3.BmobObject;

/**
 * Created by wxj on 2017/4/9.
 */

public class MilitaryAdBean extends BmobObject{

    private String imgUrl;
    private String title;
    private String content;
    private String time;
    private int no;

    public MilitaryAdBean () {
    }

    public String getImgUrl () {
        return imgUrl;
    }

    public void setImgUrl (String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public String getTime () {
        return time;
    }

    public void setTime (String time) {
        this.time = time;
    }

    public int getNo () {
        return no;
    }

    public void setNo (int no) {
        this.no = no;
    }
}
