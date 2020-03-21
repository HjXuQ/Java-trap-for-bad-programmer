package com.xuhj.classfeaturepractise;

import javax.print.DocFlavor;

public class User {
    private String name;
    private Double leftMoney;

    public User(String name, Double leftMoney) {
        this.name = name;
        this.leftMoney = leftMoney;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLeftMoney() {
        return leftMoney;
    }

    public void setLeftMoney(Double leftMoney) {
        this.leftMoney = leftMoney;
    }

    // 展示信息的方法
    public void show() {
        System.out.println("用户名:" + name + " , 余额为:" + leftMoney + "元");
    }
}
