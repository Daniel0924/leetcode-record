package com.ydh.leetcode.September;

public class Solution344 {

    public String reverseString(String s) {
        StringBuffer sb = new StringBuffer();

        if (s == null || s.length() == 0) {
            return s;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public String reverseString2(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[len - 1 - i];
            chars[len - 1 - i] = temp;
        }
        return new String(chars);
    }


    public static void main(String[] args) {

        int i = 100;
        int j = i >> 1;
        System.out.println();
    }
}
