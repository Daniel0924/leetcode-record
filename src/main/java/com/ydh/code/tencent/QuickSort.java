package com.ydh.code.tencent;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QuickSort {


    /**
     * 核心思想：每次从i后面找到最小的数，把这个数放到最前面i的位置上
     * 选择排序，i从头到尾，k先记录i序号，j从尾到i，
     * 如果j对应的值大于k对应的值，则更新k，交换i和k
     *
     * @param nums
     */
    public static void chooseSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int k = i;
            for (int j = nums.length - 1; j > i; j--) {

                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }

    /**
     * 快速排序
     * 左右两端，左大右小，先右后左，左右交换
     *
     * @param nums
     * @param start
     * @param end
     */
    public static void quickSort(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        if (start > end) {
            return;
        }
        int base = nums[start];

        while (i < j) {
            while (j > i && nums[j] >= base) {
                j--;
            }

            while (i < j && nums[i] <= base) {
                i++;
            }

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            if (i == j) {
                nums[start] = nums[i];
                nums[i] = base;
            }
        }

        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }


    public static void insertSort(int[] nums) {
        int j;

        for (int i = 1; i < nums.length; i++) {

            int temp = nums[i];

            for (j = i; j > 0 && nums[j - 1] > temp; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
    }


    public static void insertSort2(int[] nums) {
        int j;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];

            for (j = i; j > 0 && nums[j - 1] > temp; j--) {

                nums[j] = nums[j - 1];
            }

            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 1, 2, 3, 9, 8, 7, 6};

        int start = 0;
        int end = nums.length - 1;

        insertSort2(nums);

        for (int i : nums) {
            System.out.print(i + ",");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    }
}
