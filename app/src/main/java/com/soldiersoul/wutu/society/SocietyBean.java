package com.soldiersoul.wutu.society;

import com.soldiersoul.wutu.register.UserBean;

import java.util.ArrayList;

/**
 * Created by Chan on 2017/1/8 0008.
 * <p>
 * 社团Bean类
 */

public class SocietyBean {

    /**
     * 社团名
     **/
    private String name;
    /**
     * 总人数
     **/
    private String totalNumber;

    /**
     * 社团介绍
     */
    private String introduce;

    /**
     * 部门
     */
//    private ArrayList<> departments;

    /**
     * 社团用户
     **/
    private ArrayList<UserBean> members;

    public SocietyBean (String name, String totalNumber, String introduce, ArrayList<UserBean> members) {
        this.name = name;
        this.totalNumber = totalNumber;
        this.introduce = introduce;
        this.members = members;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getTotalNumber () {
        return totalNumber;
    }

    public void setTotalNumber (String totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getIntroduce () {
        return introduce;
    }

    public void setIntroduce (String introduce) {
        this.introduce = introduce;
    }

    public ArrayList<UserBean> getMembers () {
        return members;
    }

    public void setMembers (ArrayList<UserBean> members) {
        this.members = members;
    }
}


