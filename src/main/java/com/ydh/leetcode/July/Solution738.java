package com.ydh.leetcode.July;

public class Solution738 {


    public int monotoneIncreasingDigits(int N) {
        int res = helper(N);
        while (!isGood(res)) {
            res = helper(res);
        }
        return res;
    }

    public boolean isGood(int N) {
        String s = N + "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }


    public int helper(int N) {
        String s = "0" + N;

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println("c:" + c);
            if (i < s.length() - 1 && c >= s.charAt(i - 1) && c > s.charAt(i + 1)) {
                sb.append((char) (s.charAt(i) - 1));
                System.out.println("append:" + (char) (s.charAt(i) - 1));
                index = s.length() - i;
                break;
            }
            sb.append(c);
        }

        while (index > 1) {
            index--;
            sb.append("9");
        }

        System.out.println(sb.toString());
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution738().monotoneIncreasingDigits(99998));
    }
}
