package com.ydh.code.pin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author Yang Danhao
 * Main3 2019/9/1 2:57 PM Version 1.0
 */
public class Main3 {

    public static String getRes(int[] nums, int n) {
        Arrays.sort(nums);
        // 一共有多少个骰子
        int size = nums.length;

        // count的下标表示结果，值表示这个结果出现多少次
        long[] count = new long[nums[size - 1] + 1];
        count[0] = 0;
        for (int i = 1; i < count.length; i++) {
            System.out.println("i = " + i);
            // i表示当前的结果是i
            count[i] = 1;
            int val = i;
            for (int j = 0; j < nums.length; j++) {
                System.out.println("j = " + j);
                if (nums[j] >= val) {
                    for (int k = 0; k < nums.length; k++) {
                        System.out.println("k = " + k);
                        if (k == j) {
                            continue;
                        }
                        if (nums[k] >= i) {
                            count[i] = count[i] * i;
                        } else {
                            count[i] = count[i] * nums[k];
                        }
                        System.out.println("count[" + i + "]=" + count[i]);
                    }
                }
            }
        }

        for (int i = count.length - 1; i > 0; i--) {
            count[i] = count[i] - count[i - 1];
        }
        for (long i : count) {
            System.out.println(i);
        }

        long ci = 0L;
        long sum = 0L;
        for (int i = 1; i < count.length; i++) {
            ci += count[i];
            sum = sum + count[i] * i;
        }
        DecimalFormat df = new DecimalFormat("#.00");
        double res = (double)sum / (double)ci;
        return df.format(res);
    }

    public static void main(String[] args) {

        int[] numsa = {3, 3};
        int nn = 2;

        System.out.println(getRes(numsa, nn));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());

            String[] s = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            System.out.println(getRes(nums, n));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
