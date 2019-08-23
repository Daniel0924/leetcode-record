package com.ydh.leetcode.niuke;

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution27 {

    public ArrayList<String> premutation(String str) {

        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] charArray = str.toCharArray();

        TreeSet<String> tempRes = new TreeSet<>();

        helper(charArray, tempRes, 0);

        res.addAll(tempRes);
        return res;
    }

    private void helper(char[] charArray, TreeSet<String> tempRes, int loc) {
        if (charArray == null || charArray.length == 0 || loc < 0 || loc > charArray.length - 1) {
            return;
        }
        for (char t : charArray) {
            System.out.print(t);
        }
        System.out.println("");
        if (loc == charArray.length - 1) {
            tempRes.add(String.valueOf(charArray));
        } else {
            for (int i = loc; i < charArray.length; i++) {
                swap(charArray, i, loc);
                helper(charArray, tempRes, loc + 1);
                swap(charArray, i, loc);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


    public static void main(String[] args){
        String s = "abc";

        Solution27 solution = new Solution27();
        ArrayList<String> res = solution.premutation(s);
        System.out.println("result is : ");
        res.forEach(System.out::println);

    }

}
