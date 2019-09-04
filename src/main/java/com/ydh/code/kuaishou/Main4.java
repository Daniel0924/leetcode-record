package com.ydh.code.kuaishou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        try {

            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            Map<Integer, Map<Integer, Integer>> red = new HashMap<>();
            Map<Integer, Map<Integer, Integer>> black = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                int[] nums = new int[3];

                nums[0] = Integer.parseInt(line[0]);
                nums[1] = Integer.parseInt(line[1]);
                nums[2] = Integer.parseInt(line[2]);

                if (nums[2] == 0) {
                    // 表示红色，不是好序列
                    if (red.containsKey(nums[0])) {

                        Map<Integer, Integer> map = red.get(nums[0]);
                        map.put(nums[1], 0);
                        red.put(nums[0], map);

                    } else {

                        Map<Integer, Integer> map = new HashMap<>();
                        map.put(nums[1], 0);
                        red.put(nums[0], map);
                    }

                } else {
                    // 表示黑色，是好序列
                    if (black.containsKey(nums[0])) {

                        Map<Integer, Integer> map = black.get(nums[0]);
                        map.put(nums[1], 0);
                        black.put(nums[0], map);

                    } else {

                        Map<Integer, Integer> map = new HashMap<>();
                        map.put(nums[1], 0);
                        black.put(nums[0], map);
                    }
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
