package com.ydh.leetcode.May;

public class Solution415 {


    public String addStrings(String num1, String num2) {

        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        int len = Math.max(num1.length(), num2.length());
        int[] res = new int[len + 1];

        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        while (index1 >= 0 && index2 >= 0) {
            int temp = (num1.charAt(index1) - '0') + (num2.charAt(index2) - '0');
            System.out.println("temp:" + temp);
            if (temp >= 10) {
                res[len - 1]++;
                temp %= 10;
            }
            res[len] += temp;
            if (res[len] >= 10) {
                res[len - 1]++;
                res[len] %= 10;
            }

            for (int i : res) {
                System.out.print(i + ",");
            }

            index1--;
            index2--;
            len--;
        }
        while (index1 >= 0) {
            res[len] += num1.charAt(index1) - '0';
            if (res[len] >= 10) {
                res[len - 1]++;
                res[len] %= 10;
            }
            len--;
            index1--;
        }
        while (index2 >= 0) {
            res[len] += num2.charAt(index2) - '0';
            if (res[len] >= 10) {
                res[len - 1]++;
                res[len] %= 10;
            }
            len--;
            index2--;
        }


        StringBuilder sb = new StringBuilder();
        for (int c : res) {
            System.out.println("c : " + c);
            sb.append(c);
        }

        String result = sb.toString();
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) > '0') {
                return result.substring(i);
            }
        }
        return "0";

    }


    public static void main(String[] args) {

        String num1 = "6994";
        String num2 = "36";

        System.out.println(new Solution415().addStrings(num1, num2));

        System.out.println("abc".substring(1));
    }
}
