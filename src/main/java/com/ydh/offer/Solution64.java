package com.ydh.offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution64 {

    public ArrayList<Integer> getmax(int[] nums, int size) {
        ArrayList<Integer> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!list.isEmpty() && list.peek() <= i - size) {
                list.poll();
            }

            while (!list.isEmpty() && nums[list.getLast()] < nums[i]){
                list.removeLast();
            }

            list.offer(nums[i]);

            if (i >= size - 1) {
                res.add(list.peek());
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};

        int size = 3;

        LinkedList<Integer> list = new LinkedList<>();
        list.offer(1);
        list.offer(2);
        System.out.println(list.peek());

    }
}
