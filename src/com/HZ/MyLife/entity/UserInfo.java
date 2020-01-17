package com.HZ.MyLife.entity;

import java.util.Date;

/**
 * 用户详细信息类
 * Created by xsjdn on 2019/12/20.
 */
public class UserInfo {
    private String userid;
    private String address;
    private String sex;
    private Date birthday;

    public UserInfo() {
    }

    public UserInfo(String userid, String address, String sex, Date birthday) {
        this.userid = userid;
        this.address = address;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
