package com.ydh.leetcode.July;

import java.util.Arrays;
import java.util.Comparator;

public class Solution474 {

    /**
     * 意思是说，我现在有m个0和n个1，然后strs里面的元素都是由0或1组成的
     * 返回我们使用m个0和n个1，能拼出的strs里面的元素的最大的数量
     * 贪心算法不好做，还是使用动态规划，dp[m + 1][n + 1] 中的dp[i][j]表示由i个0，j个1拼成的最多数量
     * dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones])
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public static int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        int zeros = 0;
        int ones = 1;

        for (String s : strs) {
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    ones++;
                } else zeros++;
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[m][n] = Math.max(dp[m][n], 1 + dp[m - zeros][n - ones]);
                }
            }

        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        String[] strs = {"10", "11", "0001", "111001", "1", "0"};
        findMaxForm(strs, 5, 3);
    }
}
