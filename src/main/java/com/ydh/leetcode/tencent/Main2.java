package com.ydh.leetcode.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static int getReverse(int[] array) {
        int len = array.length;

        int num = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {

                if (array[i] > array[j]) {
                    num++;
                }

            }
        }
        return num;
    }

    public static int[] reverseArray(int[] array, int t) {

        double n = Math.pow(2, t);
        int m = (int) n;

        int duan = array.length / m;
        if (t == 0) {
            return array;
        }

        for (int i = 0; i < duan; i++) {
            for (int j = 0; j < m / 2; j++) {
                int pro = j + i * m;
                int temp = array[pro];
                array[pro] = array[m - 1 - j + i * m];

                array[m - 1 - j + i * m] = temp;

            }
        }
        return array;
    }


    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[(int) Math.pow(2, n)];

            String[] array = br.readLine().split(" ");
            for (int i = 0; i < (int) Math.pow(2, n); i++) {
                nums[i] = Integer.parseInt(array[i]);
            }

            int m = Integer.parseInt(br.readLine());
            int[] nn = new int[m];
            String[] arrays = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                nn[i] = Integer.parseInt(arrays[i]);
            }

            for (int i = 0; i < m; i++) {
                int[] array1 = reverseArray(nums, nn[i]);
                System.out.println(getReverse(array1));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
