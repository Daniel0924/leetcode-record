package com.ydh.leetcode.December;

public class Leet10 {

    public boolean isMatch(String s, String p) {

        //要用p去匹配s，p中可以有两种符号
        //*
        //.
        //动态规划矩阵，表示每个位置是否能匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {

                boolean first = (i < s.length() &&
                        (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

                    dp[i][j] = dp[i][j + 2] || first && dp[i + 1][j];

                } else {

                    dp[i][j] = first && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
