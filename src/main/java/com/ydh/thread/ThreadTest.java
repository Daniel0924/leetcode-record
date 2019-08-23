package com.ydh.thread;

class RunnablePrint implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "," + Thread.currentThread().getName());
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {



        Thread thread1 = new Thread(new RunnablePrint());
        Thread thread2 = new Thread(new RunnablePrint());
        Thread thread3 = new Thread(new RunnablePrint());

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();

        thread3.start();
        thread3.join();
    }
}
