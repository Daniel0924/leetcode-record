package com.ydh.test;

/**
 * @author Yang Danhao
 * JVMTest 2019/8/30 3:15 PM Version 1.0
 */
public class JVMTest {

    public static void main(String[] args) {
        int i = 0;
        while (true) {
            i++;
            if (i > 10000) {
                i /= (1 + Math.random());
            }
        }
    }

}
