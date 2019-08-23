package com.ydh.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6 {

    public static int getNums(int row, int col, int k, int[][] matrix) {
        int[][] dp = new int[row][col];

        if (row < 3 || col < 3) {
            return 0;
        }


        for (int i = 2; i < matrix.length; i++) {
            for (int j = 2; j < matrix[0].length; j++) {

                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];

                int temp = matrix[i - 1][j] + matrix[i][j - 1]
                        + matrix[i - 1][j - 1] + matrix[i - 1][j - 2]
                        + matrix[i - 2][j - 1];

                if (temp == 5) {
                    dp[i][j] += 1;

                }
            }
        }

        for (int i = 2; i < row; i++) {
            for (int j = 2; j < col; j++) {

                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];

            }
        }

        int res = 0;
        for (int i = 2; i < row; i++) {
            for (int j = 2; j < col; j++) {

                if (dp[i][j] >= k) {
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int n1 = 3;
        int n2 = 5;
        int k = 2;
        int[][] nums = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}};


        System.out.println(getNums(n1, n2, k, nums));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] line1 = br.readLine().split(" ");
            int row = Integer.parseInt(line1[0]);
            int col = Integer.parseInt(line1[1]);
            int num = Integer.parseInt(line1[2]);
            int[][] matrix = new int[row][col];

            for (int i = 0; i < row; i++) {
                String s = br.readLine();
                for (int j = 0; j < s.length(); j++) {
                    matrix[i][j] = s.charAt(i) - '0';
                }
            }

            int res = getNums(row, col, num, matrix);
            System.out.println(res);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
