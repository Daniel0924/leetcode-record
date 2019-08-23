package com.ydh.School;

public class ThreadLocalTest {


    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        Integer i = threadLocal.get();

        System.out.println(i);

        threadLocal.set(100);

        System.out.println(threadLocal.get());
    }
}
