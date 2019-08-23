package com.ydh.offer;

import java.util.ArrayList;

public class Solution41 {


    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int start = 1;
        int end = 2;

        while (start < sum / 2 + 1) {
            int total = total(start, end);

            if (total == sum) {

                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    temp.add(i);
                }
                res.add(new ArrayList<>(temp));
                start++;
                end++;

            } else if (total < sum) {
                end++;
            } else {
                start++;
            }
        }
        return res;
    }

    public static int total(int a, int b) {
        return (a + b) * (b - a + 1) / 2;
    }

    public static void main(String[] args) {

        int sum = 15;

        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(sum);

        for (ArrayList list : res) {
            list.forEach(System.out::print);
            System.out.println();
        }
    }
}
