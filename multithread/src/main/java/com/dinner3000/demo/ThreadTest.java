package com.dinner3000.demo;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("Main thread ID: " + Thread.currentThread().getId());
//        MyThread t1 = new MyThread("线程1");
//        t1.start();
//
//        MyThread t2 = new MyThread("线程2");
//        /**
//         * 这里直接调用my2的run()方法。
//         */
//        t2.run();
//
//        Thread r1 = new Thread(new MyRunable("线程1"));
//        r1.start();
//
//        Thread r2 = new Thread(new MyRunable("线程2"));
//        /**
//         * 这里直接调用my2的run()方法。
//         */
//        r2.run();

        MyCallable c1 = new MyCallable();
        FutureTask result = new FutureTask(c1);
        new Thread(result).start();

        try {
            System.out.println(result.get());
        } catch (Exception e) {
            System.out.println("Failed to get result.");
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        List<Future<String>> futures = new ArrayList<Future<String>>();
        futures.add(threadPool.submit(new Callable() {
            @Override
            public String call() throws Exception {
                return "result 1";
            }
        }));
        futures.add(threadPool.submit(new Callable() {
            @Override
            public String call() throws Exception {
                return "result 2";
            }
        }));
        threadPool.shutdown();
        //处理每个线程的返回结果
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {

    public MyThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Thread name: " + this.getName() + ", ID: " + Thread.currentThread().getId());
    }
}

class MyRunable implements Runnable {

    private String name;

    public MyRunable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread name: " + this.name + ", ID: " + Thread.currentThread().getId());
    }
}

class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        return "returned value";
    }
}