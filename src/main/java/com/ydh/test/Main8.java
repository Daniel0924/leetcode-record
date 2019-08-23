package com.ydh.test;

import java.util.Scanner;
import java.util.Stack;

public class Main8 {

    public static void main(String[] args) {

        String s1 = "abc3(A)";
        //String s2 = "3(bc3(3(g)))";

        System.out.println("s1:" + getRes(s1));
        //System.out.println("s2:" + getRes(s2));

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        String result = getRes(s);
        System.out.println(result);

    }

    public static String getRes(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();

        int length = s.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int status = i;
            System.out.println("i ==== " + i);

            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                int numtemp = numStack.pop();
                String strTemp = charStack.pop();
                String sss = "";
                System.out.println("pop:" + numtemp + ",pop:" + strTemp);
                while (numtemp > 0) {
                    sss = sss + strTemp;
                    numtemp--;
                }

                if (charStack.size() > 0) {
                    charStack.push(sss);
                } else {
                    res.append(sss);
                    System.out.println("append:" + sss);

                }
            }

            if (s.charAt(i) > '0' && s.charAt(i) <= '9') {
                int num = 0;
                while (i < length && s.charAt(i) > '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                    System.out.println("i = " + i);
                }


                numStack.push(num);
                System.out.println("push : " + num);
            }

            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                    || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                StringBuilder sb = new StringBuilder();

                if (numStack.size() == 0) {
                    while (i < length && (
                            (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                                    || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))) {
                        sb.append(s.charAt(i));
                        i++;
                    }
                    res.append(sb.toString());
                    continue;
                }

                while (i < length && (
                        (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                                || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))) {
                    sb.append(s.charAt(i));
                    i++;
                    System.out.println("i = " + i);
                }
                charStack.push(sb.toString());

                System.out.println("push:" + sb.toString());
            }

            if (status < i){
                i--;
            }
        }

        return reverse(res.toString());

    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
