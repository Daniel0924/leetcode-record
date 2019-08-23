package com.ydh.leetcode.test;

import java.util.HashMap;
import java.util.Scanner;

public class DeleteDuplicateString {


    public static String getRes(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {

            if (!map.containsKey(c)) {
                map.put(c, 1);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        System.out.println(getRes(s));
    }
}
