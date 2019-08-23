package com.ydh.leetcode.December;

public class Leet7 {

    public int reverse(int x) {

        int res = 0;
        boolean isFu = (x > 0);
        if (x < 0) {
            x = -x;
        }

        while (x > 0) {
            int temp = res * 10 + x % 10;

            if (res != temp / 10) {
                return 0;
            }else {
                res = temp;
            }
            x = x / 10;
        }

        if (isFu){
            return res;
        }else {
            return res * -1;
        }
    }

    public static void main(String[] args) {

        System.out.println(new Leet7().reverse(-123));

        System.out.println(Integer.MAX_VALUE);


    }
}
