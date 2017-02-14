package com.soldiersoul.wutu.society.bean;

/**
 * Created by Rose on 2017/2/6.
 * <p>
 * 社团照片Bean类
 */

public class SocietyPhotoBean {

    private String photoName;
    private String photoPath;

    public SocietyPhotoBean (String photoName, String photoPath) {
        this.photoName = photoName;
        this.photoPath = photoPath;
    }

    public String getPhotoName () {
        return photoName;
    }

    public void setPhotoName (String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoPath () {
        return photoPath;
    }

    public void setPhotoPath (String photoPath) {
        this.photoPath = photoPath;
    }
}
