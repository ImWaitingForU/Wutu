package com.soldiersoul.wutu.Model;

import com.shuyu.common.model.RecyclerBaseModel;

/**
 * Created by shuyu on 2016/11/23.
 */

public class ImageModel extends RecyclerBaseModel {
    private String imgUrl;
    private String newsTitle;
    private String newsContent;
    private String newsTime;

    public String getImgUrl () {
        return imgUrl;
    }

    public void setImgUrl (String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNewsTime () {
        return newsTime;
    }

    public void setNewsTime (String newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsTitle () {
        return newsTitle;
    }

    public void setNewsTitle (String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent () {
        return newsContent;
    }

    public void setNewsContent (String newsContent) {
        this.newsContent = newsContent;
    }
}
