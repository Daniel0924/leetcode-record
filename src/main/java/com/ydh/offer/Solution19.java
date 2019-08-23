package com.ydh.offer;

import java.util.ArrayList;

public class Solution19 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        /**
         if (row == 1) {
         for (int i : matrix[0]) {
         res.add(i);
         }
         return res;
         }
         if (col == 1) {
         for (int i = 0; i < row; i++) {
         res.add(matrix[i][0]);
         }
         return res;
         }
         **/

        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        //res.add(matrix[0][0]);
        while (left <= right && top <= bottom) {
            int i = top;
            int j = left;
            res.add(matrix[top][left]);

            while (j < right) {    //从左往右走
                j++;
                res.add(matrix[i][j]);
                System.out.println("1:" + matrix[i][j]);
            }
            while (i < bottom) {
                i++;
                res.add(matrix[i][j]);
                System.out.println("2:" + matrix[i][j]);
            }
            while (j > left && i > top) {
                j--;
                res.add(matrix[i][j]);
                System.out.println("3:" + matrix[i][j]);

            }
            while (i > top && j < right) {
                i--;
                if (i > top) {
                    res.add(matrix[i][j]);
                    System.out.println("4:" + matrix[i][j]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}
        };

        ArrayList<Integer> res = new Solution19().printMatrix(matrix);

        res.forEach(System.out::print);

    }
}
