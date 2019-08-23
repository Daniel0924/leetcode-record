package com.ydh.test;

import java.util.Scanner;

public class Main4 {


    private static int x = 10;
    private static Integer y = 10;

    public static void updateX(int value) {
        value = 3 * value;

    }

    public static void updateY(Integer value) {
        value = 3 * value;
    }

    public static void main(String[] args) {

        System.out.println(Test2.a);

        Object o = new Object();
    }
}

class Test2{
    static {
        System.out.print("OK");
    }


    public static final String a=new String("JD");

}
