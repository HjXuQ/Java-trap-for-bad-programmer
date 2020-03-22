package com.xuhj.classfeaturepractise;

public class JavaFinallPra {
    /**
     * Java提供了 final 关键字， 用于修饰不可改变内容。
     * final: 不可改变。可以用于修饰类、方法和变量。
     * 类:被修饰的类，不能被继承。 方法:被修饰的方法，不能被重写。 变量:被修饰的变量，不能被重新赋值。
     * 3. 成员变量 成员变量涉及到初始化的问题，初始化方式有两种，只能二选一:
     * 显示初始化;
     *  public class User {
     * final String USERNAME = "张三"; private int age;
     * }
     * 构造方法初始化。
     *  public class User {
     * final String USERNAME ;
     * private int age;
     * public User(String username, int age) {
     * this.USERNAME = username;
     * this.age = age; }
     * }
     * 被final修饰的常量名称，一般都有书写规范，所有字母都大写。
     * 权限修饰符
     *                          public private protect default
     * 同一类下                     1       1       1       1
     * 同一包                      1       0       1       1
     * 不同包的相关子类             1       0       1       0
     * 不同包的无关子类             1       0       0       0
     *
     *
     * * */

    /**
     *
     *
     什么是内部类 将一个类A定义在另一个类B里面，里面的那个类A就称为内部类，B则称为外部类。 成员内部类
     成员内部类 :定义在类中方法外的类。

     * */
}
