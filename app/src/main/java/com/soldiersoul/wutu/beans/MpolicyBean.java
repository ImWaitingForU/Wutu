package com.soldiersoul.wutu.beans;

import cn.bmob.v3.BmobObject;

/**
 * Created by wxj on 2017/2/28.
 * 军事福利政策bean
 */

public class MpolicyBean extends BmobObject {

    private String title;
    private String content;
    private String source;

    public MpolicyBean () {

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

    public String getSource () {
        return source;
    }

    public void setSource (String source) {
        this.source = source;
    }
}
