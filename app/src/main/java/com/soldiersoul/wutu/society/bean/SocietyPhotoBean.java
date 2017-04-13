package com.soldiersoul.wutu.society.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Rose on 2017/2/6.
 * <p>
 * 社团照片Bean类
 */

public class SocietyPhotoBean extends BmobObject {

    private String photoName;
    private String photoPath;

    //一个相册包含多张照片
    private SocietyAlbumBean album;

    public SocietyPhotoBean () {
    }

    public SocietyPhotoBean (String photoName, String photoPath, SocietyAlbumBean album) {
        this.photoName = photoName;
        this.photoPath = photoPath;
        this.album = album;
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

    public SocietyAlbumBean getAlbum () {
        return album;
    }

    public void setAlbum (SocietyAlbumBean album) {
        this.album = album;
    }
}
