package com.ydh.leetcode.March;

public class Solution287 {

    public static void main(String[] args) {


    }


    public static int find(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;

        long sum = (len * (len + 1)) / 2;

        long standard = 0L;

        for (int i : nums) {
            standard += i;
        }

        return (int) (standard - sum);
    }
}
