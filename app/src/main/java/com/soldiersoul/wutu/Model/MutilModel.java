package com.soldiersoul.wutu.Model;

import com.shuyu.common.model.RecyclerBaseModel;

/**
 * Created by shuyu on 2016/11/24.
 */

public class MutilModel extends RecyclerBaseModel {
    private String imageUrl;
    private String title;
    private String content;
    private String time;

    public String getImageUrl () {
        return imageUrl;
    }

    public void setImageUrl (String imageUrl) {
        this.imageUrl = imageUrl;
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
}
