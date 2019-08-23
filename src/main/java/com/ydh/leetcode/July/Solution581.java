package com.ydh.leetcode.July;

import java.util.Arrays;

public class Solution581 {

    public int findUnsortedSubarray(int[] nums) {

        int[] copy = nums.clone();

        Arrays.sort(nums);

        int left = 0;
        int right = copy.length - 1;

        while (left < copy.length && nums[left] == copy[left]) {
            left++;
        }

        if (left == copy.length) {
            return 0;
        }

        while (right > 0 && nums[right] == copy[right]) {
            right--;
        }

        return right - left + 1;

    }
}
