package com.ydh.leetcode.September;

/**
 * @author Yang Danhao
 * Solution509 2019/9/4 5:30 PM Version 1.0
 */
public class Solution509 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

}
