package com.xuhj;

public class JavaThreadPractise {
    /**
     * 并发和并行的概念
     * 并发:指两个或多个事件在同一个时间段内发生。
     * 并行:指两个或多个事件在同一时刻发生(同时发生)。
     * 在操作系统中，安装了多个程序，并发指的是在一段时间内宏观上有多个程序同时运行，这在单 CPU 系统中，每 一时刻只能有一道程序执行，即微观上这些程序是分时的交替运行，只不过是给人的感觉是同时运行，那是因为分 时交替运行的时间是非常短的。
     * 而在多个 CPU 系统中，则这些可以并发执行的程序便可以分配到多个处理器上(CPU)，实现多任务并行执行， 即利用每个处理器来处理一个可以并发执行的程序，这样多个程序便可以同时执行。目前电脑市场上说的多核 CPU，便是多核处理器，核 越多，并行处理的程序越多，能大大的提高电脑运行的效率。
     * 注意:单核处理器的计算机肯定是不能并行的处理多个任务的，只能是多个任务在单个CPU上并发运行。同 理,线程也是一样的，从宏观角度上理解线程是并行运行的，但是从微观角度上分析却是串行运行的，即一个 线程一个线程的去运行，当系统只有一个CPU时，线程会以某种顺序执行多个线程，我们把这种情况称之为 线程调度。
     * 线程与进程的概念
     * 进程:是指一个内存中运行的应用程序，每个进程都有一个独立的内存空间，一个应用程序可以同时运行多 个进程;进程也是程序的一次执行过程，是系统运行程序的基本单位;系统运行一个程序即是一个进程从创 建、运行到消亡的过程。
     * 线程:线程是进程中的一个执行单元，负责当前进程中程序的执行，一个进程中至少有一个线程。一个进程 中是可以有多个线程的，这个应用程序也可以称之为多线程程序。
     * 简而言之:一个程序运行后至少有一个进程，一个进程中可以包含多个线程
     * 线程调度:
     * 分时调度
     * 所有线程轮流使用 CPU 的使用权，平均分配每个线程占用 CPU 的时间。
     * 抢占式调度
     * 优先让优先级高的线程使用 CPU，如果线程的优先级相同，那么会随机选择一个(线程随机性)，Java使用的为 抢占式调度。
     * 可以设置线程的优先级
     * */

    /**
     Java使用 java.lang.Thread 类代表线程，所有的线程对象都必须是Thread类或其子类的实例。每个线程的作用是 完成一定的任务，实际上就是执行一段程序流即一段顺序执行的代码。Java使用线程执行体来代表这段程序流。 Java中通过继承Thread类来创建并启动多线程的步骤如下:
     1. 定义Thread类的子类，并重写该类的run()方法，该run()方法的方法体就代表了线程需要完成的任务,因此把 run()方法称为线程执行体。
     2. 创建Thread子类的实例，即创建了线程对象 3. 调用线程对象的start()方法来启动该线程
     */

