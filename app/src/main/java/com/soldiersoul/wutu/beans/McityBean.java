package com.soldiersoul.wutu.beans;

/**
 * Created by wxj on 2017/2/28.
 * 省份详情bean
 *
 * 安徽-1
 * 澳门-2
 * 北京-4
 * 福建-6
 * 甘肃-8
 * 广东-9
 * 广西-10
 * 贵州-11
 * 海南-13
 * 河北-14
 * 黑龙江-15
 * 河南-16
 * 湖北-17
 * 湖南-18
 * 江苏-20
 * 江西-21
 * 吉林-22
 * 辽宁-24
 * 内蒙古-26
 * 宁夏-27
 * 青海-29
 * 山东-31
 * 上海-32
 * 陕西-33
 * 山西-34
 * 四川-35
 * 台湾-37
 * 天津-38
 * 香港-40
 * 新疆-41
 * 西藏-42
 * 云南-44
 * 浙江-46
 * 重庆-47
 *
 */

public class McityBean {

    private String cityDetailTitle;
    private String cityDetailContent;
    private String cityDetailSource;
    private String cityDetailTime;

    public McityBean(){

    }
    //构造


    public McityBean(String cityDetailTitle, String cityDetailContent, String cityDetailSource, String cityDetailTime) {
        this.cityDetailTitle = cityDetailTitle;
        this.cityDetailContent = cityDetailContent;
        this.cityDetailSource = cityDetailSource;
        this.cityDetailTime = cityDetailTime;
    }

    public String getCityDetailTitle() {
        return cityDetailTitle;
    }

    public void setCityDetailTitle(String cityDetailTitle) {
        this.cityDetailTitle = cityDetailTitle;
    }

    public String getCityDetailContent() {
        return cityDetailContent;
    }

    public void setCityDetailContent(String cityDetailContent) {
        this.cityDetailContent = cityDetailContent;
    }

    public String getCityDetailSource() {
        return cityDetailSource;
    }

    public void setCityDetailSource(String cityDetailSource) {
        this.cityDetailSource = cityDetailSource;
    }

    public String getCityDetailTime() {
        return cityDetailTime;
    }

    public void setCityDetailTime(String cityDetailTime) {
        this.cityDetailTime = cityDetailTime;
    }
}
