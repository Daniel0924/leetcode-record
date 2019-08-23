package com.ydh.leetcode.niuke;

import java.util.LinkedList;
import java.util.List;

public class Solution22 {

    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        LinkedList<Integer> odd = new LinkedList<>();
        LinkedList<Integer> even = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                odd.offer(array[i]);
            } else {
                even.offer(array[i]);
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (!odd.isEmpty()) {
                array[i] = odd.poll();
            } else {
                array[i] = even.poll();
            }
        }
    }

}
