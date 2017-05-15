package com.soldiersoul.wutu.beans;

import cn.bmob.v3.BmobObject;

/**
 * Created by Rose on 2017/5/15.
 * <p>
 * 城市具体政策的Bean
 */

public class CityPolicyBean extends BmobObject {

    private String cityName;
    private String title;
    private String content;
    private String resource;
    private String time;

    public String getCityName () {
        return cityName;
    }

    public void setCityName (String cityName) {
        this.cityName = cityName;
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

    public String getResource () {
        return resource;
    }

    public void setResource (String resource) {
        this.resource = resource;
    }

    public String getTime () {
        return time;
    }

    public void setTime (String time) {
        this.time = time;
    }
}
