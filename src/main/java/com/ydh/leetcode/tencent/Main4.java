package com.ydh.leetcode.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {





    public static int[] getRes(int[] nums, int n) {




        int[] res = new int[n];
        res[0] = 2;
        res[n - 1] = 2;

        for (int i = 1; i < n - 1; i++) {
            res[i] = 3;
        }

        int base = nums[1];
        for (int i = 2; i < n; i++) {
            if (nums[i] > base) {
                res[0]++;
                base = nums[i];
            }
        }

        for (int i = 1; i < n - 1; i++) {

            base = nums[i - 1];
            for (int j = i - 2; j >= 0; j--) {
                if (nums[j] > base) {
                    res[i]++;
                    base = nums[j];
                }
            }

            base = nums[i + 1];
            for (int k = i + 2; k < n; k++) {
                if (nums[k] > base) {
                    res[i]++;
                    base = nums[k];
                }
            }
        }

        base = nums[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > base) {
                res[n - 1]++;
                base = nums[i];
            }
        }

        return res;
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            String[] array = br.readLine().split(" ");
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(array[i]);
            }
            int[] result = getRes(nums, n);
            for(int i : result){
                System.out.print(i + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
