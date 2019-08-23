package com.ydh.leetcode.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main3 {

    // 给定一系列区间nums，行数为n，列数为2，返回可以组成[0,l]的最少区间数
    // 区间完全覆盖问题
    public static int getRes(int n, int l, int[][] nums) {

        if (nums == null || nums.length == 0 || l <= 0) {
            return 0;
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i <= l; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i > nums[j][1] && j < nums[j + 1][0]) {
                    return -1;
                }
            }
        }

        int count = 0;
        int left = nums[n - 1][0];
        int right = nums[n - 1][1];

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i][0] < left && nums[i][1] >= right) {
                left = nums[i][0];
            } else if (nums[i][0] < left && nums[i][1] < right){
                left = nums[i][0];
                right = nums[i][1];
                count++;
            } else if (nums[i][1] < left){
                count--;
            }
        }
        System.out.println();

        return count;
    }


    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int l = Integer.parseInt(line[1]);

            int[][] nums = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                nums[i][0] = Integer.parseInt(s[0]);
                nums[i][1] = Integer.parseInt(s[1]);
            }

            System.out.println(getRes(n, l, nums));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
