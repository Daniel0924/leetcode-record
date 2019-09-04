package com.ydh.code.kuaishou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    public static boolean isOk(String olds, String news) {

        if (olds == null || news == null ||
                olds.length() == 0 || news.length() == 0) {
            return false;
        }
        String[] oldarray = olds.split("\\.");
        String[] newarray = news.split("\\.");

        int len1 = oldarray.length;
        int len2 = newarray.length;

        int len = len1 > len2 ? len1 : len2;
        int[] array1 = new int[len];
        int[] array2 = new int[len];

        for (int i = 0; i < len1; i++) {
            array1[i] = Integer.parseInt(oldarray[i]);
        }

        for (int i = 0; i < len2; i++) {
            array2[i] = Integer.parseInt(newarray[i]);
        }
        if (len1 < len2) {
            for (int i = len1; i < len; i++) {
                array1[i] = 0;
            }
        } else {
            for (int i = len2; i < len; i++) {
                array2[i] = 0;
            }
        }

        for (int i = 0; i < len; i++) {
            if (array1[i] > array2[i]) {
                return false;
            }
            if (array1[i] < array2[i]) {
                return true;
            }
        }
        if (array1[len - 1] == array2[len - 1]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int m = Integer.parseInt(br.readLine());
            String[][] nums = new String[m][2];

            for (int i = 0; i < m; i++) {
                String[] tmp = br.readLine().split(" ");
                nums[i][0] = tmp[0];
                nums[i][1] = tmp[1];
            }

            for (String[] s : nums) {
                System.out.println(isOk(s[0], s[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
