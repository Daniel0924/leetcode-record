package com.ydh.leetcode.March;

import java.util.*;

public class Ali {


    public int[] getNewNums(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > k && !list.contains(nums[i])) {
                    list.add(nums[i]);
                }
            } else {
                map.put(nums[i], 1);
            }
        }

        list.sort((a, b) -> (map.get(b) - map.get(a)));

        int[] ress = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ress[i] = list.get(i);
        }

        /**
         Integer[] res = new Integer[list.size()];
         for (int i = 0; i < list.size(); i++) {
         res[i] = list.get(i);
         }


         Arrays.sort(res, new Comparator<Integer>() {
        @Override public int compare(Integer o1, Integer o2) {
        return map.get(o2).compareTo(map.get(o1));
        }
        });

         int[] ress = new int[res.length];
         for (int i = 0; i < ress.length; i++) {
         ress[i] = res[i];
         }
         **/
        return ress;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 7, 7, 8, 8, 8, 8, 8};

        int k = 2;
        int[] res = new Ali().getNewNums(nums, k);

        for (int i : res) {
            System.out.println(i);
        }

        /*
        int[] nums = new int[10000];

        for (int i = 0; i < nums.length; i++){
            if(i < 100){
                nums[i] = 1000;
            }else if (i < 500){
                nums[i] = 300;
            }else {
                nums[i] = 100;
            }
        }
        int[] res = new Ali().getNewNums(nums, 3);

        for (int i : res) {
            System.out.println(i);
        }
        */



    }
}
