package com.ydh.leetcode.July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();

        if (n == 1) {
            res.add(1);
            return res;
        }

        if (n == 2) {
            return Arrays.asList(edges[0][0], edges[0][1]);
        }

        int[] m = new int[n];

        for(int i=0;i<edges.length;i++){
            m[edges[i][0]]++;
            m[edges[i][1]]++;
        }

        return res;

    }


    public static void main(String[] args) {


    }
}
