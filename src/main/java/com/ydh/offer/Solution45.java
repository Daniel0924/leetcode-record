package com.ydh.offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution45 {

    public static boolean isContinues(int[] numbers) {
        int king = 0;
        Arrays.sort(numbers);
        if (numbers[0] == 0) {
            king++;
        }
        if (numbers[1] == 0) {
            king++;
        }
        if (numbers[2] == 0) {
            king++;
        }
        if (numbers[3] == 0) {
            king++;
        }
        int dev = 0;
        for (int i = king; i < 4; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return false;
            } else {
                dev += (numbers[i + 1] - numbers[i]);

            }
        }
        if (dev >= 5) {
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {

        int[] num = {6, 7, 8, 9, 10};

        System.out.println(isContinues(num));

    }
}
