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
     访问特点
     内部类可以直接访问外部类的成员，包括私有成员。 外部类要访问内部类的成员，必须要建立内部类的对象。
     内部类对象不能访问外部类的成员方法，外部类的对象不能访问内部类的成员方法
     内部类和外部类只能通过本身的实例对象去调用各自的方法。
     内部类仍然是一个独立的类，在编译之后会内部类会被编译成独立的.class文件，但是前面冠以外部类的类名 和$符号 。
     比如，Person$Heart.class
     * */

    /**
     * 匿名内部类 :是内部类的简化写法。它的本质是一个 带具体实现的 父类或者父接口的 匿名的 子类对象。 开发中，最常用到的内部类就是匿名内部类了
     * 前提：匿名内部类必须继承一个父类或者实现一个父接口。
     * 如果这个父接口中有多个接口方法，那么必须全部实现
     * 接口作为参数时，传递它的子类对象。 接口作为返回值类型时，返回它的子类对象。
     *
     * */
    private String name = "xuhj";
    public void sayHello2(){
        System.out.println("say Hello");
    }
    class Person1{
        private void swimming(){
            if(name.equals("xuhj")){
                System.out.println("我正在游泳");
            }else{
                System.out.println("我没在游泳");
            }

        }

    }

    public static void main(String[] args) {
        //外部类对象
        JavaFinallPra javaFinallPra  = new JavaFinallPra();
        // 创建内部类对象
        Person1 person1 = new JavaFinallPra().new Person1();
        Person1 person2 = javaFinallPra.new Person1();
        //调用内部类方法
        person1.swimming();
        //调用外部类方法
        javaFinallPra.sayHello2();
    }
}
