package com.ydh.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main5 {


    public static int getMax(int stu, int desk, int[] nums) {
        Arrays.sort(nums);

        int single = desk * 2 - stu;
        int right = nums.length - single;

        System.out.println("right : " + right);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < right / 2; i++) {
            int temp = nums[i] + nums[right - 1 - i];

            System.out.println(temp);
            if (temp > res) {
                res = temp;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        /**
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         try {
         String[] line1 = br.readLine().split(" ");
         int stu = Integer.parseInt(line1[0]);
         int desk = Integer.parseInt(line1[1]);

         String[] numbers = br.readLine().split(" ");
         int[] nums = new int[numbers.length];

         for (int i = 0; i < numbers.length; i++) {
         nums[i] = Integer.parseInt(numbers[i]);
         }
         int res = getMax(stu, desk, nums);
         System.out.println(res);

         } catch (IOException e) {
         e.printStackTrace();
         }
         **/
        int stu = 5;
        int desk = 3;
        int[] nums = {4, 1, 8, 2, 6};

        System.out.println(getMax(stu, desk, nums));
    }
}
