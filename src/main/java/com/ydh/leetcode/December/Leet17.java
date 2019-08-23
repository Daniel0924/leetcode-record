package com.ydh.leetcode.December;

import java.util.ArrayList;
import java.util.List;

public class Leet17 {

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, res, map, 0, "");

        return res;
    }


    public void helper(String digits, List<String> res, String[] map, int level, String out) {
        if (level == digits.length()) {                  //level表示现在进行到了第几个字母
            res.add(out);
            return;
        }

        String temp = map[digits.charAt(level) - '0'];   //表示现在当前的数字对应的那几个字母

        for (int i = 0; i < temp.length(); i++) {        //遍历这些字母
            helper(digits, res, map, level + 1, out + temp.charAt(i));
        }
    }


    public static void main(String[] args) {

        System.out.println(new Leet17().letterCombinations("23"));

    }
}

