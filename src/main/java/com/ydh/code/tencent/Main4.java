package com.ydh.code.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main4 {

    public static int getMin2(int n, int m, int[] nums) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                linkedList = new LinkedList<>();
            }

            linkedList.add(nums[i]);
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], nums[i]);
            } else if (linkedList.getLast() == nums[i]){
                linkedList.removeLast();
            }

            if (map.size() == m) {
                if (linkedList.size() < result) {
                    result = linkedList.size();
                    linkedList = new LinkedList<>();
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;

    }


    public static int getMin(int n, int m, int[] nums) {
        if (n < m) {
            return -1;
        }

        boolean[] isFinished = new boolean[n - m];
        int[] dp = new int[n - m];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < (n - m); i++) {
            Map<Integer, Integer> map = new HashMap<>();

            if (nums[i] == 0) {
                continue;
            }
            for (int j = i; j < n; j++) {

                if (nums[j] == 0) {
                    isFinished[i] = false;
                    map.clear();
                    dp[i] = 0;
                    continue;
                }

                if (!map.containsKey(nums[j])) {
                    map.put(nums[j], nums[j]);
                    System.out.println("put:" + nums[j]);
                }

                dp[i]++;
                if (map.size() == m) {
                    isFinished[i] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < n - m; i++) {
            System.out.print(isFinished[i]);
            System.out.println(dp[i]);
        }

        for (int i = 0; i < (n - m); i++) {
            if (isFinished[i]) {
                if (dp[i] < res) {
                    res = dp[i];
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int n1 = 12;
        int m1 = 5;
        int[] nn = {2, 5, 3, 1, 3, 2, 4, 1, 0, 5, 4, 3};
        System.out.println(getMin2(n1, m1, nn));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] array = br.readLine().split(" ");
            int n = Integer.parseInt(array[0]);  //n枪

            int m = Integer.parseInt(array[1]);

            String[] numString = br.readLine().split(" ");
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(numString[i]);
            }
            System.out.println(getMin(n, m, nums));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
