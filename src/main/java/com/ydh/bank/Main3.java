package com.ydh.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main3 {

    public static double[] getRes(int n, int[] scores, int times, int[] index) {

        // 得到这些人对应的分数
        int[] numbers = new int[times];

        for (int i = 0; i < times; i++) {
            numbers[i] = scores[index[i] - 1];
        }

        // 得到每个分数对应是第几名,键是分数，值是不超过这个分数的人数
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(scores);

        for (int i = n - 1; i >= 0; i--) {
            if (!map.containsKey(scores[i])) {

                map.put(scores[i], i);
            }
        }
        double[] res = new double[times];
        for (int i = 0; i < times; i++) {
            res[i] = (double) map.get(numbers[i]) / n * 100;
        }
        return res;

    }

    public static void main(String[] args) {

        int n1 = 3;
        int[] scores1 = {100, 100, 87};
        int times1 = 3;
        int[] index1 = {1, 2, 3};

        double[] res1 = getRes(n1, scores1, times1, index1);

        for (double d : res1) {
            System.out.print(" " + d);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());

            String[] s2 = br.readLine().split(" ");

            int[] scores = new int[n];
            for (int i = 0; i < n; i++) {
                scores[i] = Integer.parseInt(s2[i]);
            }
            int times = Integer.parseInt(br.readLine());
            int[] index = new int[times];
            for (int i = 0; i < times; i++) {
                index[i] = Integer.parseInt(br.readLine());
            }

            double[] res = getRes(n, scores, times, index);

            for (double item : res) {
                System.out.println(String.format("%.6f", item));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
