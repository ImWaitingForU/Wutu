package com.soldiersoul.wutu.society.bean;

import com.soldiersoul.wutu.beans.UserBean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Chan on 2017/1/8 0008.
 * <p>
 * 社团Bean类
 */

public class SocietyBean extends BmobObject {
    /**
     * 人员列表  1对多
     **/
    private UserBean memberList;

    /**
     * 社团相册 1对多
     */
    private SocietyPhotoAlbumBean albumList;

    /**
     * 社团名
     **/
    private String name;

    /**
     * 社团介绍
     */
    private String introduce;

    /**
     * 社团所属学校
     */
    private String school;

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

    public SocietyBean () {
    }

    public SocietyBean (UserBean memberList, SocietyPhotoAlbumBean albumList, String name,
                        String introduce, String school, String avatar, String captailName, String location,
                        String societyQQ, String societyPhone, String societyEmail) {
        this.memberList = memberList;
        this.albumList = albumList;
        this.name = name;
        this.introduce = introduce;
        this.school = school;
        this.avatar = avatar;
        this.captailName = captailName;
        this.location = location;
        this.societyQQ = societyQQ;
        this.societyPhone = societyPhone;
        this.societyEmail = societyEmail;
    }

    public UserBean getMemberList () {
        return memberList;
    }

    public void setMemberList (UserBean memberList) {
        this.memberList = memberList;
    }

    public SocietyPhotoAlbumBean getAlbumList () {
        return albumList;
    }

    public void setAlbumList (SocietyPhotoAlbumBean albumList) {
        this.albumList = albumList;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getIntroduce () {
        return introduce;
    }

    public void setIntroduce (String introduce) {
        this.introduce = introduce;
    }

    public String getSchool () {
        return school;
    }

    public void setSchool (String school) {
        this.school = school;
    }

    public String getAvatar () {
        return avatar;
    }

    public void setAvatar (String avatar) {
        this.avatar = avatar;
    }

    public String getCaptailName () {
        return captailName;
    }

    public void setCaptailName (String captailName) {
        this.captailName = captailName;
    }

    public String getLocation () {
        return location;
    }

    public void setLocation (String location) {
        this.location = location;
    }

    public String getSocietyQQ () {
        return societyQQ;
    }

    public void setSocietyQQ (String societyQQ) {
        this.societyQQ = societyQQ;
    }

    public String getSocietyPhone () {
        return societyPhone;
    }

    public void setSocietyPhone (String societyPhone) {
        this.societyPhone = societyPhone;
    }

    public String getSocietyEmail () {
        return societyEmail;
    }

    public void setSocietyEmail (String societyEmail) {
        this.societyEmail = societyEmail;
    }
}
