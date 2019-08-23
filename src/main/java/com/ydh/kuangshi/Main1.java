package com.ydh.kuangshi;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallTest implements Callable<Integer> {

    int sum = 0;

    @Override
    public Integer call() {

        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        return sum;
    }
}

public class Main1 {
    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        Future<Integer> future = service.submit(new CallTest());

        System.out.println("主线程在执行任务");

        try {
            System.out.println("计算结果为：" + future.get());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }

        System.out.println("运行完成了");
    }
}
