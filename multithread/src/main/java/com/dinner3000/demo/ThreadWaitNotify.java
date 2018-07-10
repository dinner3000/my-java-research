package com.dinner3000.demo;

public class ThreadWaitNotify {
    //创建个共享对象做监视器用
//    static Object obj = new Object();
    //大木盘子，一盘最多可盛10份饺子，厨师做满10份，服务员就可以端出去了。
    static Integer platter = 0;
    //卖出的饺子总量，卖够100份就打烊收工
    static Integer count = 0;

    public static void main(String[] args) {
        Thread cookThread = new Thread(new Cook(),"cookThread");
        Thread waiterThread = new Thread(new Waiter(),"waiterThread");
        cookThread.start();
        waiterThread.start();
    }
}

class Cook implements Runnable{
    @Override
    public void run() {
        while(ThreadWaitNotify.count<100){
            synchronized (ThreadWaitNotify.class){
                while (ThreadWaitNotify.platter<10){
                    try {
                        //制作一盘饺子的时间
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "--" + (ThreadWaitNotify.platter+1) + "盘饺子");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ThreadWaitNotify.platter++;
                    if(ThreadWaitNotify.platter >= 10) {
                        System.out.println(Thread.currentThread().getName() + "--饺子好啦，厨师休息会儿");
                    }
                }
                //通知服务员饺子好了，可以端走了
                ThreadWaitNotify.class.notify();
            }
        }
        System.out.println(Thread.currentThread().getName()+"--打烊收工，厨师回家");
    }
}

class Waiter implements Runnable{
    @Override
    public void run() {
        while(ThreadWaitNotify.count<100){
            synchronized (ThreadWaitNotify.class){
                //厨师做够10份了，就可以端出去了
                while(ThreadWaitNotify.platter < 10){
                    try {
                        System.out.println(Thread.currentThread().getName()+"--饺子还没好，等待厨师通知...");
                        ThreadWaitNotify.class.wait();
//                            BlockQueue
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //饺子端给客人了，盘子清空
                ThreadWaitNotify.platter-=10;
                //又卖出去10份。
                ThreadWaitNotify.count+=10;
                System.out.println(Thread.currentThread().getName()+"--服务员把饺子端给客人了");
            }
        }
        System.out.println(Thread.currentThread().getName()+"--打烊收工，服务员回家");

    }
}
