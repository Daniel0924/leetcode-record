package com.ydh.leetcode.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Judge {

    public static int getRes(int n, int t, int a) {
        if (n <= 0 || n < a || t <= 0 || a <= 0 || t > n) {
            return 0;
        }

        if (t < a) {
            return n - a + t;
        } else {
            return n - t + a;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.next());
        int t = Integer.parseInt(scanner.next());
        int a = Integer.parseInt(scanner.next());

        System.out.println(getRes(n, t, a));

        System.out.println("n = " + n + ", t = " + t + ", a = " + a);

    }
}
