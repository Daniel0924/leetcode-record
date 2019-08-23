package com.ydh.leetcode.niuke;

import java.util.HashMap;
import java.util.Map;

public class Solution36 {

    public int FirstNotRepeatingChar(String str) {

        Map<Character, Integer> map = new HashMap<>();

        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                map.put(charArray[i], map.get(charArray[i]) + 1);
            } else {
                map.put(charArray[i], 1);
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if (map.get(charArray[i]) == 1) {
                return i;
            }
        }
        return -1;
    }


    public int GetNumberOfK(int[] array, int k) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int len = array.length;
        if (array[0] > k || array[len - 1] < k) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        int index = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (array[mid] == k) {
                index = mid;
                break;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int res = 0;
        if (index >= 0) {
            int tmp = index;
            while (index >= 0 && array[index] == k) {
                index--;
                res++;
            }
            while (tmp < len && array[tmp] == k) {
                tmp++;
                res++;
            }
        }
        System.out.println(res);
        return res > 0 ? res - 1 : res;
    }


    public static void main(String[] args) {
        int[] arr = new int[1];
        arr[0] = 3;

        int k = 3;

        System.out.println(new Solution36().GetNumberOfK(arr, k));


    }
}
