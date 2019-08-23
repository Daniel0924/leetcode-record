package com.ydh.School;


import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {

        ThreadTest test = new ThreadTest();
        Productor productor = test.new Productor();

        Consumer consumer = test.new Consumer();

        productor.start();
        consumer.start();


    }

    class Productor extends Thread {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == queueSize) {

                        try {
                            System.out.println("队列已经满了");
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                    queue.offer(1);
                    notEmpty.signal();
                    System.out.println("插入元素，现在的剩余空间：" +
                            (queueSize - queue.size()));
                } finally {
                    lock.unlock();
                }
            }

        }
    }


    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();

                    while (queue.size() == 0) {

                        try {
                            notEmpty.await();
                            System.out.println("队列是空的");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    queue.poll();

                    notFull.signal();
                    System.out.println("取走元素，剩余空间为：" +
                            (queueSize - queue.size()));
                } finally {
                    lock.unlock();
                }

            }
        }
    }
}
