package com.xuhj.javaApi;

public class ThreadPoolImplRunn implements Runnable {
    @Override
    public void run() {
        System.out.println("我要一个教练");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("教练正在走来" + Thread.currentThread().getName());
        System.out.println("教练教会了我游泳并且离开了");
    }
}
