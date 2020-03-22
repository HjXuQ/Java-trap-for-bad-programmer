package com.xuhj.classfeaturepractise.ExtendTeacher;

import java.util.HashMap;
import java.util.Map;

public class Teacher extends Employee {
    int numZi = 6;
    int num = 9;
    public void printName(){
        System.out.println("我是子类" + name);
    }
    public void work(){
        System.out.println("尽心尽力的工作");
    }
    public void show(){
        System.out.println("父类" + super.num);
        System.out.println("子类" + this.num);
        ziLei();
    }

    public static void main(String[] args) {

        Integer x1 = 10000;
        Integer x2 = 10000;
        if(x1 == x2){
            System.out.println("true");
        }
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("1",2);
        map.put("2","3");
        String name = (String)map.get("2");
        System.out.println(name);
        Teacher teacher = new Teacher();
        teacher.name = "花少";
        teacher.setSex("男");
        System.out.println(teacher.getSex());
        teacher.work();
        teacher.printName();
        teacher.show();
        //测试String不能用==，而是用equals
        teacher.setName("1");
        Integer int1 = 1;
        Integer int2 = new Integer("2");
        System.out.println(int2.toString());
        System.out.println(int1.toString());
        System.out.println(teacher.getName());
        System.out.println("-------------------------------");
        String String1 = "1";
        if(teacher.getName() == "1"){
            System.out.println("我是1");
        }else{
            System.out.println("我不是1");
        }
        System.out.println(teacher.getName() == String1 ? "yes" : "no");

    }
}
