package com.xuhj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellThread {
    public static void main(String[] args) {
        //创建线程任务对象
        SellTicketsThread sellTicketsThread = new SellTicketsThread();
        //创建不同的线程
        Thread thread1 = new Thread(sellTicketsThread,"窗口1");
        Thread thread2 = new Thread(sellTicketsThread,"窗口2");
        Thread thread3 = new Thread(sellTicketsThread,"窗口3");
        //这样会输出无数条卖的记录，线程不安全，
        //线程安全问题都是由全局变量及静态变量引起的。若每个线程中对全局变量、静态变量只有读操作，
        // 而无写 操作，一般来说，这个全局变量是线程安全的;若有多个线程同时执行写操作，一般都需要考虑线程同步， 否则的话就可能影响线程安全。
        thread1.start();
        thread2.start();
        thread3.start();
        //可以看到相同的票被卖了两次，还有-1这种不存在的票
        /**
         * 窗口3正在卖20
         * 窗口1正在卖20
         * 窗口2正在卖19
         * 窗口3正在卖18
         * 窗口2正在卖16
         * 窗口1正在卖17
         * 窗口3正在卖15
         * 窗口2正在卖15
         * 窗口1正在卖15
         * 窗口2正在卖14
         * 窗口1正在卖14
         * 窗口3正在卖14
         * 窗口3正在卖13
         * 窗口2正在卖11
         * 窗口1正在卖12
         * 窗口2正在卖10
         * 窗口3正在卖10
         * 窗口1正在卖9
         * 窗口1正在卖8
         * 窗口3正在卖8
         * 窗口2正在卖8
         * 窗口1正在卖7
         * 窗口3正在卖6
         * 窗口2正在卖6
         * 窗口2正在卖5
         * 窗口1正在卖5
         * 窗口3正在卖5
         * 窗口2正在卖4
         * 窗口1正在卖3
         * 窗口3正在卖2
         * 窗口2正在卖1
         * 窗口1正在卖0
         * 窗口3正在卖-1
         * */
        /**
         * 当我们使用多个线程访问同一资源的时候，且多个线程中对资源有写的操作，就容易出现线程安全问题。
         * 要解决上述多线程并发访问一个资源的安全性问题:也就是解决重复票与不存在票问题，Java中提供了同步机制 (synchronized)来解决。
         * 根据案例简述:
         * 窗口1线程进入操作的时候，窗口2和窗口3线程只能在外等着，窗口1操作结束，窗口1和窗口2和窗口3才有机会进入代码 去执行。
         * 也就是说在某个线程修改共享资源的时候，其他线程不能修改该资源，等待修改完毕同步之后，才能去抢夺CPU 资源，
         * 完成对应的操作，保证了数据的同步性，解决了线程不安全的现象。
         * */

        /**
         *  * 为了保证每个线程都能正常执行原子操作,Java引入了线程同步机制。 那么怎么去使用呢?有三种方式完成同步操作:
         *  * 1. 同步代码块。 2. 同步方法。 3. 锁机制。
         *
         * */

        //同步代码块
        /**
         * 同步代码块: synchronized 关键字可以用于方法中的某个区块中，表示只对这个区块的资源实行互斥访问。
         * 格式:
         * 同步锁: 对象的同步锁只是一个概念,可以想象为在对象上标记了一个锁.
         * 1. 锁对象 可以是任意类型。
         * 2. 多个线程对象 要使用同一把锁。
         * 注意:在任何时候,最多允许一个线程拥有同步锁,谁拿到锁就进入代码块,其他的线程只能在外等着 (BLOCKED)。
         * 使用同步代码块解决代码:
         *    synchronized(同步锁){
         *    需要同步操作的代码
         *           }
         *           //详细使用情况见SellTicketsThread类
         * */
        //同步方法
        /**
         *  同步方法 同步方法:使用synchronized修饰的方法,就叫做同步方法,保证A线程执行该方法的时候,其他线程只能在方法外
         * 等着。 格式:
         *  public synchronized void method(){
         *      可能出现线程安全问题的代码块
         *  }
         *  * 锁对象 是 谁调用这个方法 就是谁 * 隐含 锁对象 就是 this
         * 同步锁是谁?
         * 对于非static方法,同步锁就是this。 对于static方法,我们使用当前方法所在类的字节码对象(类名.class)。
         * */

        //锁机制
        /**
         * Lock锁
         * java.util.concurrent.locks.Lock 机制提供了比synchronized代码块和synchronized方法更广泛的锁定操作,
         * 同步代码块/同步方法具有的功能Lock都有,除此之外更强大,更体现面向对象。 Lock锁也称同步锁，加锁与释放锁方法化了，如下:
         * public void lock() :加同步锁。
         * public void unlock() :释放同步锁。
         * */
        /**
         * 小提示:sleep()中指定的时间是线程不会运行的最短时间。因此，sleep()方法不能保证该线程睡眠到期后就
         * 开始立刻执行。
         *
         * */

    }
}
