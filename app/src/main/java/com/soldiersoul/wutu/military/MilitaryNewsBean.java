package com.soldiersoul.wutu.military;

import com.shuyu.common.model.RecyclerBaseModel;

/**
 * Created by wxj on 2017/1/11.
 * 军事新闻Bean
 */

public class MilitaryNewsBean extends RecyclerBaseModel {

    /**
     * 新闻标题
     */
    private String newsTitle;
    /**
     * 新闻图片url
     */
    private String newsImageUrl;
    /**
     * 新闻发布日期
     */
    private String newsDate;
    /**
     * 新闻来源
     */
    private String newsSource;
    /**
     * 新闻详细内容
     */
    private String newsContent;

    /**
     * 标识新闻的编号
     */
    private Integer no;

    /**
     * 视频url
     */
    private String videoUrl;

    public MilitaryNewsBean () {
    }

    //构造器
    public MilitaryNewsBean (String newsTitle, String newsImageUrl, String newsDate, String newsSource,
                             String newsContent, String videoUrl) {
        this.newsTitle = newsTitle;
        this.newsImageUrl = newsImageUrl;
        this.newsDate = newsDate;
        this.newsSource = newsSource;
        this.newsContent = newsContent;
        this.videoUrl = videoUrl;
    }

    public Integer getNo () {
        return no;
    }

    public void setNo (Integer no) {
        this.no = no;
    }

    public String getVideoUrl () {
        return videoUrl;
    }

    public void setVideoUrl (String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getNewsTitle () {
        return newsTitle;
    }

    public void setNewsTitle (String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsImageUrl () {
        return newsImageUrl;
    }

    public void setNewsImageUrl (String newsImageUrl) {
        this.newsImageUrl = newsImageUrl;
    }

    public String getNewsDate () {
        return newsDate;
    }

    public void setNewsDate (String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsSource () {
        return newsSource;
    }

    public void setNewsSource (String newsSource) {
        this.newsSource = newsSource;
    }

    public String getNewsContent () {
        return newsContent;
    }

    public void setNewsContent (String newsContent) {
        this.newsContent = newsContent;
    }
}
