package com.ydh.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main6 {

    public static int[] getRes(int n, int q, int[] nums, int[] ops) {
        if (nums == null || ops == null) {
            return nums;
        }

        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] >= ops[i]) {
                    nums[j]--;
                    res[i]++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

        int n1 = 4;
        int q1 = 3;
        int[] nums1 = {1, 2, 3, 4};
        int[] qq = {4, 3, 1};

        int[] rr = getRes(n1, q1, nums1, qq);

        for (int i : rr) {
            System.out.println(i);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] line1 = br.readLine().trim().split(" ");

            int n = Integer.parseInt(line1[0]);
            int q = Integer.parseInt(line1[1]);

            String[] s = br.readLine().trim().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }

            int[] ops = new int[q];
            for (int i = 0; i < q; i++) {
                ops[i] = Integer.parseInt(br.readLine().trim());
            }
            int[] res = getRes(n, q, nums, ops);
            for (int i : res) {
                System.out.println(i);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
