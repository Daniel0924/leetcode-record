package com.ydh.code.settest;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();        //表示队列不满的状态
    private Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        Demo test = new Demo();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

        producer.start();
        consumer.start();
    }

    //Test类的内部类
    class Consumer extends Thread {
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列空，等待数据");
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();         //取走元素了，这样之前因为队列满而阻塞的线程就可以恢复了
                    notFull.signal();     //唤醒notFull中之前await的线程
                    System.out.println("取走一个元素:" + queue.size());
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

    class Producer extends Thread {
        public void run() {
            product();
        }

        private void product() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == queueSize) {
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    System.out.println("加入元素:" + queue.size());
                    notEmpty.signal();
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
