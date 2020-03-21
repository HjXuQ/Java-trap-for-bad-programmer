package com.xuhj.javaApi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTicketsThread implements Runnable {
    //线程执行对象，模拟卖票程序
    //100张票
    private int tickets = 20;
    //同步锁可以是任意的对象，任意类型的对象
    String x = new String("11");
    Object lock1 = new Object();
    //锁机制
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        //开口永远开启
        while(true){
//            synchronized () 同步方法
//            sellTickets();

//            lock.lock();   对以下代码块进行加锁
            synchronized (x){
                if(tickets > 0){
                    //出票
                    try {
                        Thread.sleep(100);
                        //获取当前的线程名称
                        String currentThreadName = Thread.currentThread().getName();
                        System.out.println(currentThreadName + "正在卖" + tickets--);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
//                lock.unlock();  去除锁，然后其他线程可以获得锁对象
            }


        }
    }
    public synchronized void sellTickets(){
        if(tickets > 0){
            //出票
            try {
                Thread.sleep(100);
                //获取当前的线程名称
                String currentThreadName = Thread.currentThread().getName();
                System.out.println(currentThreadName + "正在卖" + tickets--);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
