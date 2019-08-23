package com.ydh.leetcode.March;

public class Solution258 {

    public int addDigits(int num) {
        while (num >= 10) {
            num = getsum(num);
        }
        return num;
    }

    public int getsum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 38;
        System.out.println(new Solution258().addDigits(num));
    }

}

