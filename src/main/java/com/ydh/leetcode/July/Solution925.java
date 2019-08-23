package com.ydh.leetcode.July;

public class Solution925 {

    public boolean isLongPressedName(String name, String typed) {

        if (name == null || typed == null || name.length() > typed.length()) {
            return false;
        }
        int index = 0;
        for (int i = 0; i < name.length(); i++) {
            System.out.printf("i = %d, index = %d\n", i, index);
            char c = name.charAt(i);
            if (c == typed.charAt(index)) {
                index++;

            } else {
                if (index == 0) {
                    return false;
                } else {
                    char temp = typed.charAt(index - 1);
                    while (index < typed.length() && typed.charAt(index) == temp) {
                        index++;
                    }
                    if (index == typed.length()) {
                        return false;
                    }
                    if (index < typed.length() && c != typed.charAt(index)) {
                        return false;
                    }
                    index++;
                    System.out.printf("index = %d\n", index);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s1 = "alex";
        String s2 = "aaleex";

        System.out.println(new Solution925().isLongPressedName(s1, s2));
    }
}
