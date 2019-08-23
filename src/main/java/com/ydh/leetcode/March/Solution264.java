package com.ydh.leetcode.March;

public class Solution264 {

    public int nthUglyNumber(int n) {
        if (n < 5) {
            return n;
        }
        int[] res = new int[n];
        res[0] = 1;

        int count = 0;
        int temp = 1;
        int two = 0;
        int three = 0;
        int five = 0;
        while (count < n - 1) {
            temp = Math.min(res[two] * 2,
                    Math.min(res[three] * 3, res[five] * 5));
            if (temp == res[two] * 2) {
                two++;
            }
            if (temp == res[three] * 3) {
                three++;
            }
            if (temp == res[five] * 5) {
                five++;
            }
            count++;
            res[count] = temp;
        }
        return res[n - 1];
    }

    public static void main(String[] args) {

        System.out.println(new Solution264().nthUglyNumber(11));

    }
}
