package com.soldiersoul.wutu.society.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Rose on 2017/2/4. 社团照片封面Bean
 */

public class SocietyAlbumBean extends BmobObject{

	/**
	 * 相册名称
	 */
	private String albumName;

	/**
	 * 相册创建时间
	 */
	private String albumTime;

	/**
	 * 包含的照片
	 */
	private SocietyPhotoBean photos;

	/**
	 * 相册封面地址
	 */
	private String albumLogoPath;

	public SocietyAlbumBean (){}

	public SocietyAlbumBean (String albumName, String albumTime, SocietyPhotoBean photos, String albumLogoPath) {
		this.albumName = albumName;
		this.albumTime = albumTime;
		this.photos = photos;
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

	public SocietyPhotoBean getPhotos () {
		return photos;
	}

	public void setPhotos (SocietyPhotoBean photos) {
		this.photos = photos;
	}

	public String getAlbumLogoPath () {
		return albumLogoPath;
	}

	public void setAlbumLogoPath (String albumLogoPath) {
		this.albumLogoPath = albumLogoPath;
	}
}
