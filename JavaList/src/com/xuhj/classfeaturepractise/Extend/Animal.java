package com.xuhj.classfeaturepractise.Extend;

public abstract class Animal {
    public abstract void run();
    public static String name = "xuhj";

    public void show() {
        System.out.println("animals show");
    }
    public static void name(){
        System.out.println("xuhj");
    }
    public abstract void sayHello();
}
