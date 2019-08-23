package com.ydh.leetcode.niuke;

import java.util.HashMap;

public class Solution65 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length != rows * cols
                || str == null || str.length == 0) {
            return false;
        }

        boolean[] visited = new boolean[rows * cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, str, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;


    }

    public boolean hasPathCore(char[] matrix, int rows, int cols,
                                      char[] str, boolean[] visited,
                                      int row, int col, int index) {

        if (index == str.length) {
            return true;
        }

        if (row >= rows || col > cols || row < 0 || col < 0) {
            return false;
        }

        if (visited[row * cols + col] || matrix[row * cols + col] != str[index]) {
            return false;
        }

        boolean hp = hasPathCore(matrix, rows, cols,
                str, visited, row + 1, col, index + 1)
                || hasPathCore(matrix, rows, cols,
                str, visited, row, col + 1, index + 1)
                || hasPathCore(matrix, rows, cols,
                str, visited, row - 1, col, index + 1)
                || hasPathCore(matrix, rows, cols,
                str, visited, row, col - 1, index + 1);

        if (hp) {
            return hp;
        }
        visited[row * cols + col] = false;
        return false;
    }

    public static void main(String[] args) {
        boolean[] visited = new boolean[10];

        for (boolean b : visited) {
            System.out.println(b);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

    }

}
