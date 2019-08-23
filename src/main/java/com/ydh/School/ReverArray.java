package com.ydh.School;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverArray {


    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            int len = Integer.parseInt(br.readLine());

            String[] array = br.readLine().split(" ");

            int[] nums = new int[len];

            for (int i = 0; i < len; i++) {
                nums[i] = Integer.parseInt(array[i]);
            }
            System.out.println(reverse(len, nums));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String reverse(int len, int[] nums) {

        int after = 0;
        if (len % 2 != 0) {
            after = 1;
        }

        int before = len - 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(" ");
            if (before >= 0) {
                sb.append(nums[before]);
                before -= 2;

            } else if (after < len) {

                sb.append(nums[after]);
                after += 2;
            }
        }

        return sb.toString().trim();
    }
}
