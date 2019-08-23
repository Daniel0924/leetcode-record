package com.ydh.leetcode.February;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution187 {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);

            if (map.containsKey(temp)) {
                if (map.get(temp) == 1) {
                    map.replace(temp, -1);
                    res.add(temp);
                }
            } else {
                map.put(temp, 1);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        System.out.println(new Solution187().findRepeatedDnaSequences(s));
    }

}
