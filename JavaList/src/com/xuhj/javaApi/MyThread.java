package com.xuhj.javaApi;

public class MyThread extends Thread {
    //指定线程的名字
    public MyThread(String name) {
        super(name);
    }
    //必须要重写run方法
    @Override
    public void run(){
        for(int i = 0;i<10;i++){
            //getName()方法来自父类
            System.out.println(getName() + "正在运行" + i);
        }
    }
}
