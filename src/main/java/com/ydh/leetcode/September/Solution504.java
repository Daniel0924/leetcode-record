package com.ydh.leetcode.September;

/**
 * @author Yang Danhao
 * Solution504 2019/9/2 3:41 PM Version 1.0
 */
public class Solution504 {


    public String convertToBase7(int num) {
        Integer.toString(4,2);
        if (num == 0) {
            return "" + num;
        }
        String res = "";
        boolean fu = false;
        if (num < 0) {
            num = -num;
            fu = true;
        }
        while (num > 0) {
            int mod = num % 7;
            res = mod + res;
            num /= 7;
        }
        if (fu) {
            res = "-" + res;
        }

        return res;
    }

    public static void main(String[] args) {

        int test = 7;

        System.out.println(new Solution504().convertToBase7(test));
    }
}
