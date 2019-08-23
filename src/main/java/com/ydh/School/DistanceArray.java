package com.ydh.School;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistanceArray {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            char[] chars = br.readLine().toCharArray();

            int[] nums = new int[chars.length];

            for (int i = 0; i < chars.length; i++) {
                nums[i] = chars[i] - '0';
            }


            System.out.println(maxLength(nums));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int maxLength(int[] s) {

        if (s == null || s.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;

        int res = 1;

        for (int i = 1; i < s.length; i++) {
            if (s[i] == s[i - 1]) {
                right++;

                left = right;
            } else {

                right++;

                if ((right - left) > res) {
                    res = right - left;
                }
            }

        }
        return res;

    }
}
