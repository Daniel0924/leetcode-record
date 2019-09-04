package com.ydh.leetcode.September;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yang Danhao
 * Solution500 2019/9/2 3:19 PM Version 1.0
 */
public class Solution500 {

    public String[] findWords(String[] words) {

        if (words == null || words.length == 0) {
            return words;
        }
        List<String> list = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();

        String[] s = {"qwertyuiopQWERTYUIOP",
                "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};

        for (int i = 0; i < 3; i++) {
            String t = s[i];
            for (char c : t.toCharArray()) {
                map.put(c, i);
            }
        }

        for (String word : words) {
            boolean ok = true;
            int index = map.get(word.charAt(0));
            for (char c : word.toCharArray()) {
                if (index != map.get(c)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                list.add(word);
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


}
