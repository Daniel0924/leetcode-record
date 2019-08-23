package com.ydh.leetcode.tencent;

import java.util.Stack;

public class ReverseString {

    public static String reverse(String s) {

        String[] array = s.split(" ");

        Stack<String> stack = new Stack<>();

        for (String tmp : array) {
            stack.push(tmp);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = res + " " + stack.pop();
        }
        return res.trim();
    }

    public static void main(String[] args) {
        String s = "ab cd ef";

        System.out.println(reverse(s));
    }

}
