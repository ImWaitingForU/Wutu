package com.soldiersoul.wutu.register;

/**
 * Created by Chan on 2017/1/8 0008.
 * <p>
 * User用户的bean类
 */

public class UserBean {

    /**
     * 用户名(手机号)
     **/
    private String userName;

    /**
     * 昵称
     **/
    private String nickName;

    /**
     * 密码
     **/
    private String pwd;

    /**
     * 头像路径
     **/
    private String avatarPath;

    //TODO:其他属性


    public UserBean (String userName, String nickName, String pwd, String avatarPath) {
        this.userName = userName;
        this.nickName = nickName;
        this.pwd = pwd;
        this.avatarPath = avatarPath;
    }

    @Override
    public String toString () {
        return "User:  UserName:" + userName + ";NickName:" + nickName + ";pwd:" + pwd + ";avatarPath:" + avatarPath;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getNickName () {
        return nickName;
    }

    public void setNickName (String nickName) {
        this.nickName = nickName;
    }

    public String getPwd () {
        return pwd;
    }

    public void setPwd (String pwd) {
        this.pwd = pwd;
    }

    public String getAvatarPath () {
        return avatarPath;
    }

    public void setAvatarPath (String avatarPath) {
        this.avatarPath = avatarPath;
    }
}
