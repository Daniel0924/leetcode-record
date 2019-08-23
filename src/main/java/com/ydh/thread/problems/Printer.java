package com.ydh.thread.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Printer {

    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        Thread thread1 = new Thread(new Printer().new PrinterInner(lock, condition1, condition2));

        Thread thread2 = new Thread(new Printer().new PrinterInner(lock, condition2, condition3));

        Thread thread3 = new Thread(new Printer().new PrinterInner(lock, condition3, condition1));

        thread1.start();
        thread2.start();
        thread3.start();
    }


    class PrinterInner implements Runnable {

        private int num = 5;
        ReentrantLock lock = new ReentrantLock();
        Condition thisCondition = lock.newCondition();
        Condition nextCondition = lock.newCondition();

        public PrinterInner(ReentrantLock lock,
                            Condition thisCondition, Condition nextCondition) {
            this.lock = lock;
            this.thisCondition = thisCondition;
            this.nextCondition = nextCondition;
        }


        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 15; i++) {

                    for (int j = 0; j < 5; j++) {
                        System.out.println("count, " + count + ", " +
                                Thread.currentThread().getName());
                        count.incrementAndGet();
                    }
                    try {
                        thisCondition.await();
                        System.out.println("等待" + Thread.currentThread().getName());

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    nextCondition.signalAll();
                    System.out.println("唤醒" + Thread.currentThread().getName());

                }

            } finally {
                lock.unlock();
            }
        }
    }
}
