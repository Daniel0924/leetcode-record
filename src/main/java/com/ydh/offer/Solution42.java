package com.ydh.offer;

import java.util.ArrayList;

public class Solution42 {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> res = new ArrayList<>();

        int left = 0;
        int right = array.length - 1;
        int multify = Integer.MAX_VALUE;
        int res1 = 0;
        int res2 = 0;

        while (left < right) {
            if (array[left] + array[right] == sum) {

                if (array[left] * array[right] < multify) {
                    multify = array[left] * array[right];
                    res1 = array[left];
                    res2 = array[right];
                }

                left++;
                right--;
            } else if (array[left] + array[right] > sum) {
                right--;
            } else {
                left++;
            }
        }
        res.add(res1);
        res.add(res2);
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int sum = 5;
        ArrayList<Integer> res = new Solution42().FindNumbersWithSum(array, sum);
        res.forEach(System.out::println);

    }
}
