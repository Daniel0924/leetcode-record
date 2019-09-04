package com.ydh.code.pin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Yang Danhao
 * Main8 2019/9/1 9:29 PM Version 1.0
 */

public class Main8 {

    public static long getRes(int[] score, int day) {
        long res = 0L;

        for (int i = 0; i < day; i++) {

            int min = score[i];
            int sum = 0;

            for (int j = i; j < day; j++) {
                min = Math.min(min, score[j]);
                sum = sum + score[j];
                long temp = (long) min * (long) sum;
                if (temp > res) {
                    res = temp;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] scores = {7, 2, 4, 6, 5};
        int d = 5;
        System.out.println(getRes(scores, d));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int day = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] score = new int[day];
            for (int i = 0; i < day; i++) {
                score[i] = Integer.parseInt(line[i]);
            }
            System.out.println(getRes(score, day));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
