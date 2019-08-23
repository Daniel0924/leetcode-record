package com.ydh.leetcode.July;

import java.io.*;
import java.util.*;

public class Solution491 {


    public static int nameId = 1001;
    public int count = 10;

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        combination(nums, 0, ans, tmp);
        return (new ArrayList(ans));
    }

    public void combination(int[] nums, int start, Set<List<Integer>> ans, List<Integer> tmp) {
        for (int i = start; i < nums.length; ++i) {
            if (tmp.size() == 0 || nums[i] >= tmp.get(tmp.size() - 1)) {
                tmp.add(nums[i]);
                if (tmp.size() >= 2)
                    ans.add(new ArrayList(tmp));
                combination(nums, i + 1, ans, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public int printss() {
        System.out.println(count);
        return count;
    }

    public static int prints() {
        System.out.println(nameId);
        return nameId;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Math.ceil(12.32));
    }
}
