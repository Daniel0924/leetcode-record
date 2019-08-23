package com.ydh.leetcode.March;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {

    public static void main(String[] args) {


        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        List<Integer> res = new Solution54().spiralOrder(matrix);
        res.forEach(System.out::println);
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;


        List<Integer> res = new ArrayList<>();

        while (left <= right && top <= bottom) {
            int i = top;
            int j = left;

            res.add(matrix[i][j]);
            while (j < right) {
                j++;
                res.add(matrix[i][j]);
            }

            while (i < bottom) {
                i++;
                res.add(matrix[i][j]);
            }

            while (j > left && i > top) {
                j--;
                res.add(matrix[i][j]);
            }

            while (i > top && j < right) {
                i--;
                if (i > top){
                    res.add(matrix[i][j]);

                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return res;

    }
}
