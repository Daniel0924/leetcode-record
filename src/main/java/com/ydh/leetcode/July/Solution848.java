package com.ydh.leetcode.July;

public class Solution848 {

    public String shiftingLetters(String s, int[] shifts) {
        if (s == null || s.length() == 0 || shifts == null || shifts.length == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            chars = shift(chars, shifts[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();

    }

    public char[] shift(char[] chars, int n, int end) {
        for (int i = 0; i <= end; i++) {
            chars[i] += (n % 26);
            if (chars[i] > 'z') {
                chars[i] -= 26;
            }
        }
        return chars;
    }

    public static void main(String[] args) {

        String s = "abc";
        int[] shifts = {3, 5, 9};
        char[] chars = s.toCharArray();

        System.out.println(new Solution848().shiftingLetters(s, shifts));
    }
}
