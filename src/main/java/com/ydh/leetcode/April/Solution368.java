package com.ydh.leetcode.April;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution368 {

    public static int getRes(int n) {
        String index = "0";
        int num = 1;
        for (int i = 0; i < n; i++) {
            index = index + num;
            num++;
            if (index.length() > n) {
                return index.charAt(n) - '0';
            }
            if(i % 1000 == 0){
                System.out.println(i);
            }
        }
        return index.charAt(n) - '0';
    }

    public static void main(String[] args) {

        System.out.println(getRes(1000000));
    }
}
