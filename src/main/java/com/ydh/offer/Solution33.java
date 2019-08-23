package com.ydh.offer;

import java.util.Map;

public class Solution33 {

    public int GetUglyNumber_Solution(int index) {

        int count = 0;

        for (int i = 1; i < Integer.MAX_VALUE; i++){

            if (isUglyNumber(i)){
                System.out.println();
                count++;
            }
            if (index == count){
                return i;
            }

        }
        return -1;
    }

    public boolean isUglyNumber(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }

    public static void main(String[] args) {
        int num = 10002;

        System.out.println(new Solution33().isUglyNumber(num));

        System.out.println(new Solution33().GetUglyNumber_Solution(1000));

    }
}
