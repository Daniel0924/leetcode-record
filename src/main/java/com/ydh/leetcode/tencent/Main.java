package com.ydh.leetcode.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int getRes(int n, int m, int[][] nums) {

        int notzero = 0;
        int[] rows = new int[n];
        int[] cols = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] > 0) {
                    notzero++;
                }
                if (nums[i][j] > rows[i]) {
                    rows[i] = nums[i][j];
                }
                if (nums[i][j] > cols[j]) {
                    cols[j] = nums[i][j];
                }
            }
        }
        int res = notzero * 2;
        for (int i : rows) {
            res += i * 2;
        }
        for (int i : cols) {
            res += i * 2;
        }
        return res;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String[] params = br.readLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int m = Integer.parseInt(params[1]);
            int[][] nums = new int[m][n];
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    nums[i][j] = Integer.parseInt(line[j]);
                }
            }
            System.out.println(getRes(n, m, nums));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
