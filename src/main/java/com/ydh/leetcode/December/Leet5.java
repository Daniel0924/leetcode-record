package com.ydh.leetcode.December;

public class Leet5 {

    public String longestpalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLen = 0;
        String res = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            String temp = helper(s, i, i);

            if (temp.length() > res.length()) {
                res = temp;
            }

            temp = helper(s, i, i + 1);
            if (temp.length() > res.length()) {
                res = temp;
            }

        }
        return res;
    }


    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public static void main(String[] args) {
        String s = "abbba";


    }
}
