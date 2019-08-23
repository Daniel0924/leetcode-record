package com.ydh.leetcode.December;

public class Leet28 {


    public int strStr(String haystack, String needle) {

        int len = haystack.length();
        int size = needle.length();

        for (int i = 0; i <= len - size; i++) {
            String temp = haystack.substring(i, i + size);

            if(temp.equals(needle)){
                return i;
            }

        }
        return -1;
    }
}
