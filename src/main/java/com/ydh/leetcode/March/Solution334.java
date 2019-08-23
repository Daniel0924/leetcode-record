package com.ydh.leetcode.March;

public class Solution334 {

    public static void main(String[] args) {


        int[] nums = {1, 1, 0, 6};

        System.out.println(new Solution334().increasingTriplet(nums));
    }


    public boolean increasingTriplet(int[] nums) {

        if (nums == null || nums.length < 3) {
            return false;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= left) {
                left = nums[i];

            } else if (nums[i] < right) {
                right = nums[i];
            } else if (nums[i] > right) {
                return true;
            }
        }
        return false;
    }
}
