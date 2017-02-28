package com.soldiersoul.wutu.beans;

/**
 * Created by wxj on 2017/2/28.
 * 军事政策bean
 */

public class MpolicyBean {

    private String policy_title;
    private String policy_content;
    private String policy_time;
    private String policy_source;


    public MpolicyBean(){

    }

    //构造
    public MpolicyBean(String policy_title, String policy_content, String policy_time, String policy_source) {
        this.policy_title = policy_title;
        this.policy_content = policy_content;
        this.policy_time = policy_time;
        this.policy_source = policy_source;
    }

    public String getPolicy_title() {
        return policy_title;
    }

    public void setPolicy_title(String policy_title) {
        this.policy_title = policy_title;
    }

    public String getPolicy_content() {
        return policy_content;
    }

    public void setPolicy_content(String policy_content) {
        this.policy_content = policy_content;
    }

    public String getPolicy_time() {
        return policy_time;
    }

    public void setPolicy_time(String policy_time) {
        this.policy_time = policy_time;
    }

    public String getPolicy_source() {
        return policy_source;
    }

    public void setPolicy_source(String policy_source) {
        this.policy_source = policy_source;
    }
}
