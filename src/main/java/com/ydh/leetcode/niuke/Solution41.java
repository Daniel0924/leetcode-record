package com.ydh.leetcode.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution41 {


    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> item = new ArrayList<>();

        if (sum < 0) {
            return res;
        }

        int[] num = {1, 2, 3, 4, 5};

        return res;

    }

    public int[] aquery(int left, int right) {

        int[] res = new int[right - left + 1];
        while (left <= right) {

            left++;
        }
        return res;
    }

    public int twoSum(int left, int right) {
        return (right + left) * (right + 1 - left) / 2;
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length < 2) {
            return result;
        }
        int left = 0;
        int right = array.length - 1;
        int product = Integer.MAX_VALUE;
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MAX_VALUE;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                if (array[left] * array[right] < product) {
                    num1 = array[left];
                    num2 = array[right];
                    product = array[left] * array[right];
                }
                left++;
                right--;
            } else if (array[left] + array[right] < sum) {
                left++;
            } else {
                right--;
            }
        }
        result.add(num1);
        result.add(num2);
        return result;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int sum = 7;
        ArrayList<Integer> res = new Solution41().FindNumbersWithSum(array, sum);

        res.forEach(System.out::println);
    }
}
