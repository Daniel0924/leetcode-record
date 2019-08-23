package com.ydh.offer;

import java.util.HashMap;
import java.util.Map;

public class Solution31 {

    public int NumberOf1Between1AndN_Solution(int n) {

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += timesOfOne(i);
        }
        return sum;
    }

    public int timesOfOne(int n) {
        int count = 0;
        while (n > 0) {
            System.out.println(n);
            if (n % 10 == 1) {
                count++;
            }
            n = n / 10;
        }
        return count;
    }

    public static void main(String[] args) {

        int num = 5;

        System.out.println(
                new Solution31().NumberOf1Between1AndN_Solution(num));
    }
}
