package com.ydh.leetcode.November;

import javax.lang.model.element.Element;
import java.util.*;

public class Solution349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new TreeSet<>();
        for (int temp : nums1) {
            set1.add(temp);
        }

        for (int temp : nums2) {
            set2.add(temp);
        }

        List<Integer> list = new ArrayList<>();
        for (int temp : set1) {
            if (set2.contains(temp)) {
                list.add(temp);
            }
        }
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 3, 3, 4, 5};
        int[] nums2 = {3, 3, 4, 4, 5, 6, 7};

        int[] res = new Solution349().intersection(nums1, nums2);

        for (int i : res) {
            System.out.println(i);
        }
    }


}
