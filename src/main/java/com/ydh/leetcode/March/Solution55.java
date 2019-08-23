package com.ydh.leetcode.March;

import com.ydh.leetcode.February.Solution234;

public class Solution55 {

    public static void main(String[] args) {
        int[] nums = {2, 5, 0, 0};

        System.out.println(new Solution55().canJump(nums));

    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int len = nums.length;
        return helper(nums, 0, len);
    }

    public boolean helper(int[] nums, int index, int len) {
        if (index >= len - 1) {
            return true;
        }
        boolean res = false;
        int range = nums[index];
        for (int i = range; i >= 1; i--) {
            res = helper(nums, index + i, len);
            if (res) {
                return true;
            }
        }
        return res;
    }
}
