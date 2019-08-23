package com.ydh.leetcode.July;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution473 {

    public boolean maksquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Stack<Integer> stack1 = new Stack<>();

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 4 == 0) {
            return false;
        }
        int length = sum / 4;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > length) {
                return false;
            } else if (nums[i] < length) {
                if (stack1.isEmpty() || (stack1.peek() + nums[i] < length)) {
                    stack1.push(nums[i]);
                }
            }

        }
        return true;
    }


    public static void main(String[] args) {

    }
}
