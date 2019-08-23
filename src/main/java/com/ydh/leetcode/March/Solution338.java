package com.ydh.leetcode.March;

public class Solution338 {


    public int[] countBits(int num) {

        if (num <= 0) {
            return new int[0];
        }

        if (num == 1) {
            int[] res = {0, 1};
            return res;
        }
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= num; i++) {
            if (i % 2 == 1) {
                res[i] = res[i - 1] + 1;
            }else {
                res[i] = res[i / 2];
            }
        }
        return res;

    }

    public static void main(String[] args) {


    }
}
