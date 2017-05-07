package com.soldiersoul.wutu.society.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by wxj on 2017/4/10.
 *
 * 社团任务界面
 */

public class SocietyIntegral extends BmobObject{

    private String integralName;
    private String integralContent;
    private String deadline;
    private String integralReward;
    //社团任务1对多
    private SocietyBean societyBean;

    public SocietyIntegral () {

    }

    public SocietyIntegral (String integralName, String integralContent, String deadline, String integralReward,
                            SocietyBean societyBean) {
        this.integralName = integralName;
        this.integralContent = integralContent;
        this.deadline = deadline;
        this.integralReward = integralReward;
        this.societyBean = societyBean;
    }

    public SocietyBean getSocietyBean () {
        return societyBean;
    }

    public void setSocietyBean (SocietyBean societyBean) {
        this.societyBean = societyBean;
    }

    public String getIntegralName() {
        return integralName;
    }

    public void setIntegralName(String integralName) {
        this.integralName = integralName;
    }

    public String getIntegralContent() {
        return integralContent;
    }

    public void setIntegralContent(String integralContent) {
        this.integralContent = integralContent;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getIntegralReward() {
        return integralReward;
    }

    public void setIntegralReward(String integralReward) {
        this.integralReward = integralReward;
    }
}
