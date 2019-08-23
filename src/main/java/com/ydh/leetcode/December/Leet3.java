package com.ydh.leetcode.December;

import java.util.HashMap;
import java.util.Map;

public class Leet3 {

    public int lengthOfLongestSubstring(String s) {

        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }

        int len = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int key = map.get(s.charAt(i));

                for (int j = start; j < key; j++) {
                    map.remove(s.charAt(j));
                }
                start = key + 1;
                len = i - key;
            } else {
                map.put(s.charAt(i), i);
                len++;
                if (len > res) {
                    res = len;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {

        System.out.println(new Leet3().lengthOfLongestSubstring("pwwkew"));
    }
}
