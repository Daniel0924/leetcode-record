package com.ydh.thread.problems;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Function {
    private boolean flag = false;

    Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    public void sub() {

        lock.lock();

        try {

            while (flag) {
                try {
                    condition.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < 9; i++) {
                System.out.println("sub, " + i);
            }

            flag = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void main() {
        lock.lock();

        try {

            while (!flag) {
                try {
                    condition.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < 20; i++) {
                System.out.println("main, " + i);
            }

            flag = true;
            condition.signal();

        } finally {
            lock.unlock();
        }
    }

}


public class ThreadQueue {
    public static void main(String[] args) {

        Function f = new Function();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    f.sub();
                }
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            f.main();
        }
    }
}
