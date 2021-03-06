package com.ydh.offer;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    // 新方法
    public boolean FindWell(int target, int[][] array) {
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col < array[0].length) {
            if (array[row][col] < target) {
                col++;
            } else if (array[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }

    // 从
    public boolean Find(int target, int[][] array) {

        if (array == null || array[0] == null || array[0].length == 0) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            if (findOne(target, array[i])) {
                return true;
            }
        }
        return false;
    }

    // 二分查找
    public boolean findOne(int target, int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 6;
        int[] array = {1, 2, 6, 7, 8, 9};

        System.out.println(new Solution1().findOne(target, array));
        Map<Integer, Integer> map = new HashMap<>();
    }
}
