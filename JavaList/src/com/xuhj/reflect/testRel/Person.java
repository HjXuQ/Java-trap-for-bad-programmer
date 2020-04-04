package com.xuhj.reflect.testRel;

import java.util.Date;

/**
 * @Description
 * @ClassName Person
 * @Author xuhj
 * @date 2020.03.30 19:43
 */
public class Person {
    private String name;
    int age;
    public Date today;

    public void show(){
        System.out.println("我是 show()");
    }
    public void eat(String name){
        System.out.println("我要吃" + name);
    }
    public Date getToday() {
        return today;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Person() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", today=" + today +
                '}';
    }
}
