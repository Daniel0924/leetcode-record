package com.ydh.leetcode.July;


class SolBase {

    public int rand7() {
        return (int) (Math.random() * 7 + 1);
    }
}

class Solution extends SolBase {

    public int rand10() {
        int index = (rand7() - 1) * 7 + rand7();
        while (index > 40) {
            index = (rand7() - 1) * 7 + rand7();
        }
        System.out.println("res : " + (1 + (index - 1) % 10));
        return 1 + (index - 1) % 10;
    }
}

public class Solution470 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = new int[10];
        for (int i = 0; i < 100; i++) {
            res[solution.rand10() - 1]++;
        }
        for (int i : res) {
            System.out.println(i);
        }
    }
}
