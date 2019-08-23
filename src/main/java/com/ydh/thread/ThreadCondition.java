package com.ydh.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCondition {


    public static void main(String[] args) throws InterruptedException {
        new ThreadCondition().test();
    }

    public void test() throws InterruptedException {
        ThreadGroup group = new ThreadGroup("xx");
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        Thread printerA = new Thread(group, new Printer(lock, conditionA, conditionB, 'A'));
        Thread printerB = new Thread(group, new Printer(lock, conditionB, conditionC, 'B'));
        Thread printerC = new Thread(group, new Printer(lock, conditionC, conditionA, 'C'));

        printerA.start();
        printerB.start();
        printerC.start();
    }

    private class Printer implements Runnable {
        private static final int PRINT_COUNT = 6;
        private final ReentrantLock reentrantLock;

        private final Condition thisCondition;
        private final Condition nextCondition;
        private final char printChar;

        public Printer(ReentrantLock reentrantLock, Condition thisCondition,
                       Condition nextCondition, char printChar) {
            this.reentrantLock = reentrantLock;
            this.nextCondition = nextCondition;
            this.thisCondition = thisCondition;
            this.printChar = printChar;
        }

        public void run() {
            // 获取打印锁 进入临界区
            reentrantLock.lock();
            try {
                // 连续打印PRINT_COUNT次
                for (int i = 0; i < PRINT_COUNT; i++) {
                    System.out.print(printChar);
                    // 使用nextCondition唤醒下一个线程
                    // 因为只有一个线程在等待，所以signal或者signalAll都可以
                    nextCondition.signal();
                    // 不是最后一次则通过thisCondtion等待被唤醒
                    // 必须要加判断，不然能够打印6次 但6次后就会直接死锁
                    if (i < PRINT_COUNT - 1) {
                        try {
                            // 本线程让出锁并等待唤醒
                            thisCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }

    }
}
