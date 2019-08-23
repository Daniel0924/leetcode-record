package com.ydh.leetcode.niuke;

public class Solution51 {

    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = 1;
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != j){
                    B[j] *= A[i];
                    System.out.println("B" + j + ":" + B[j]);
                }
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};

        int[] B = new Solution51().multiply(A);

        for (int i : B) {
            System.out.println(i);
        }
    }
}
