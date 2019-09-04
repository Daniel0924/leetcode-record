package com.ydh.code.kuaishou;

import com.ydh.leetcode.tencent.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    Map<Integer, Boolean> res = new HashMap<>();

    public static boolean isOk(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(n, 1);
        while (n != 1) {
            String s = "" + n;
            int tmp = 0;
            for (char c : s.toCharArray()) {
                int nn = c - '0';
                tmp += nn * nn;
            }
            n = tmp;
            if (map.containsKey(n)) {
                return false;
            }
            map.put(n, 1);
        }
        return true;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int m = Integer.parseInt(br.readLine());
            int[] nums = new int[m];
            for (int i = 0; i < m; i++) {
                nums[i] = Integer.parseInt(br.readLine());
            }
            for (int i : nums) {
                System.out.println(isOk(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
