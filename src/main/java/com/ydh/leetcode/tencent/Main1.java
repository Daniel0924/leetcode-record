package com.ydh.leetcode.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1 {

    public static String getRes(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }
        s = transform(s);

        System.out.println("transform:" + s);
        Stack<String> stack = new Stack<>();
        Stack<Integer> nums = new Stack<>();

        String res = "";
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');

            } else if (Character.isLetter(c)) {
                res += c;
            } else if (c == '[') {
                stack.push(res);
                nums.push(num);
                res = "";
                num = 0;
            } else {
                int index = nums.pop();
                String item = "";
                for (int j = 0; j < index; j++) {
                    item += res;
                }
                res = stack.pop() + item;
            }
        }

        return res;
    }

    public static String transform(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                continue;
            }
            if (s.charAt(i) == '|') {
                sb.append('[');
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String test = "HG[3|B[2|CA]]F";
        System.out.println(transform(test));

        System.out.println(getRes(test));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String s = br.readLine();

            System.out.println(getRes(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
