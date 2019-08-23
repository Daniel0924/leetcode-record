package com.ydh.thread;

import java.util.ArrayList;
import java.util.List;

public class AllSort {

    public void allSort(String[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        helper(s, 0, new ArrayList<>());
    }

    public void helper(String[] s, int start, List<String> list) {
        for (int i = start; i < s.length; i++) {
            list.add(s[i]);
            String temp = "";
            for (String ss : list) {
                temp += ss;
                temp += ",";
            }
            System.out.println(temp);
            helper(s, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        String[] s = {"a", "b", "c"};
        new AllSort().allSort(s);
    }
}
