package com.ydh.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main4 {

    public static String getRes(int n, int[] nums) {
        int big = Integer.MIN_VALUE;
        int mid = Integer.MIN_VALUE;
        int sma = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i >= big) {
                sma = mid;
                mid = big;
                big = i;

            } else if (i >= mid) {
                sma = mid;
                mid = i;
            } else if (i >= sma) {
                sma = i;
            }
            System.out.printf("big:%d, mid:%d, sma:%d\n", big, mid, sma);

        }
        System.out.printf("big:%d, mid:%d, sma:%d\n", big, mid, sma);
        return big >= (mid + sma) ? "NO" : "YES";
    }

    public static String getRes2(int n, int[] nums) {
        return "";
    }

    public static void main(String[] args) {

        int n1 = 5;
        int[] nums1 = {1, 2, 3, 3, 2};

        getRes(n1, nums1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> res = new ArrayList<>();
        try {
            // 组数
            int times = Integer.parseInt(br.readLine());

            for (int i = 0; i < times; i++) {

                int n = Integer.parseInt(br.readLine().trim());

                String[] s = br.readLine().trim().split(" ");
                int[] nums = new int[n];
                for (int j = 0; j < n; j++) {
                    nums[j] = Integer.parseInt(s[j]);
                }
                res.add(getRes(n, nums));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String ss : res) {
            System.out.println(ss);
        }
    }
}
