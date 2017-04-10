package com.soldiersoul.wutu.society.bean;

import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Created by Chan on 2017/1/8 0008.
 * <p>
 * 社团Bean类
 */

public class SocietyBean extends BmobObject{

	/**
	 * 社团名
	 **/
	private String name;
	/**
	 * 人员列表
	 **/
	private List<String> memberList;

	/**
	 * 社团介绍
	 */
	private String introduce;

	/**
	 * 社团头像
	 */
	private String avatar;

	/**
	 * 社长名
	 */
	private String captailName;

    /**
     * 社团地址
     */
    private String location;

	// /**
	// * 部门
	// */
	// private ArrayList<> departments;

	/**
	 * 社团相册
	 */
	private List<SocietyPhotoAlbumBean> albumBean;

	/**
	 * 社团QQ
	 */
	private String societyQQ;

	/**
	 * 社团手机号
	 */
	private String societyPhone;

	/**
	 * 社团Email
	 */
	private String societyEmail;

    public SocietyBean (String name, List<String> memberList, String introduce, String avatar, String captailName,
                        String location, List<SocietyPhotoAlbumBean> albumBean, String societyQQ, String societyPhone,
                        String societyEmail) {
        this.name = name;
        this.memberList = memberList;
        this.introduce = introduce;
        this.avatar = avatar;
        this.captailName = captailName;
        this.location = location;
        this.albumBean = albumBean;
        this.societyQQ = societyQQ;
        this.societyPhone = societyPhone;
        this.societyEmail = societyEmail;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<String> memberList) {
		this.memberList = memberList;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<SocietyPhotoAlbumBean> getAlbumBean() {
		return albumBean;
	}

	public void setAlbumBean(List<SocietyPhotoAlbumBean> albumBean) {
		this.albumBean = albumBean;
	}

	public String getSocietyQQ() {
		return societyQQ;
	}

	public void setSocietyQQ(String societyQQ) {
		this.societyQQ = societyQQ;
	}

	public String getSocietyPhone() {
		return societyPhone;
	}

	public void setSocietyPhone(String societyPhone) {
		this.societyPhone = societyPhone;
	}

	public String getSocietyEmail() {
		return societyEmail;
	}

	public void setSocietyEmail(String societyEmail) {
		this.societyEmail = societyEmail;
	}

	public String getCaptailName() {
		return captailName;
	}

	public void setCaptailName(String captailName) {
		this.captailName = captailName;
	}
}
