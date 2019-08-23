package com.ydh.leetcode.niuke;

import java.util.*;

public class Solution64 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
            if (!queue.isEmpty()) {
                if (queue.peek() <= i - size) {
                    queue.pop();
                }
            }

            while (!queue.isEmpty() && num[queue.getLast()] < num[i]) {
                queue.removeLast();
            }

            queue.offer(i);

            if (i >= size - 1) {
                res.add(num[queue.peek()]);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};

        Solution64 solution64 = new Solution64();


        ArrayList<Integer> res = solution64.maxInWindows(nums, 3);
        res.forEach(System.out::println);
    }
}
