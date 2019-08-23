package com.ydh.leetcode.December;

public class Leet11 {

    public int maxArea(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        //计算容积的方法：两侧两个值中的最小值 * 两个序号的差
        int left = 0;
        int right = height.length - 1;

        int res = Math.abs(right - left) * Math.min(height[left], height[right]);
        System.out.println("init: " + res);
        while (left < right) {
            System.out.println("第一轮");
            if (height[left] < height[left + 1]) {
                left++;

                int temp = Math.abs(right - left) * Math.min(height[left], height[right]);
                System.out.println(temp);
                if (temp > res) {
                    res = temp;
                }
            } else if (height[right] < height[right - 1]) {
                right--;

                int temp = Math.abs(right - left) * Math.min(height[left], height[right]);
                System.out.println(temp);

                if (temp > res) {
                    res = temp;
                }
            } else {
                left++;
                right--;

            }
        }

        return res;
    }


    public static void main(String[] args) {

        int[] height = {1, 3, 2, 5, 25, 24, 5};

        System.out.print(new Leet11().maxArea(height));

    }
}
