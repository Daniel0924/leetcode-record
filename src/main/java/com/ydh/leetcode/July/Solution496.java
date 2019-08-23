package com.ydh.leetcode.July;

import java.util.HashMap;
import java.util.Map;

public class Solution496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return nums1;
        }
        Map<Integer, Integer> location = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            location.put(nums2[i], i);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = location.get(nums1[i]); j < nums2.length; j++) {
                System.out.printf("nums1[%d] = %d, nums2[%d] = %d\n", i, nums1[i], j, nums2[j]);
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] res = new Solution496().nextGreaterElement(nums1, nums2);
        for (int item : res) {
            System.out.printf("%d,", item);
        }
    }
}
