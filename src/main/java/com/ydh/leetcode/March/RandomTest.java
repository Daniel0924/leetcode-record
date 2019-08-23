package com.ydh.leetcode.March;
class A {
    public int func1(int a, int b) {
        return a - b;
    }
}
class B extends A {
    public int func1(int a, int b) {
        return a + b;
    }
}
public class RandomTest {

    public static int halfRandom() {
        return Math.random() > 0.3 ? 1 : 0;

    }

    public static int updateRandom() {

        //return halfRandom() == 0 ? 0 : (Math.random() > (5.0 / 7.0) ? 0 : 1);
        if (halfRandom() == 0) {
            return 0;
        } else {
            return Math.random() > (5.0 / 7.0) ? 0 : 1;
        }
    }

    public static void main(String[] args) {

        int zeros = 0;
        int ones = 1;
        for (int i = 0; i < 99999; i++) {
            if (updateRandom() > 0) {
                ones++;
            } else zeros++;
        }
        System.out.println("number 1:" + ones + ", number 0：" + zeros);
        System.out.println(100%3.0);


    }
}
