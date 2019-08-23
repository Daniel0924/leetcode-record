package com.ydh.leetcode.April;

public class Solution365 {


    public boolean canMeasureWater(int x, int y, int z) {

        if (x < z && y < z) {
            return false;
        }
        if (x == y && x != z) {
            return false;
        }
        if (z % x == 0 || z % y == 0) {
            return true;
        }

        while (x > 0 && y > 0) {
            int temp = Math.abs(x - y);
            if (temp > 0 && z % temp == 0) {
                return true;
            }
            if (x > y) {
                x = temp;
            } else {
                y = temp;
            }
        }

        return false;

    }
}
