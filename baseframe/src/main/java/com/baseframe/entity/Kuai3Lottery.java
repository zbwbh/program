package com.baseframe.entity;

import java.util.Date;

public class Kuai3Lottery {

    private Integer id;

    private String issue;

    private String number1;

    private String number2;

    private String number3;

    private String lotteryTime;

    private String gmtCreate;

    private String gmtModified;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getNumber3() {
        return number3;
    }

    public void setNumber3(String number3) {
        this.number3 = number3;
    }

    public String getLotteryTime() {
        return lotteryTime;
    }

    public void setLotteryTime(String lotteryTime) {
        this.lotteryTime = lotteryTime;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Kuai3Lottery [id=" + id
                + ", issue="
                + issue
                + ", number1="
                + number1
                + ", number2="
                + number2
                + ", number3="
                + number3
                + ", lotteryTime="
                + lotteryTime
                + ", gmtCreate="
                + gmtCreate
                + ", gmtModified="
                + gmtModified
                + ", remark="
                + remark
                + "]";
    }

}
