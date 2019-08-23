package com.ydh.leetcode.July;

public class Solution482 {
    public static String licenseKeyFormatting(String S, int K) {

        String[] strs = S.split("-");
        if (strs.length == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (String s : strs) {

            sb.append(s.toUpperCase());
        }

        String news = sb.toString();

        sb = new StringBuilder();

        int index = news.length() % K;
        if (index > 0) {
            sb.append(news.substring(0, index) + "-");
        }
        for (int i = index; i < news.length(); i += K) {
            sb.append(news.substring(i, i + K) + "-");
        }

        String res = sb.toString();
        res = res.substring(0, res.length() - 1);
        return res;
    }


    public static void main(String[] args) {

        String s = "2-5g-3-J";
        int k = 2;
        System.out.println(licenseKeyFormatting(s, k));


        String[] ss = "---".split("-");
        System.out.println(ss.length);

    }
}
