package com.ydh.leetcode.niuke;

import java.util.HashMap;
import java.util.Map;

public class Solution28 {


    public int MoreThanHalfNum_Solution(int[] array) {

        Map<Integer, Integer> resultMap = new HashMap<>();
        if (array == null || array.length == 0) {
            return 0;
        }
        int res = array[0];
        int n = 1;
        resultMap.put(res, n);
        for (int i = 1; i < array.length; i++) {
            if (!resultMap.containsKey(array[i])) {
                resultMap.put(array[i], 1);
            } else {
                resultMap.replace(array[i], resultMap.get(array[i]) + 1);
            }
            if (array[i] == res) {
                n++;
            } else {
                n--;
            }
            if (n < 0) {
                res = array[i];
                n = resultMap.get(res);
            }
        }

        return resultMap.get(res) > array.length / 2 ? res : 0;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.replace(1, 2);
        System.out.println(map.get(1));


    }
}
