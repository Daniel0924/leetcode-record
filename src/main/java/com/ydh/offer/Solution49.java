package com.ydh.offer;

import java.util.AbstractMap;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class Solution49 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
                100, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        executor.execute(new MyRunnable());

        final Object o1 = new Object();
        final Object o2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (o1) {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (o2) {
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (o1) {
                

                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                }
            }

        });


        t1.start();
        t2.start();
    }
}
