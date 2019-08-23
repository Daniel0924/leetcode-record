package com.ydh.School;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindRoad {

    public static int[][] next = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static boolean[][][] flag;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //行
        int m = sc.nextInt();   //列

        sc.nextLine();
        flag = new boolean[n][m][1025];

        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (chars[i][j] == '2') {
                    System.out.println(BFSFind(i, j, n, m, chars));

                }
            }
        }
    }

    private static int BFSFind(int i, int j, int n, int m,
                               char[][] chars) {

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(i, j, 0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int k = 0; k < 4; k++) {
                int tempX = node.x + next[k][0];
                int tempY = node.y + next[k][1];
                int key = node.key;
                int temp = node.temp + 1;

                if (tempX < 0 || tempX >= n || tempY < 0 || tempY >= m
                        || chars[tempX][tempY] == '0') {
                    continue;
                }

                if (chars[tempX][tempY] == '3')
                    return temp;

                if (chars[tempX][tempY] <= 'z' && chars[tempX][tempY] >= 'a')
                    key = key | 1 << (chars[tempX][tempY] - 'a');

                if (chars[tempX][tempY] <= 'Z' && chars[tempX][tempY] >= 'A'
                        && (key & (1 << (chars[tempX][tempY] - 'A'))) == 0)
                    continue;

                if (!flag[tempX][tempY][key]) {
                    flag[tempX][tempY][key] = true;
                    queue.offer(new Node(tempX, tempY, key, temp));
                }
            }
        }

        return -1;

    }

    private static class Node {

        int x;
        int y;
        int key;
        int temp;

        public Node(int x, int y, int key, int temp) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.temp = temp;

        }
    }
}
