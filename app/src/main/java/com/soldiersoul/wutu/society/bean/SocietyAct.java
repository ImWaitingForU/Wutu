package com.soldiersoul.wutu.society.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Rose on 2017/3/5.
 * <p>
 * 社团活动Bean类
 */

public class SocietyAct extends BmobObject {

    private String actName;
    private String startTime;
    private String endTime;
    private String actContent;
    private String actPlanner;
    private String actLocation;
    //一个相册对应一个社团活动
    private SocietyAlbumBean albumBean;

    //一个社团有很多社团活动
    private SocietyBean societyBean;

    /**
     * 活动进行中/已结束
     */
    private boolean isActive;

    public SocietyAct () {
    }

    public SocietyAct (String actName, String startTime, String endTime, String actContent, String actPlanner,
                       String actLocation, SocietyAlbumBean albumBean, SocietyBean societyBean, boolean isActive) {
        this.actName = actName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.actContent = actContent;
        this.actPlanner = actPlanner;
        this.actLocation = actLocation;
        this.albumBean = albumBean;
        this.societyBean = societyBean;
        this.isActive = isActive;
    }

    public String getActName () {
        return actName;
    }

    public void setActName (String actName) {
        this.actName = actName;
    }

    public String getStartTime () {
        return startTime;
    }

    public void setStartTime (String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime () {
        return endTime;
    }

    public void setEndTime (String endTime) {
        this.endTime = endTime;
    }

    public String getActContent () {
        return actContent;
    }

    public void setActContent (String actContent) {
        this.actContent = actContent;
    }

    public String getActPlanner () {
        return actPlanner;
    }

    public void setActPlanner (String actPlanner) {
        this.actPlanner = actPlanner;
    }

    public String getActLocation () {
        return actLocation;
    }

    public void setActLocation (String actLocation) {
        this.actLocation = actLocation;
    }

    public SocietyAlbumBean getAlbumBean () {
        return albumBean;
    }

    public void setAlbumBean (SocietyAlbumBean albumBean) {
        this.albumBean = albumBean;
    }

    public SocietyBean getSocietyBean () {
        return societyBean;
    }

    public void setSocietyBean (SocietyBean societyBean) {
        this.societyBean = societyBean;
    }

    public boolean isActive () {
        return isActive;
    }

    public void setActive (boolean active) {
        isActive = active;
    }
}
