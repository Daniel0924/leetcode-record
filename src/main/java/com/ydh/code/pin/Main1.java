package com.ydh.code.pin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Yang Danhao
 * Main1 2019/9/1 2:56 PM Version 1.0
 */
public class Main1 {

    public static int[] getRes(int[] nums, int n) {

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int i : nums) {
            if ((i & 1) == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }

        Collections.sort(odd, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Collections.sort(even, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int[] res = new int[n];
        int evennum = even.size();
        int oddnum = odd.size();
        if (evennum >= n) {
            for (int i = 0; i < n; i++) {
                res[i] = even.get(i);
            }
        } else {
            for (int i = 0; i < evennum; i++) {
                res[i] = even.get(i);
            }
            for (int j = evennum; j < n; j++) {
                res[j] = odd.get(j - evennum);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String s = "555503,772867,756893,339138,399447,40662,859037,628085,855723,974471,599631,636153,581541,174761,948135,411485,554033,858627,402833,546467,574367,360461,566480,755523,222921,164287,420256,40043,977167,543295,944841,917125,331763,188173,353275,175757,950417,284578,617621,546561,913416,258741,260569,630583,252845";

        int numt = 10;
        String[] ss = s.split(",");
        int[] numss = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            numss[i] = Integer.parseInt(ss[i]);
        }
        int[] gett = getRes(numss, numt);
        for (int i : gett) {
            System.out.println(i);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] line = br.readLine().split(";");
            String[] nums = line[0].split(",");
            int n = Integer.parseInt(line[1]);

            int[] data = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = Integer.parseInt(nums[i]);
            }
            int[] res = getRes(data, n);

            for (int i = 0; i < n - 1; i++) {
                System.out.print(res[i] + ",");
            }
            System.out.print(res[n - 1]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
