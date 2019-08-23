package com.ydh.leetcode.July;

public class Solution560 {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = 0;

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                res++;

            } else if (sum > k) {

            }
        }

        return -1;
    }
}
