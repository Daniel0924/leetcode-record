package com.ydh.leetcode.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReSortArray {

    public static int getRes(int n, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] >= nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    System.out.println("dp" + i + " = " + dp[i]);

                    if (dp[i] > res) {
                        res = dp[i];
                    }

                }
            }
        }
        return n - res;

    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");

            int[] nums = new int[s.length];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            System.out.println(getRes(n, nums));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
