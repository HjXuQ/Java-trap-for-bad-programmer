package com.xuhj;

public class chiHuoThread extends Thread {
    private Baozi baozi;

    @Override
    public void run() {
        //只要有包子就进行消费
        while (true){
            //synchronized 锁住的是对象，就是包子
            synchronized (baozi){
                if(baozi.flag == false){//没有包子
                    //当包子没有的时候，吃货线程进行等待，但是这里为什么要用到baozi对象的呢wait()方法呢，不是应该是当前对象吗
                    /**
                     * InterruptedException
                     也就是当前的线程不是此对象监视器的所有者。当前线程要锁定该对象之后，
                     才能用锁定的对象执行这些方法，这里需要用到synchronized关键字，
                     锁定哪个对象就用哪个对象来执行notify(), notifyAll(),wait(), wait(long), wait(long, int)操作，
                     否则就会报IllegalMonitorStateException异常。
                     */

                    //      wait() 任何对象，任何类型 导致当前线程等待，直到其他线程调用此对象的 notify()方法或 notifyAll()方法前，导致当前线程等待。
                    //只要一个类继承了Thread或者实现了Runnerable接口，这个类不能看作一个类，这是一个线程，这是一条路，我用被锁掉的对象调用wait()或者notify()之后，锁掉的是这个线程，是当前线程

                    //他是怎么进行控制的，就是当前线程锁掉的对象调用wait方法，说明当前线程锁掉了，直到遇到另一个线程调用了相同对象的notify方法才会把我这个进程启动起来
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃货正在吃" + baozi.pier + baozi.xianer + "的包子");
                baozi.flag = false;
                baozi.notify();
            }
        }
    }

    public chiHuoThread(String name, Baozi baozi) {
        super(name);
        this.baozi = baozi;
    }
}
