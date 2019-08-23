package com.ydh.test;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {


    private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();


    public static void initCache(String account) {

        map.put(account, "110");
    }

    public static String getCache(String accunt) {

        if (!map.containsKey(accunt)) {
            initCache(accunt);
        }
        return map.get(accunt);
    }

    public static void removeCache(String account) {

        map.remove(account);
    }

    public static void main(String[] args) {

        int n = 21;
        int count = 0;
        if (n < 0) {
            n = -n;
        }
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n >>= 1;
        }
        System.out.println(count);


    }
}
