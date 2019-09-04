package com.ydh.code.jingdong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public int getRes(int[][] nums) {
        return 0;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int[][] nums = new int[5][5];
            for (int i = 0; i < 5; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 5; j++) {
                    nums[i][j] = Integer.parseInt(line[j]);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
