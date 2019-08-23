package com.ydh.leetcode.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AirplanePlan {

    public static int getRes(int n, int s, int[] f) {
        if (n <= 0 || s <= 0 || f == null || f.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < n && i < f.length; i++) {
            sum += f[i];

            if (sum > s) {
                return i;
            }
        }
        return n < f.length ? n : f.length;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] line1 = br.readLine().split(" ");

            int n = Integer.parseInt(line1[0]);
            int s = Integer.parseInt(line1[1]);
            String[] f = br.readLine().split(" ");
            int[] nums = new int[f.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(f[i]);
            }

            System.out.println(getRes(n, s, nums));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
