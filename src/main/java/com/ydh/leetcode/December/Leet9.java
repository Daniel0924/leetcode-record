package com.ydh.leetcode.December;

public class Leet9 {


    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int y = helper(x);

        return (x == y);
    }

    public int helper(int x) {
        int res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        return res;
    }
}
