package com.ydh.leetcode.December;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet15 {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;

        int begin;
        int end;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            begin = i + 1;
            end = len - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];

                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[begin]);
                    temp.add(nums[end]);

                    res.add(temp);
                }

                while (begin < end && nums[begin] == nums[begin + 1]) {
                    begin++;
                }
                while (begin < end && nums[end] == nums[end - 1]) {
                    end--;
                }
            }

            while (i <= len - 3 && nums[i] == nums[i + 1]) {
                i++;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,-1,0};

    }
}
