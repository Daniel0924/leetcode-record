package com.ydh.offer;

import java.util.function.LongFunction;

public class Solution43 {

    public static String LeftRotateString(String str, int n) {
        n = n % str.length();

        String s1 = str.substring(0, n);
        String s2 = str.substring(n);

        return s2 + s1;
    }

    public static void main(String[] args) {


        String s = "abcdefghijkl";

        int n = 3;

        System.out.println(LeftRotateString(s, n));
    }
}
