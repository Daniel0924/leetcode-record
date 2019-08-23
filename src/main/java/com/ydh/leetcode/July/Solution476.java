package com.ydh.leetcode.July;

public class Solution476 {

    public static int findComplement(int num) {

        String s = Integer.toBinaryString(num);

        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == '0') {
                c[i] = '1';
            } else {
                c[i] = '0';
            }
        }

        int res = 0;
        for (char n : c) {
            res <<= 1;
            res += n - '0';
        }

        return res;
    }

    public static void main(String[] args) {

        int num = 1;

        System.out.println(findComplement(num));
    }
}
