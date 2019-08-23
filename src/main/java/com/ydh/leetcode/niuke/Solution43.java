package com.ydh.leetcode.niuke;

public class Solution43 {

    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n < 1) {
            return str;
        }

        n %= str.length();
        String s1 = str.substring(0, n);
        String s2 = str.substring(n);
        return s2 + s1;


    }

    public static void main(String[] args) {
        String s = "12345";
        System.out.println(new Solution43().LeftRotateString(s, 2));


        String name = "yangdanhao";
        System.out.println(name.replaceAll("n","a"));


    }
}
