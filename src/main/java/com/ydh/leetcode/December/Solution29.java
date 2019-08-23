package com.ydh.leetcode.December;

public class Solution29 {


    public int divide(int divided, int divisor) {

        long a = Math.abs((long) divided);
        long b = Math.abs((long) divisor);

        int res = 0;
        long sum = 0;
        long pow = 0;
        while (a >= b){
            pow = 1;
            sum = b;
            while (sum + sum <= a){
                sum += sum;
                pow += pow;
            }
            a -= sum;
            res += pow;

        }

        return res;
    }
}
