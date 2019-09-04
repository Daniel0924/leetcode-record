package com.ydh.code.settest;

import java.util.Stack;

/**
 * @author Yang Danhao
 * Map 2019/8/28 7:52 PM Version 1.0
 */
public class Map {
    // "abba"  ""
    // "abbba"  "aba"
    public static String getRes(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (!stack.isEmpty()) {
                if (stack.peek() == temp) {
                    stack.pop();
                } else {
                    stack.push(temp);
                }
            } else {
                stack.push(temp);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getRes("abbaaaaacv"));
    }
}
