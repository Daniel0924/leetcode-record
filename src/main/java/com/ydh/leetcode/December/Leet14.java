package com.ydh.leetcode.December;

public class Leet14 {

    public String longestCommenPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {     //表示进行到了第几个字母

            char temp = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {      //表示进行到了第几个单词

                if (strs[j].length() > i) {
                    if (strs[j].charAt(i) != temp) {
                        return strs[0].substring(0, i);
                    }
                } else {
                    return strs[0].substring(0, i);
                }

            }

        }


        return strs[0];

    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "fl"};

        System.out.println(new Leet14().longestCommenPrefix(strs));
    }
}
