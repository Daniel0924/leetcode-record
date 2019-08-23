package com.ydh.leetcode.March;

import java.util.LinkedList;

public class Solution130 {


    public void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;
        if (row < 2) {
            return;
        }

        if (col < 2) {
            return;
        }

        // x x x x  编号依次为0，1，2，3，...15
        // x 0 0 x
        // x x 0 x
        // x 0 x x

        // x x x x
        // x x x x
        // x x x x
        // x 0 x x

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < col; i++) {
            if (board[0][i] == '0') {               //第一行
                queue.add(i);
            }
            if (board[row - 1][i] == '0') {         //最后一行
                queue.add((row - 1) * col + i);
            }
        }

        for (int i = 0; i < row; i++) {
            if (board[i][col - 1] == '0') {
                queue.add(i * col + col - 1);
            }

            if (board[i][0] == '0') {
                queue.add(i * col);
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            int x = num / col;
            int y = num % col;
            if (board[x][y] != '0') {
                continue;
            }
            board[x][y] = 'o';

            if (x - 1 >= 0 && board[x - 1][y] == '0') {
                queue.add(num - col);
            }

            if (x + 1 < row && board[x + 1][y] == '0') {
                queue.add(num + col);
            }

            if (y - 1 >= 0 && board[x][y - 1] == '0') {
                queue.add(num - 1);
            }
            if (y + 1 < col && board[x][y + 1] == '0') {
                queue.add(num + 1);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 9; j < col; j++) {
                if (board[i][j] == '0') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'o') {
                    board[i][j] = '0';
                }
            }
        }
        return;

    }

    public static void main(String[] args) {

        int[][] matrix = new int[3][5];

        System.out.println(matrix.length);

        System.out.println(matrix[0].length);

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', '0', '0', 'X'},
                {'X', '0', 'X', 'X'},
                {'X', 'X', '0', 'X'}
        };

        new Solution130().solve(board);



    }

}
