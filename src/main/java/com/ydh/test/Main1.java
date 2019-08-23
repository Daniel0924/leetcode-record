package com.ydh.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main1 {


    public static String simple(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return "";
        }
        int[] result = new int[s1.length() + s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                int temp = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                result[i + j] += (temp / 10);
                result[i + j + 1] += (temp % 10);
                if (result[i + j] > 10) {
                    result[i + j + 1] += (result[i + j] % 10);
                    result[i + j] /= 10;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        int index = 0;
        for (int i = index; i < result.length; i++) {
            if (result[i] == 0) {
                index++;
            } else {
                break;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0) {
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        System.out.println(simple("2000", "3000"));


        String[] s = "100 20".split(" ");

        int num = Integer.parseInt(s[0]);
        System.out.println(s[1]);
    }

    public static String name(String s) {
        System.out.println(s);
        if (test()) {
            System.out.println("test");
        }

        return s;
    }

    public static boolean test() {
        return false;
    }

    static int fib(int n, int count) {
        count++;
        if (n == 0) {
            return 1;

        } else if (n == 1) {
            return 2;
        } else {
            return fib(n - 1, count) + fib(n - 2, count);
        }
    }
}
