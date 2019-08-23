package com.ydh.leetcode.niuke;

public class Solution52 {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || str.length == 0) {
            return false;
        }
        int sLength = str.length;
        int pLength = pattern.length;

        int i = 0;
        int j = 0;
        while (i < sLength) {
            if (str[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (pattern[j] == '*' && j > 0) {
                    if (str[j] == pattern[j - 1]) {

                    }
                }
            }
        }
        return true;
    }
}
