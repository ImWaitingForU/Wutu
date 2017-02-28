package com.soldiersoul.wutu.beans;

import com.soldiersoul.wutu.society.SocietyBean;

import java.util.List;

/**
 * Created by chan on 2017/2/28.
 *
 * 用户Bean类
 */

public class UserBean{

    private String phone;
    private String pwd;
    private String userName;
    private String userAvatar;
    private String school;

    //一个用户对应一个社团
    private SocietyBean society;

    //一个用户收藏多种武器
    private List<WeaponBean> weapons;

    public UserBean (String phone, String pwd, String userName, String userAvatar, String school, SocietyBean society,
                     List<WeaponBean> weapons) {
        this.phone = phone;
        this.pwd = pwd;
        this.userName = userName;
        this.userAvatar = userAvatar;
        this.school = school;
        this.society = society;
        this.weapons = weapons;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public String getPwd () {
        return pwd;
    }

    public void setPwd (String pwd) {
        this.pwd = pwd;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getUserAvatar () {
        return userAvatar;
    }

    public void setUserAvatar (String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getSchool () {
        return school;
    }

    public void setSchool (String school) {
        this.school = school;
    }

    public SocietyBean getSociety () {
        return society;
    }

    public void setSociety (SocietyBean society) {
        this.society = society;
    }

    public List<WeaponBean> getWeapons () {
        return weapons;
    }

    public void setWeapons (List<WeaponBean> weapons) {
        this.weapons = weapons;
    }
}
