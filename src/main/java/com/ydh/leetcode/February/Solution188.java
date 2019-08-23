package com.ydh.leetcode.February;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution188 {

    public int maxProfit(int k, int[] prices) {

        if (prices == null || prices.length == 0 || k < 1) {
            return 0;
        }


        int[] res = new int[prices.length];
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[i - 1] <= prices[i] && prices[i] <= prices[i + 1]) {  //一路上涨
                if (i + 1 == prices.length - 1) {
                    list.add(prices[i + 1] - prices[left]);
                }

            } else if (prices[i - 1] <= prices[i] && prices[i] > prices[i + 1]) {  //先涨后跌
                right = i;
                list.add(prices[right] - prices[left]);
                left = i + 1;

            } else if (prices[i - 1] > prices[i] && prices[i] > prices[i + 1]) {  //一路下跌
                left = i + 1;

            } else if (prices[i - 1] > prices[i] && prices[i] < prices[i + 1]) {  //先跌后涨
                left = i;

                if (i + 1 == (prices.length - 1)) {
                    list.add(prices[i + 1] - prices[i]);
                }
            }
        }

        list.forEach(System.out::println);
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        int sum = 0;
        for (int i = res.length - 1; i >= Math.max(0, res.length - k); i--) {
            System.out.println("");
            System.out.println(res[i]);
            sum += res[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] input = {3, 3, 5, 0, 0, 3, 1, 4};


        System.out.println(new Solution188().maxProfit(2, input));
    }

}
