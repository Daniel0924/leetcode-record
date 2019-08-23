package com.ydh.leetcode.November;

import java.util.ArrayList;
import java.util.List;

public class Solution47 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();

        helper(result, nums, new ArrayList<>(), 0, new int[nums.length]);
        return result;
    }

    public static void helper(List<List<Integer>> result, int[] nums, List<Integer> list, int num, int[] pos) {
        if (num == nums.length) {
            result.add(new ArrayList<>(list));
            for (int item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (pos[i] == 0) {
                list.add(nums[i]);
                pos[i] = 1;
                helper(result, nums, list, num + 1, pos);
                pos[i] = 0;
                list.remove(num);
                System.out.println("remove : " + num);
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        permuteUnique(nums);
    }
}
