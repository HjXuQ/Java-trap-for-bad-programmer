package com.xuhj.classfeaturepractise.Duotai;

public class Dog extends Animals {

    @Override
    public void show() {
        System.out.println("我是dog");
    }

    @Override
    public void sayHello() {
    System.out.println("Hello   - -- - - - -");
    }

    public void sayHello1(Animals a){
        a.show();
        a.sayHello();
    }
    /**public void sayHello2(Animals b){
        b.show();
    }
     */
}
