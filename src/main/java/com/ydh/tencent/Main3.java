package com.ydh.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main3 {

    public static long getRes(int n, int s, int[] nums) {

        if (n < s) {
            return 0;
        }

        long num2 = (long) Math.pow(2, (n - s));
        long numSon = 1;
        long numMother = 1;

        for (int i = (n - s + 1); i <= n; i++) {
            numSon *= i;

        }

        for (int i = 1; i <= s; i++) {
            numMother *= i;
        }

        long rr = 10000000000000007L;
        return (numSon / numMother * num2) % rr;
    }


    public static void main(String[] args) {

        int[] test = new int[1000];
        for (int i = 0; i < 1000; i++){
            test[i] = 0;
        }
        System.out.println(getRes(1000, 0, test));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] array = br.readLine().split(" ");
            int n = Integer.parseInt(array[0]);

            int s = Integer.parseInt(array[1]);

            String[] strs = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < strs.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }

            System.out.println(getRes(n, s, nums));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
