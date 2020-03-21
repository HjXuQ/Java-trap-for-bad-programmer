package com.xuhj.classfeaturepractise;

import java.io.UnsupportedEncodingException;

public class Employee {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name ;
    int num = 5;
    private String sex;
    public void printName(){
        System.out.println("我是父类" + name);
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "徐华杰";
        //编码
        byte[] namexuhj = name.getBytes("utf-8");
        //解码
        String reName = new String(namexuhj,"ISO-8859-1");
        System.out.println(new String(reName.getBytes("ISO-8859-1"),"utf-8"));
    }
}
