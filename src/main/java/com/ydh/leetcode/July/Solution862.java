package com.ydh.leetcode.July;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution862 {

    public int maxSumAfterPartitioning(int[] A, int K) {
        Arrays.sort(A);

        int len = A.length;
        if (len == 1) {
            return A[0];
        }
        int item = len / K + 1;  // 一共有多少组
        int leave = len % K;     // 最后一组
        int res = 0;
        for (int i = 1; i < item; i++) {
            res += K * A[len - i];
            System.out.println(res);
        }
        if (leave != 0) {
            res += leave * A[len - item];
            System.out.println(res);
        }

        return res;
    }

    public int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }

        Deque<Integer> deque = new LinkedList<>();
        int len = A.length;
        int min = Integer.MAX_VALUE;

        long[] sums = new long[len + 1];
        for (int i = 1; i < len + 1; i++) {
            sums[i] = sums[i - 1] + A[i - 1];
        }

        for (int i = 0; i < len + 1; i++) {
            while (!deque.isEmpty() && sums[i] <= sums[deque.getLast()]) {
                System.out.printf("sums[%d]: %d\n", i, sums[i]);
                System.out.println("remove last:" + deque.getLast());
                deque.removeLast();
            }
            while (!deque.isEmpty() && sums[i] - sums[deque.getFirst()] >= K) {
                System.out.println("remove first:" + deque.getFirst());
                min = Math.min(min, i - deque.removeFirst());
            }
            System.out.println("add last:" + i);
            deque.addLast(i);
        }

        return min == Integer.MAX_VALUE ? -1 : min;

    }

    public static void main(String[] args) {

        int[] test = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};

        new Solution862().maxSumAfterPartitioning(test, 4);

    }

}
