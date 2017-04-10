package com.soldiersoul.wutu.beans;

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
    private String society;

    //一个用户收藏多种武器
    private String weapons;

    public UserBean () {
    }

    public UserBean ( String userAvatar, String school, String society, String weapons) {
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

    public String getSociety () {
        return society;
    }

    public void setSociety (String society) {
        this.society = society;
    }

    public String getWeapons () {
        return weapons;
    }

    public void setWeapons (String weapons) {
        this.weapons = weapons;
    }
}
