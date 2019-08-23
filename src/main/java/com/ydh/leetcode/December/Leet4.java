package com.ydh.leetcode.December;

public class Leet4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;

        if ((total & 1) > 0) {
            return (double) helper(nums1, nums2, 0, len1 - 1,
                    0, len2 - 1, total / 2 + 1);  //奇数的情况
        } else {

            double pre = helper(nums1, nums2, 0, len1 - 1,
                    0, len2 - 1, total / 2);  //偶数的情况

            double after = helper(nums1, nums2, 0, len1 - 1,
                    0, len2 - 1, total / 2 + 1);

            return (pre + after) / 2;
        }
    }

    //从两个数组中找到第k大的数
    public static int helper(int[] num1, int[] num2,
                             int start1, int end1,
                             int start2, int end2, int k) {

        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 > len2) {
            return helper(num2, num1, start2, end2, start1, end1, k);
        }
        if (len1 == 0) {
            return num2[k - 1];
        }
        if (k == 1) {
            return Math.min(num1[start1], num2[start2]);
        }

        int part1 = Math.min(k / 2, len1);    //出于对num1的边界的考虑。

        int part2 = k - part1;

        //核心部分，利用二分的思想，判断A[k/2-1]和B[k/2-1]的大小,
        //如果正好相等，就找到了，如果A<B,说明要从A的后半段来继续二分查找，B不变，
        //而且寻找的数也要相应减少去除的数量
        if (num1[start1 + part1 - 1] < num2[start2 + part2 - 1]) {

            return helper(num1, num2, start1 + part1, end1, start2, end2, k - part1);

        } else if (num1[start1 + part1 - 1] > num2[start2 + part2 - 1]) {

            return helper(num1, num2, start1, end1, start2 + part2, end2, k - part2);

        } else {
            return num1[start1 + part1 - 1];
        }

    }


    public static void main(String[] args) {

        int[] num1 = {1, 2, 3};
        int[] num2 = {4, 5, 6};

        String s = "abbba";

        System.out.println(s.substring(0,5));
    }

}
