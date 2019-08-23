package com.ydh.leetcode.niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution63 {

    List<Integer> list = new LinkedList<>();

    public void Insert(Integer num) {
        System.out.println(list);
        int left = 0;
        int right = list.size();
        if (right == 0) {
            list.add(num);
            return;
        }

        if (num <= list.get(0)) {
            list.add(0, num);
            return;
        }
        if (num >= list.get(list.size() - 1)) {
            list.add(list.size(), num);
            return;
        }

        while (left <= right) {
            int mid = (right - left) / 2;

            if (list.get(mid).equals(num)) {
                list.add(mid, num);
                return;
            }

            if (list.get(mid) > num) {
                if (mid > 0 && list.get(mid - 1) <= num) {
                    list.add(mid, num);
                    return;
                } else {
                    right = mid - 1;

                }
            }
            if (list.get(mid) < num) {
                if (list.get(mid + 1) >= num) {
                    list.add(mid + 1, num);
                    return;
                } else {
                    left = mid + 1;
                }
            }
        }
    }

    public List<Integer> showContent() {
        return list;
    }


    public Double GetMedian() {

        int number = list.size();
        if ((number & 1) != 0) {
            return 0.0 + list.get(list.size() / 2);
        } else {
            return (list.get(number >> 1) * 1.0 + list.get((number >> 1) - 1)) / 2;
        }
    }

    public static void main(String[] args) {

        Solution63 solution63 = new Solution63();

        solution63.Insert(1);
        solution63.Insert(2);
        solution63.Insert(3);
        solution63.Insert(4);
        solution63.Insert(5);
        solution63.Insert(6);


        System.out.println(solution63.GetMedian());

    }
}
