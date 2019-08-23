package com.ydh.thread.problems;

public class ThreadAdd {


    private int i = 0;

    public static void main(String[] args) {
        ThreadAdd demo = new ThreadAdd();

        Add add = demo.new Add();
        Sub sub = demo.new Sub();

        for (int i = 1; i <= 2; i++){
            new Thread(add).start();
            new Thread(sub).start();
        }
    }

    public synchronized void addOne() {
        i++;
        System.out.println(Thread.currentThread().getName()+"加一的值为:"+i);

    }

    public synchronized void subOne() {
        i--;
        System.out.println(Thread.currentThread().getName()+"减一的值为:"+i);
    }

    class Add implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                addOne();
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Sub implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                subOne();
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
