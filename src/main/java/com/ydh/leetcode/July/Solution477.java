package com.ydh.leetcode.July;

public class Solution477 {

    public static int totalHammingDistance(int[] nums) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int zeros = 0;
            int ones = 0;
            for (int j = 0; j < nums.length; j++) {

                if ((nums[j] & 1) == 1) {
                    ones++;
                } else {
                    zeros++;
                }

                if (nums[j] > 0) {
                    nums[j] >>= 1;
                }
            }
            res += ones * zeros;
        }
        return res;
    }


    public static void main(String[] args) {


        int[] nums = {1337, 7331};

        String s1 = Integer.toBinaryString(1337);
        String s2 = Integer.toBinaryString(7331);

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(totalHammingDistance(nums));

        int a = 5;  // 0101
        int b = 10; // 1010

        int c = a ^ b;


        System.out.println(c); // 1111
    }

}
