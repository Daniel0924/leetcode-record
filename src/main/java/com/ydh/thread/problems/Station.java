package com.ydh.thread.problems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Sell2 implements Runnable {

    private int total = 100;
    Object object = "aa";

    @Override
    public void run() {
        while (total > 0) {
            synchronized (object) {
                if (total > 0) {
                    System.out.println(Thread.currentThread().getName() + ", "
                            + total);
                    total--;
                    try {
                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("sold out!");
                }
            }
        }

    }
}

class TicketSell implements Runnable {

    static Object object = "aa";
    static int tick = 20;
    String name;

    public TicketSell(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (tick > 0) {
            synchronized (object) {
                if (tick > 0) {
                    System.out.println(name + ", " + tick);
                    tick--;
                } else {
                    System.out.println("sell out");
                }
            }
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

public class Station extends Thread {

    public static void main(String[] args) {



        /*
         Thread thread1 = new Thread(new TicketSell("窗口1"));
         Thread thread2 = new Thread(new TicketSell("窗口2"));
         Thread thread3 = new Thread(new TicketSell("窗口3"));
         thread1.start();
         thread2.start();
         thread3.start();
         */
    }

}
