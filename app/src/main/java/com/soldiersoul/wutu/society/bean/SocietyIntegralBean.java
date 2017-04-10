package com.soldiersoul.wutu.society.bean;

/**
 * Created by wxj on 2017/4/10.
 */

public class SocietyIntegralBean {

    private String integralName;
    private String integralContent;
    private String deadline;
    private String integralReward;

    public SocietyIntegralBean() {

    }

    public SocietyIntegralBean(String integralName, String integralContent, String deadline, String integralReward) {
        this.integralName = integralName;
        this.integralContent = integralContent;
        this.deadline = deadline;
        this.integralReward = integralReward;
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
