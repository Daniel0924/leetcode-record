package com.ydh.leetcode.March;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s1 = "aaabbc";
        String s2 = "abcaba";

        System.out.println(new Solution242().isAnagram(s1, s2));
    }

}
