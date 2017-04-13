package com.soldiersoul.wutu.society.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Rose on 2017/2/4. 社团照片封面Bean
 */

public class SocietyAlbumBean extends BmobObject{

	//一个社团有多个相册
	private SocietyBean societyBean;

	/**
	 * 相册名称
	 */
	private String albumName;

	/**
	 * 相册创建时间
	 */
	private String albumTime;

//	/**
//	 * 包含的照片
//	 */
//	private SocietyPhotoBean photos;

	/**
	 * 相册封面地址
	 */
	private String albumLogoPath;

	public SocietyAlbumBean (){}

	public SocietyAlbumBean (SocietyBean societyBean, String albumName, String albumTime, String albumLogoPath) {
		this.societyBean = societyBean;
		this.albumName = albumName;
		this.albumTime = albumTime;
		this.albumLogoPath = albumLogoPath;
	}

	public SocietyBean getSocietyBean () {
		return societyBean;
	}

	public void setSocietyBean (SocietyBean societyBean) {
		this.societyBean = societyBean;
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