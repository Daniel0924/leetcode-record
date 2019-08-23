package com.ydh.leetcode.December;

public class Leet8 {


    public int myAtoi(String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            }

            if (str.charAt(i) == '.') {
                break;
            }
            if (str.charAt(i) == '-' && sb.length() == 0) {
                sb.append('-');
            }

            if (str.charAt(i) != '-' && (str.charAt(i) < 48
                    || str.charAt(i) > 57) && sb.length() == 0) {
                return 0;
            }
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                sb.append(str.charAt(i));
            }


        }
        int res = 0;
        System.out.println(sb.toString());

        try {
            String string = sb.toString();
            if (string.length() == 0){
                return 0;
            }
            res = Integer.parseInt(sb.toString());
        } catch (NumberFormatException num) {
            res = -2147483648;
        }


        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Leet8().myAtoi(".987"));
    }
}
