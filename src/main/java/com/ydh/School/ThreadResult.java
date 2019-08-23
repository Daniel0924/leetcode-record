package com.ydh.School;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadResult {


    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();


        Task task = new Task();
        Future<Integer> result = service.submit(task);

        service.shutdown();

        System.out.println("主线程获得控制权");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("主线程在执行任务");

        try {
            System.out.println(result.get());

        }catch (Exception e){
            e.fillInStackTrace();
        }

        System.out.println("所有任务执行完毕");

    }
}

class Task implements Callable {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
        return sum;
    }
}