    /**
     *          创建新的线程，除了继承Thread类
     * 在上一天内容中我们已经可以完成最基本的线程开启，那么在我们完成操作过程中用到了 java.lang.Thread 类， API中该类中定义了有关线程的一些方法，具体如下:
     * 构造方法:
     *  public Thread() :分配一个新的线程对象。
     * public Thread(String name) :分配一个指定名字的新的线程对象。
     * public Thread(Runnable target) :分配一个带有指定目标新的线程对象。
     * public Thread(Runnable target,String name) :分配一个带有指定目标新的线程对象并指定名字。
     * 常用方法:
     * public String getName() :获取当前线程名称。
     * public void start() :导致此线程开始执行; Java虚拟机调用此线程的run方法。
     * public void run() :此线程要执行的任务在此处定义代码。
     * public static void sleep(long millis) :使当前正在执行的线程以指定的毫秒数暂停(暂时停止执行)。 public static Thread currentThread() :返回对当前正在执行的线程对象的引用。
     *         还有就是实现java.lang.Runnable接口 也是非常常见的一种，我们只需要重写run方法即可。
     * 步骤如下:
     * 1. 定义Runnable接口的实现类，并重写该接口的run()方法，该run()方法的方法体同样是该线程的线程执行体。 2. 创建Runnable实现类的实例，并以此实例作为Thread的target来创建Thread对象，该Thread对象才是真正
     * 的线程对象。
     * 3. 调用线程对象的start()方法来启动线程。
     * 通过实现Runnable接口，使得该类有了多线程类的特征。run()方法是多线程程序的一个执行目标。所有的多线程 代码都在run方法里面。Thread类实际上也是实现了Runnable接口的类。
     * 在启动的多线程的时候，需要先通过Thread类的构造方法Thread(Runnable target) 构造出对象，然后调用Thread 对象的start()方法来运行多线程代码。
     * 实际上所有的多线程代码都是通过运行Thread的start()方法来运行的。因此，不管是继承Thread类还是实现 Runnable接口来实现多线程，最终还是通过Thread的对象的API来控制线程的，熟悉Thread类的API是进行多线程 编程的基础。为什么呢，因为Runnable中只有一个run方法，没有start（）方法
     * tips:Runnable对象仅仅作为Thread对象的target，Runnable实现类里包含的run()方法仅作为线程执行体。 而实际的线程对象依然是Thread实例，只是该Thread线程负责执行其target的run()方法。
     * Thread和Runnable的区别
     * 如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。 总结:
     * 实现Runnable接口比继承Thread类所具有的优势:
     * 1. 适合多个相同的程序代码的线程去共享同一个资源。
     * 2. 可以避免java中的单继承的局限性。
     * 3. 增加程序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立。 4. 线程池只能放入实现Runable或Callable类线程，不能直接放入继承Thread的类。
     * 扩充:在java中，每次程序运行至少启动2个线程。一个是main线程，一个是垃圾收集线程。因为每当使用 java命令执行一个类的时候，实际上都会启动一个JVM，每一个JVM其实在就是在操作系统中启动了一个进 程。
     *
     * 1.5 匿名内部类方式实现线程的创建
     * 使用线程的内匿名内部类方式，可以方便的实现每个线程执行不同的线程任务操作。 使用匿名内部类的方式实现Runnable接口，重新Runnable接口中的run方法:
     */

    public static void main(String[] args) {
        //通过继承Thread方法创建新的线程
        MyThread myThread = new MyThread("新的线程");
        myThread.start();
        for(int i =0;i<10;i++){
            System.out.println("main线程" + i);
        }
        /**
         * 新的线程正在运行0
         * 新的线程正在运行1
         * 新的线程正在运行2
         * 新的线程正在运行3
         * main线程0
         * main线程1
         * 新的线程正在运行4
         * main线程2
         * 新的线程正在运行5
         * main线程3
         * 新的线程正在运行6
         * main线程4
         * 新的线程正在运行7
         * main线程5
         * 新的线程正在运行8
         * main线程6
         * 新的线程正在运行9
         * main线程7
         * main线程8
         * main线程9
         *          每次运行的结果都是不一样的，抢占式调度
         * Process finished with exit code 0
         *
         * */
        //这个分隔符没办法区分两种实现方式，因为线程执行是随机的，没法看
        System.out.println("-----------------------------------------------------");

        //通过实现Runnerable接口创建新的线程
        //，自定义线程任务，创建线程任务对象
        JavaThreadRunner javaThreadRunner = new JavaThreadRunner();
        //创建线程对象
        Thread newThread = new Thread(javaThreadRunner,"我是一个新的线程");
        newThread.start();
        for(int i =0;i<10;i++){
            System.out.println("我是main"  + i);
        }
        //内部类的实现方式
        new Thread( new Runnable(){
            @Override
            public void run() {
                for(int i =0;i<10;i++){
                    System.out.println("内部类实现新线程"  + i);
                }
            }
        }).start();
        //另外也可以这么写
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i =0;i<10;i++){
                    System.out.println("另一种新的方式创建新的线程" + i);
                }
            }
        };
        new Thread(r).start();
    }
}
