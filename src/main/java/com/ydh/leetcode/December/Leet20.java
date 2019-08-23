package com.ydh.leetcode.December;

import java.util.Stack;

public class Leet20 {
    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char temp = s.charAt(i);
            if ((temp == ')' || temp == ']' || temp == '}')
                    && stack.isEmpty()) {
                return false;
            }


            if (temp == '(' || temp == '[' || temp == '{') {
                stack.push(temp);
            } else {
                if (!match(stack.peek(), s.charAt(i))) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();

    }

    public boolean match(char i, char j) {
        return ((i == '(' && j == ')') ||
                (i == '[' && j == ']') ||
                (i == '{' && j == '}'));

    }

    public static void main(String[] args) {
        String s = "()[]{}";

        System.out.println(new Leet20().isValid(s));
    }
}
