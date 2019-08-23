package com.ydh.School;

import java.util.HashMap;

public class QuickSort {

    public static void quick(int[] numbers) {
        if (numbers.length > 0) {
            quickSort(numbers, 0, numbers.length - 1);
        }
    }

    public static void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high);
            quickSort(numbers, low, middle - 1);
            quickSort(numbers, middle + 1, high);
        }
    }

    public static int getMiddle(int[] numbers, int low, int high) {

        int temp = numbers[low];

        while (low < high) {

            while (low < high && numbers[high] > temp) {
                high--;
            }

            numbers[low] = numbers[high];

            while (low < high && numbers[low] > temp) {
                low++;
            }
            numbers[high] = numbers[low];
        }
        numbers[low] = temp;

        return low;
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 2, 8, 9, 1, 3, 7, 0};
        quick(nums);
        System.out.println("ok");
        for (int i : nums) {
            System.out.println(i + ",");
        }

    }
}
