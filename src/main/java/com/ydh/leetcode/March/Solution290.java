package com.ydh.leetcode.March;

import java.util.HashMap;
import java.util.Map;

public class Solution290 {


    public boolean wordPattern(String pattern, String str) {

        Map<Character, String> map = new HashMap<>();


        String[] array = str.split(" ");
        for (int i = 0; i < pattern.length(); i++) {
            char temp = pattern.charAt(i);
            if (map.containsKey(temp)) {
                if (!array[i].equals(map.get(temp))) {
                    return false;
                }
            } else {
                if(map.containsValue(array[i])){
                    return false;
                }
                map.put(temp, array[i]);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String pattern = "abba";

        String str = "dog cat cat doe";

        System.out.println(new Solution290().wordPattern(pattern, str));
    }
}
