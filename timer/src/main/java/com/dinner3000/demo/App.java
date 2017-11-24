package com.dinner3000.demo;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello!");
            }
        }, 2000L, 1000L);
    }
}
