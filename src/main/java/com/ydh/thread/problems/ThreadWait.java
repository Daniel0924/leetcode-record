package com.ydh.thread.problems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWait {


    public static void main(String[] args) {
        new Thread(new WaitTest()).start();
    }
}


class WaitTest implements Runnable {

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("我在运行");
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("运行结束");

            try {
                condition1.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("程序结束");
        } finally {
            lock.unlock();
        }

    }
}