package com.soldiersoul.wutu.society.bean;

/**
 * Created by Rose on 2017/2/4.
 * 社团照片封面Bean
 */

public class SocietyPhotoAlbumBean {

    /**
     * 相册名称
     */
    private String albumName;

    /**
     * 相册创建时间
     */
    private String albumTime;

    /**
     * 相册封面地址
     */
    private String albumLogoPath;

    public SocietyPhotoAlbumBean (String albumName, String albumTime, String albumLogoPath) {
        this.albumName = albumName;
        this.albumTime = albumTime;
        this.albumLogoPath = albumLogoPath;
    }

    public String getAlbumName () {
        return albumName;
    }

    public void setAlbumName (String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumTime () {
        return albumTime;
    }

    public void setAlbumTime (String albumTime) {
        this.albumTime = albumTime;
    }

    public String getAlbumLogoPath () {
        return albumLogoPath;
    }

    public void setAlbumLogoPath (String albumLogoPath) {
        this.albumLogoPath = albumLogoPath;
    }
}
