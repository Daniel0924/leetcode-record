package com.ydh.acm.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yang Danhao
 * fullSort 2019/9/5 10:31 AM Version 1.0
 */
public class FullSort {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int k = Integer.parseInt(line[2]);

            int[] nums = new int[n + m];
            for (int i = 0; i < n; i++) {
                nums[i] = 0;
            }
            for (int i = n; i < nums.length; i++) {
                nums[i] = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
