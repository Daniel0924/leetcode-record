package com.ydh.code.kuaishou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {

    public static String[] getRes(String[] s1, String[] s2) {
        if (s1 == null || s1.length == 0) {
            return s2;
        }
        if (s2 == null || s2.length == 0) {
            return s1;
        }

        int len1 = s1.length;
        int len2 = s2.length;
        int len = len1 + len2;

        String[] res = new String[len1 + len2];

        for (int i = 0; i < len; i++) {

        }
        return res;
    }

    public static String getRes(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return s2;
        }
        if (s2 == null || s2.length() == 0) {
            return s1;
        }
        int len1 = s1.length();
        int len2 = s2.length();

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < len1; i += 4) {
            if (i + 4 > len1) {
                sb.append(s1.substring(i));
                if (index < len2) {
                    sb.append(s2.substring(index));
                }
                return sb.toString();
            }

            sb.append(s1.substring(i, i + 4));
            if (index < len2) {
                sb.append(s2.charAt(index));
            } else {
                sb.append(s1.substring(i + 4));
                return sb.toString();
            }
            index++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            String[] line1 = br.readLine().split(" ");
            StringBuilder sb1 = new StringBuilder();
            for (String s : line1) {
                sb1.append(s);
            }
            String[] line2 = br.readLine().split(" ");
            StringBuilder sb2 = new StringBuilder();
            for (String s : line2) {
                sb2.append(s);
            }
            String res = getRes(sb1.toString(), sb2.toString());
            for (char c : res.toCharArray()) {
                System.out.println(c + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
