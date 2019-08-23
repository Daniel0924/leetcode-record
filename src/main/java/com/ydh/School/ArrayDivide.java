package com.ydh.School;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayDivide {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            int num = Integer.parseInt(br.readLine());

            String[] s = br.readLine().split(" ");
            int[] nums = new int[num];

            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            if (isDividedArray(nums)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean isDividedArray(int[] s) {

        if (s == null || s.length < 3) {
            return true;
        }
        Arrays.sort(s);
        int div = s[1] - s[0];
        for (int i = 2; i < s.length; i++) {
            if (s[i] - s[i - 1] != div) {
                return false;
            }
        }
        return true;
    }


}
