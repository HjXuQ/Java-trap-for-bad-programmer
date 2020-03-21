package com.xuhj.javaApi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    /**
     * 等待唤醒机制
     * 线程间通信 概念:多个线程在处理同一个资源，但是处理的动作(线程的任务)却不相同。
     *为什么要处理线程间通信:
     * 多个线程并发执行时, 在默认情况下CPU是随机切换线程的，当我们需要多个线程来共同完成一件任务，并且我们
     * 希望他们有规律的执行, 那么多线程之间需要一些协调通信，以此来帮我们达到多线程共同操作一份数据。
     * 如何保证线程间通信有效利用资源:
     * 多个线程在处理同一个资源，并且任务不同时，需要线程通信来帮助解决线程之间对同一个变量的使用或操作。 就 是多个线程在操作同一份数据时， 避免对同一共享变量的争夺。也就是我们需要通过一定的手段使各个线程能有效 的利用资源。而这种手段即—— 等待唤醒机制。
     * 什么是等待唤醒机制
     * 这是多个线程间的一种协作机制。谈到线程我们经常想到的是线程间的竞争(race)，比如去争夺锁，但这并不是 故事的全部，线程间也会有协作机制。就好比在公司里你和你的同事们，你们可能存在在晋升时的竞争，但更多时 候你们更多是一起合作以完成某些任务。
     * 就是在一个线程进行了规定操作后，就进入等待状态(wait())， 等待其他线程执行完他们的指定代码过后 再将 其唤醒(notify());在有多个线程进行等待时， 如果需要，可以使用 notifyAll()来唤醒所有的等待线程。
     * wait/notify 就是线程间的一种协作机制。
     * 等待唤醒中的方法 等待唤醒机制就是用于解决线程间通信的问题的，使用到的3个方法的含义如下:
     * 1. wait:线程不再活动，不再参与调度，进入 wait set 中，因此不会浪费 CPU 资源，也不会去竞争锁了，这时 的线程状态即是 WAITING。它还要等着别的线程执行一个特别的动作，也即是“通知(notify)”在这个对象 上等待的线程从wait set 中释放出来，重新进入到调度队列(ready queue)中
     * 2. notify:则选取所通知对象的 wait set 中的一个线程释放;例如，餐馆有空位置后，等候就餐最久的顾客最先 入座。
     * 3. notifyAll:则释放所通知对象的 wait set 上的全部线程。
     * 注意:
     * 哪怕只通知了一个等待的线程，被通知线程也不能立即恢复执行，因为它当初中断的地方是在同步块内，而 此刻它已经不持有锁，所以她需要再次尝试去获取锁(很可能面临其它线程的竞争)，成功后才能在当初调 用 wait 方法之后的地方恢复执行。
     * 总结如下:
     * 如果能获取锁，线程就从 WAITING 状态变成 RUNNABLE 状态;
     * 否则，从 wait set 出来，又进入 entry set，线程就从 WAITING 状态又变成 BLOCKED 状态
     * 调用wait和notify方法需要注意的细节
     * 1. wait方法与notify方法必须要由同一个锁对象调用。因为:对应的锁对象可以通过notify唤醒使用同一个锁对 象调用的wait方法后的线程。
     * 2. wait方法与notify方法是属于Object类的方法的。因为:锁对象可以是任意对象，而任意对象的所属类都是继 承了Object类的。
     * 3. wait方法与notify方法必须要在同步代码块或者是同步函数中使用。因为:必须要通过锁对象调用这2个方 法。
     *
     * */

    /**
     *
     2.3 线程池的使用
     Java里面线程池的顶级接口是 java.util.concurrent.Executor ，但是严格意义上讲 Executor 并不是一个线程 池，而只是一个执行线程的工具。真正的线程池接口是 java.util.concurrent.ExecutorService 。
     要配置一个线程池是比较复杂的，尤其是对于线程池的原理不是很清楚的情况下，很有可能配置的线程池不是较优 的，因此在 java.util.concurrent.Executors 线程工厂类里面提供了一些静态工厂，生成一些常用的线程池。官 方建议使用Executors工程类来创建线程池对象。
     Executors类中有个创建线程池的方法如下:
     public static ExecutorService newFixedThreadPool(int nThreads) :返回线程池对象。(创建的是有界线
     程池,也就是池中的线程个数可以指定最大数量)
     获取到了一个线程池ExecutorService 对象，那么怎么使用呢，在这里定义了一个使用线程池对象的方法如下:
     public Future<?> submit(Runnable task) :获取线程池中的某一个线程对象，并执行 Future接口:用来记录线程任务执行完毕后产生的结果。线程池创建与使用。
     使用线程池中线程对象的步骤:
     1. 创建线程池对象。
     2. 创建Runnable接口子类对象。(task)

     3. 提交Runnable接口子类对象。(take task) 4. 关闭线程池(一般不做)。
     * */
    public static void main(String[] args) {
        //     1. 创建线程池对象。
        ExecutorService service = Executors.newFixedThreadPool(2);//包含两个线程对象
        //创建线程任务对象
        ThreadPoolImplRunn r = new ThreadPoolImplRunn();
        //从线程池中拿出一个线程执行r中的run方法
        service.submit(r);
        //再获取两个对象
        service.submit(r);
        service.submit(r);
        //submit调用方法结束之后，程序并不终止，是因为线程池中控制了线程的关闭，将使用完的线程重新归还到线程池中
        //关闭线程池  一般不推荐
        service.shutdown();

    }
}
