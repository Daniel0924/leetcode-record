package com.ydh.leetcode.September;

import java.util.*;

/**
 * @author Yang Danhao
 * Solution506 2019/9/4 4:39 PM Version 1.0
 */
public class Solution506 {

    public static String[] findRelativeRanks(int[] nums) {

        Integer[] n = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = nums[i];
        }

        Arrays.sort(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(n[i], i);
        }
        String[] res = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int temp = map.get(nums[i]);
            if (temp == 0) {
                res[i] = "Gold Medal";
            } else if (temp == 1) {
                res[i] = "Silver Medal";
            } else if (temp == 2) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = "" + (temp + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {5, 4, 3, 2, 1};
        String[] res = findRelativeRanks(nums);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
