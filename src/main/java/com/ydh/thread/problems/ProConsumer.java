package com.ydh.thread.problems;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProConsumer {

    ReentrantLock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        ProConsumer proConsumer = new ProConsumer();
        Consumer consumer = proConsumer.new Consumer();

        Productor productor = proConsumer.new Productor();

        new Thread(consumer).start();
        new Thread(productor).start();
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        System.out.println("empty");
                        try {
                            notEmpty.await();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    queue.poll();
                    notFull.signal();

                    System.out.println("consume, total: " + queue.size());
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(new Random().nextInt(1000));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Productor implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();

                try {
                    while (queue.size() == 10) {
                        System.out.println("full");
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    queue.offer(1);
                    notEmpty.signal();
                    System.out.println("product, total: " + queue.size());
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(new Random().nextInt(1000));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
