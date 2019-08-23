package com.ydh.thread;

import javax.management.relation.RoleUnresolved;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadIncreasement {

    private final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {

        new ThreadIncreasement().test();
    }

    public void test() {

        ReentrantLock lock = new ReentrantLock();

        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        ThreadGroup group = new ThreadGroup("XX");

        Thread threadA = new Thread(group, new Printer(lock, conditionA, conditionB));
        Thread threadB = new Thread(group, new Printer(lock, conditionB, conditionC));
        Thread threadC = new Thread(group, new Printer(lock, conditionC, conditionA));

        threadA.start();
        threadB.start();
        threadC.start();

        while (group.activeCount() > 0) {
            Thread.yield();
        }

    }

    private class Printer implements Runnable {

        private static final int TOTAL_PRINT_COUNT = 5;

        private static final int PER_PRINT_COUNT = 5;

        private final ReentrantLock lock;
        private final Condition thisCondition;
        private final Condition nextCondition;

        public Printer(ReentrantLock lock, Condition thisCondition, Condition nextCondition) {
            this.lock = lock;
            this.thisCondition = thisCondition;
            this.nextCondition = nextCondition;
        }

        @Override
        public void run() {
            lock.lock();
            for (int i = 0; i < TOTAL_PRINT_COUNT; i++) {
                System.out.println(count.incrementAndGet() + ", "
                        + Thread.currentThread().getName());

                nextCondition.signalAll();

                try {
                    thisCondition.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            lock.unlock();
        }
    }


}