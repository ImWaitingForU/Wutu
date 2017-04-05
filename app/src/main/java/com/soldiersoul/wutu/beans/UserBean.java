package com.soldiersoul.wutu.beans;

import com.soldiersoul.wutu.society.bean.SocietyBean;

import java.util.List;

import cn.bmob.v3.BmobUser;

/**
 * Created by chan on 2017/2/28.
 * <p>
 * 用户Bean类
 */

public class UserBean extends BmobUser {

    /*BombUser已有userName,pwd*/
    private String userAvatar;
    private String school;

    //一个用户对应一个社团
    private SocietyBean society;

    //一个用户收藏多种武器
    private List<WeaponBean> weapons;

    public UserBean () {
    }

    public UserBean ( String userAvatar, String school, SocietyBean society, List<WeaponBean> weapons) {
        this.userAvatar = userAvatar;
        this.school = school;
        this.society = society;
        this.weapons = weapons;
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
