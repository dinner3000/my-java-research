package com.dinner3000.demo.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) throws InterruptedException {
// 创建1个消费者线程
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getId() + ": 消费者已创建");
                    while (true) {
                        Consumer.consume();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        // 创建10个生产者线程
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getId() + ": 生产者已创建");
                    while (true) {
                        Producer.produce();
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        Thread.currentThread().join();
    }
}

class MyReentrantLock {
    public static Lock instance = new ReentrantLock();
    public static Condition producer = instance.newCondition();
    public static Condition consumer = instance.newCondition();
}

class MyCache {
    public static List<String> instance = new ArrayList<>(1);
}

class Producer {
    public static void produce() {
        try {
            MyReentrantLock.instance.lock();

            while (MyCache.instance.size() > 20) {
                System.out.println(Thread.currentThread().getId() + ": 队列已满, 阻塞生产者");
                MyReentrantLock.producer.await();
            }
            System.out.println(Thread.currentThread().getId() + ": 生产者被唤醒, 写入数据");
            MyCache.instance.add("a");

//            System.out.println(Thread.currentThread().getId() + ": 唤醒消费者");
            MyReentrantLock.consumer.signal();
        } catch (Exception e) {
        } finally {
            MyReentrantLock.instance.unlock();
        }
    }
}

class Consumer {
    public static void consume() {
        try {
            MyReentrantLock.instance.lock();
            while (MyCache.instance.size() <= 0) {
                System.out.println(Thread.currentThread().getId() + ": 队列为空.阻塞消费者");
                MyReentrantLock.consumer.await();
            }
            System.out.println(Thread.currentThread().getId() + ": 消费者被唤醒, 读取数据");
            MyCache.instance.remove(MyCache.instance.size() - 1);

//            System.out.println(Thread.currentThread().getId() + ": 唤醒生产者");
            MyReentrantLock.producer.signal();
        } catch (Exception e) {
        } finally {
            MyReentrantLock.instance.unlock();
        }
    }
}