package com.ydh.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main7 {

    public static long getRes(int[] nums, int n) {

        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            if (nums[0] == nums[1]) {
                return nums[0];
            } else {
                return 0;
            }
        }

        long res = 0;

        int left = 0;
        int leftSum = 0;

        int right = n - 1;
        int rightSum = 0;

        while (left < right) {
            if (leftSum == rightSum) {
                if (res < leftSum) {
                    res = leftSum;
                }
                leftSum += nums[left];
                left++;
                System.out.println("1 left:" + left);

            } else if (leftSum < rightSum) {
                leftSum += nums[left];
                left++;
                System.out.println("2 left:" + left);
            } else {
                rightSum += nums[right];
                right--;
                System.out.println("3 right:" + right);

            }
        }
        System.out.println("leftSum:" + leftSum + ", rightSum:" + rightSum);
        System.out.println(Math.abs(leftSum - rightSum));
        if (Math.abs(leftSum - rightSum) == nums[left]) {
            res = Math.max(leftSum, rightSum);
        }

        return res;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());

            String[] s = br.readLine().split(" ");
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }

            System.out.println(getRes(nums, n));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
