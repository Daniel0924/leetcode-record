package com.ydh.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main5 {

    public static int[] getRes(int n, int[] nums) {

        boolean hasOdd = false;
        boolean hasEven = false;
        for (int i : nums) {
            if ((i & 1) == 0) {
                hasEven = true;
                System.out.println(i + ",hasEven = true");
            } else {
                hasOdd = true;
                System.out.println(i + ",hasOdd = true");
            }
            if (hasEven && hasOdd) {
                break;
            }
        }
        if (!hasEven || !hasOdd) {
            return nums;
        }

        Arrays.sort(nums);
        return nums;
    }


    public static void main(String[] args) {
        int[] nums2 = {2, 7, 5, 3, 1};
        int[] res2 = getRes(5, nums2);
        for (int i : res2) {
            System.out.print(i + " ");
        }

        int[] nums1 = {53941, 38641, 31525, 75864, 29026, 12199, 83522, 58200, 64784, 80987};

        int[] res1 = getRes(10, nums1);

        for (int i : res1) {
            System.out.print(i + " ");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] nums = new int[n];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }

            int[] res = getRes(n, nums);
            for (int i : res) {
                System.out.print(i + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
