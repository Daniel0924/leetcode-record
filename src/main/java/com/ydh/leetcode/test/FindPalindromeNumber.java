package com.ydh.leetcode.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPalindromeNumber {

    public static int getRes(int left, int right) {
        if (left < 0 || right < 0 || left > right) {
            return 0;
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (isPalindrome(i) && isPrime(i)) {
                System.out.println(i);
                res++;
            }
        }

        return res;
    }

    public static boolean isPalindrome(int num) {
        String s = num + "";

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] s = br.readLine().split(" ");
            int left = Integer.parseInt(s[0]);
            int right = Integer.parseInt(s[1]);

            System.out.println(getRes(left, right));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
