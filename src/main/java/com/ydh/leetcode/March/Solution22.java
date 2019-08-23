package com.ydh.leetcode.March;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    public List<String> generate(int n) {

        List<String> res = new ArrayList<>();

        helper(res, n, n, "");
        return res;
    }

    public void helper(List<String> list, int left, int right,
                       String temp) {

        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            list.add(temp);
        }


        if (left > 0) {
            helper(list, left - 1, right, temp + "(");

        }

        if (right > 0) {
            helper(list, left, right - 1, temp + ")");
        }
    }


    public static void main(String[] args) {
        List<String> res = new Solution22().generate(3);
        res.forEach(System.out::println);
    }

}
