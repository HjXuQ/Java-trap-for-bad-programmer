package com.xuhj;

public class JavaThreadRunner implements Runnable {
    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            System.out.println(Thread.currentThread().getName()  + i);
        }
    }
}
