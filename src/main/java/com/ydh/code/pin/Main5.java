package com.ydh.code.pin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yang Danhao
 * Main5 2019/9/1 8:14 PM Version 1.0
 */
public class Main5 {

    public static long getRes(Integer[][] nums) {
        Arrays.sort(nums, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return (o2[0] - o2[1]) - (o1[0] - o1[1]);
            }
        });
        int n = nums.length;
        long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            long temp = ((j - 1) * (long) nums[i][0] + (n - j) * (long) nums[i][1]);
            res += temp;
            //res = res % 1000000007;
            if (i % 10 == 0) {
                System.out.println("nums[" + i + "][0]=" +
                        nums[i][0] + ",nums[" + i + "][1]=" + nums[i][1]);
                System.out.println("i = " + i);
                System.out.println("temp:" + temp);
                System.out.println("res:" + res);
                System.out.println("res':" + res);
            }

        }

        return res;
    }

    public static void main(String[] args) {

        Integer[][] cums = new Integer[500][2];
        for (int i = 0; i < 500; i++) {
            cums[i][0] = 90000000;
            cums[i][1] = 80000000;
        }
        System.out.println(getRes(cums));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            Integer[][] nums = new Integer[n][2];

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                nums[i][0] = Integer.parseInt(line[0]);
                nums[i][1] = Integer.parseInt(line[1]);
            }
            System.out.println(getRes(nums));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
