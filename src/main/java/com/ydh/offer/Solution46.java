package com.ydh.offer;

import java.util.HashMap;
import java.util.Map;

public class Solution46 {

    public int LastRemaining_Solution(int n, int m) {
        int[] res = new int[n];   //模拟序列
        int count = n;            //还有多少个小朋友没有被点到
        int step = 0;             //表示本轮喊到的数字
        int position = 0;         //表示当前小朋友的编号
        while (count > 0) {
            position++;

            if (position >= n) {
                position = 0;
            }
            if (res[position] != -1) {
                step++;
            }

            if (step == m - 1 && res[position] != -1) {
                System.out.println(position);
                step = -1;
                res[position] = -1;
                count--;
            }
        }
        return position;
    }

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>(1024);
        int n = 5;
        int m = 3;

        System.out.println(new Solution46().LastRemaining_Solution(n, m));
    }
}
