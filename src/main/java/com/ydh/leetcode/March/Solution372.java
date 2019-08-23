package com.ydh.leetcode.March;

public class Solution372 {


    public int normalPow(int a, int b) {
        int result = 1;
        while (b != 0) {
            if (b % 2 != 0)
                result = result * a % 1337;
            a = a * a % 1337;
            b /= 2;
        }
        return result;
    }

    public int superPow(int a, int[] b) {
        a %= 1337;
        int result = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            result = result * normalPow(a, b[i]) % 1337;
            a = normalPow(a, 10);
        }
        return result;
    }

    public static void main(String[] args) {

        int a = 2147483647;
        int[] b = {2, 0, 0};

        System.out.println(new Solution372().superPow(a, b));
    }
}
