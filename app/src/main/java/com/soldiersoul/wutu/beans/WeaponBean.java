package com.soldiersoul.wutu.beans;

/**
 * Created by chan on 2017/2/28.
 *
 * 武器Bean类
 *
 * 暂时使用图文列表，暂不使用3d模型文件。
 */

public class WeaponBean {

    private String weaponName;
    private String weaponType;
    private String country;
    private String weaponInfo;


    //一个用户收藏多个武器
    private UserBean userBean;

    // TODO: 2017/4/24 尝试使用文字+图片混排样式,所有内容加到weaponInfo内

    //存放两张图片
    private String img1;
    private String img2;

    // TODO: 2017/2/28 武器模型图 
    // TODO: 2017/2/28 模型3d文件


    public WeaponBean (String weaponName, String weaponType, String country, String weaponInfo, UserBean userBean,
                       String img1, String img2) {
        this.weaponName = weaponName;
        this.weaponType = weaponType;
        this.country = country;
        this.weaponInfo = weaponInfo;
        this.userBean = userBean;
        this.img1 = img1;
        this.img2 = img2;
    }

    public String getImg1 () {
        return img1;
    }

    public void setImg1 (String img1) {
        this.img1 = img1;
    }

    public String getImg2 () {
        return img2;
    }

    public void setImg2 (String img2) {
        this.img2 = img2;
    }

    public String getWeaponName () {
        return weaponName;
    }

    public void setWeaponName (String weaponName) {
        this.weaponName = weaponName;
    }

    public String getWeaponType () {
        return weaponType;
    }

    public void setWeaponType (String weaponType) {
        this.weaponType = weaponType;
    }

    public String getCountry () {
        return country;
    }

    public void setCountry (String country) {
        this.country = country;
    }

    public String getWeaponInfo () {
        return weaponInfo;
    }

    public void setWeaponInfo (String weaponInfo) {
        this.weaponInfo = weaponInfo;
    }

    public UserBean getUserBean () {
        return userBean;
    }

    public void setUserBean (UserBean userBean) {
        this.userBean = userBean;
    }
}
