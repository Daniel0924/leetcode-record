package com.ydh.leetcode.February;

public class Solution191 {

    public int hammingWeight(int n){
        int count = 0;

        while(n != 0){
            count += (n & 1);
            n = n >>> 1;

        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(new Solution191().hammingWeight(1000100000));
    }
}
