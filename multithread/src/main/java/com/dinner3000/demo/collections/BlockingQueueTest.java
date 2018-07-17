package com.dinner3000.demo.collections;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        // 借助Executors
        ExecutorService service = Executors.newCachedThreadPool();
        // 启动线程
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer);

        // 执行10s
        Thread.sleep(10 * 1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();

        Thread.sleep(2000);
        // 退出Executor
        service.shutdown();
    }
}

class Producer implements Runnable {

    private volatile boolean isRunning = true;
    private BlockingQueue<Integer> queue;
    private static AtomicInteger count = new AtomicInteger();

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        Random r = new Random();

        try {
            System.out.println("Producer started ... ");
            while (isRunning) {
                Thread.sleep(r.nextInt(1000));

                Integer n = count.incrementAndGet();
                if (!queue.offer(n, 2, TimeUnit.SECONDS)) {
                    System.out.println(String.format("Failed to add %d", n));
                }
                System.out.println(String.format("%d Added", n));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("Producer stopped");
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random r = new Random();
        boolean isRunning = true;
        try {
            System.out.println("Consumer started ... ");
            while (isRunning) {
                Integer data = queue.poll(2, TimeUnit.SECONDS);
                if (null != data) {
                    System.out.println(String.format("Consume %d", data));
                    Thread.sleep(r.nextInt(1000));
                } else {
                    // 超过2s还没数据，认为所有生产线程都已经退出，自动退出消费线程。
                    isRunning = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("Consumer stopped");
        }
    }
}
