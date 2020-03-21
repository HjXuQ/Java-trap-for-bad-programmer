package com.xuhj.javaApi;

public class baoziPuThread extends Thread {
    private Baozi baozi;

    public baoziPuThread(String name,Baozi baozi) {
        super(name);
        this.baozi = baozi;
    }

    @Override
    public void run() {
        int count = 0;
        //永远造包子
        while(true){
//            同步
              synchronized (baozi){
                  try {
                      if(baozi.flag == true){
                          //有包子，包子铺进入等待状态
                          baozi.wait();
                      }
                  }catch (InterruptedException e){
                      e.printStackTrace();
                  }
                  System.out.println("包子铺正在做包子");
                  if(count % 2 == 0){
                      baozi.pier = "全麦";
                      baozi.xianer = "虾仁";
                  }else {
                      baozi.pier = "玉米";
                      baozi.xianer = "牛肉";
                  }
                  count++;
                  baozi.flag = true;
                  System.out.println("包子造好了");
                  System.out.println("吃货来吃吧");
                  baozi.notify();
              }
        }

    }

    public static void main(String[] args) {
        /**
         *
         * 合理利用线程池能够带来三个好处:
         * 1. 降低资源消耗。减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务。
         * 2. 提高响应速度。当任务到达时，任务可以不需要的等到线程创建就能立即执行。
         * 3. 提高线程的可管理性。可以根据系统的承受能力，调整线程池中工作线线程的数目，防止因为消耗过多的内
         * 存，而把服务器累趴下(每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大，最后死机)。*/
        Baozi baozi = new Baozi();
        chiHuoThread chiHuoThread = new chiHuoThread("吃货",baozi);
        baoziPuThread baoziPuThread = new baoziPuThread("包子铺",baozi);
        chiHuoThread.start();
        baoziPuThread.start();
    }
}
