package com.ydh.leetcode.July;

public class Solution42 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int[] dp = new int[len];
        dp[0] = 0;
        int left = height[0];
        int leftIndex = 0;
        for (int i = 1; i < len - 1; i++) {
            System.out.println("i = " + i);
            if (height[i] >= left) {
                left = height[i];
                leftIndex = i;
                dp[i] = dp[i - 1];
                System.out.println("~dp[" + i + "] = " + dp[i]);
            } else {
                if (height[i] < height[i + 1]) {
                    dp[i] = dp[leftIndex] + computeWater(height, leftIndex, i + 1);
                    if (dp[i] < dp[i - 1]) {
                        dp[i] = dp[i] + dp[i - 1];
                    }
                    System.out.println("~~dp[" + i + "] = " + dp[i]);
                } else {
                    dp[i] = dp[i - 1];
                    System.out.println("~~~dp[" + i + "] = " + dp[i]);
                }
            }
        }
        System.out.println("res:" + dp[len - 2] + ", len - 2 = " + (len - 2));
        return dp[len - 2];
    }

    public int computeWater(int[] nums, int start, int end) {
        System.out.println(start + "," + end);
        int res = 0;
        for (int i = start + 1; i < end; i++) {
            int temp = Math.min(nums[start], nums[end]) - nums[i];
            if (temp > 0) {
                res += temp;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] test = {2, 6, 3, 8, 2, 7, 2, 5, 0};
        System.out.println(new Solution42().trap(test));
    }
}

