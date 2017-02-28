package com.soldiersoul.wutu.beans;

/**
 * Created by wxj on 2017/2/28.
 *
 * 军事新闻bean
 */

public class MnewsBean {

    private String news_title;
    private String news_content;
    private String news_time;
    private String news_img_url;
    private String news_source;

    public MnewsBean(){

    }

    //构造
    public MnewsBean(String news_title, String news_content, String news_time, String news_img_url, String news_source) {
        this.news_title = news_title;
        this.news_content = news_content;
        this.news_time = news_time;
        this.news_img_url = news_img_url;
        this.news_source = news_source;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getNews_time() {
        return news_time;
    }

    public void setNews_time(String news_time) {
        this.news_time = news_time;
    }

    public String getNews_img_url() {
        return news_img_url;
    }

    public void setNews_img_url(String news_img_url) {
        this.news_img_url = news_img_url;
    }

    public String getNews_source() {
        return news_source;
    }

    public void setNews_source(String news_source) {
        this.news_source = news_source;
    }
}
