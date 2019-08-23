package com.ydh.test;

import java.util.Stack;

public class Main9 {


    /**
     * 用一个栈解决问题
     *
     * @param s
     * @return
     */
    public static String getRes(String s) {
        return s;
    }


    public static String getResWrong(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        //这个地方就是错的，应该用一个栈，而不是两个！！！
        Stack<Integer> numStack = new Stack<>();

        Stack<String> stringStack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int num = 0;
        String str = "";
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {

                if (str.length() > 0) {
                    stringStack.push(str);
                    System.out.println("push:" + str);
                    str = "";
                }

                num = num * 10 + (s.charAt(i) - '0');
            } else if (s.charAt(i) == '(') {

                if (num > 0) {
                    numStack.push(num);
                    System.out.println("push:" + num);
                    num = 0;
                }


            } else if (s.charAt(i) == ')') {

                if (str.length() > 0) {
                    stringStack.push(str);
                    System.out.println("push:" + str);

                    str = "";
                }

                int numTemp = numStack.pop();
                String strTemp = stringStack.pop();
                String son = generate(numTemp, strTemp);

                System.out.println("pop:" + numTemp + "," + strTemp);

                if (numStack.isEmpty()) {
                    System.out.println("append" + son);
                    sb.append(son);
                } else {
                    stringStack.push(son);
                }

            } else if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                str = str + s.charAt(i);
                System.out.println("str: " + str);
            }

        }

        return sb.toString();
    }

    /**
     * 生成子字符串
     *
     * @param num
     * @param s
     * @return
     */
    public static String generate(int num, String s) {

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            num--;
            sb.append(s);
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        String s1 = "3(bc3(3(g)))";

    }
}
