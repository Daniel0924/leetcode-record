package com.ydh.leetcode.December;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        return new ArrayList<>();
    }

    public List<List<Integer>> thressSum(int[] nums, int target) {

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int begin = i + 1;
            int end = len - 1;
            while (begin < end) {
                int temp = nums[i] + nums[begin] + nums[end];

                if (temp == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[begin]);
                    list.add(nums[end]);

                    res.add(new ArrayList<>(list));
                }

                while (begin < end && nums[begin] == nums[begin + 1]) {
                    begin++;
                }
                while (begin < end && nums[end] == nums[end - 1]) {
                    end--;
                }
                begin++;
                end--;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -4, 1, 1, 1, 2, 3, -4};

        List<List<Integer>> res = new Leet18().thressSum(nums, 0);

        res.forEach(System.out::println);
    }

}
