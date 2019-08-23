package com.ydh.leetcode.niuke;

import java.util.Arrays;

public class Solution45 {

    public boolean isContinous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int king = 0;
        if (numbers[0] == 0) {
            king++;
        }
        if (numbers[1] == 0) {
            king++;
        }
        int hole = 0;

        for (int i = king; i < 4; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            hole += numbers[i + 1] - numbers[i];
        }
        if (hole > 5){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args){
        int[] numbers = {1,2,3,0,0};

    }

}
