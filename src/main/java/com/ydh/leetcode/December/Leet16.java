package com.ydh.leetcode.December;

import java.util.ArrayList;
import java.util.Arrays;

public class Leet16 {

    public int threeSum(int[] nums, int target) {


        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int len = nums.length;

        int sum = nums[0] + nums[1] + nums[2];
        int distance = Math.abs(sum - target);

        for (int i = 0; i < len; i++) {
            int begin = i + 1;
            int end = len - 1;
            while (begin < end){

                sum = nums[i] = nums[begin] + nums[end];
                if (sum < target){
                    begin++;
                }else if (sum > target){
                    end--;
                }else {
                    return target;
                }

                if (distance > Math.abs(sum - target)){
                    res = sum;
                    distance = Math.abs(sum - target);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -2, -5, 3, -4};

        int target = 1;

        System.out.println(new Leet16().threeSum(nums, target));
    }
}
