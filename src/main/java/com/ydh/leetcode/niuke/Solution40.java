package com.ydh.leetcode.niuke;

import java.util.LinkedList;
import java.util.List;

public class Solution40 {


    public void contains2numbers(int[] array, int[] num1, int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        int bitResult = 0;
        for (int i : array) {
            bitResult ^= i;    // 4 ^ 5 = 1  4:0100   5:0101,
            // bitResult = 1
        }

        //bitResult 表示这两个数的异或结果
        //
        // index表示这两个数在第几位不一样


        int index = findFirst1(bitResult);
        //index表示二进制中第一个为1的序号，index = 0

        for (int i = 0; i < array.length; i++) {

            if (isBit1(array[i], index)) {
                num1[0] ^= array[i];

            } else {
                num2[0] ^= array[i];
            }
        }
    }

    //返回这个数字的二进制下的第一个值为1的位数，位数为第0位，第1位...
    public int findFirst1(int bitResult) {
        int index = 0;
        while (((bitResult & 1) == 0) && index < 32) {
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    //判断target的index位的值是否为1
    public boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 0;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 1, 2, 3};
        int item = 0;


        for (int i = 1; i < 10; i++){
            System.out.println(new Solution40().findFirst1(i));
        }


    }
}
