package com.ydh.code.jingdong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public static int getRes(int n, String s) {
        if (s == null || s.length() == 0 || n <= 0) {
            return 0;
        }
        boolean mode = false;
        List<Integer> list = new ArrayList<>();
        int count = 0;

        // 表示当前temp是大写还是小写
        boolean little = false;

        if (s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
            little = true;
        }
        count++;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);

            if (little && c >= 'a' && c <= 'z') {
                count++;
                continue;
            }
            if (little && c >= 'A' && c <= 'Z') {
                list.add(count);
                count = 1;
                little = false;
                continue;
            }
            if (!little && c >= 'a' && c <= 'z') {
                list.add(count);
                count = 1;
                little = true;
                continue;
            }
            if (!little && c >= 'A' && c <= 'Z') {
                count++;
            }
        }
        list.add(count);
        if (s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
            little = true;
        } else {
            little = false;
        }

        int res = 0;
        int first = list.get(0);
        if (little) {
            res += first;
        } else {
            res += first;
            res++;
        }
        if (first == 1){
            res--;
        }

        // 记录当前
        boolean qie = false;
        if (!little) {
            qie = true;
        }

        System.out.println("i = " + 0 + ", res = " + res);

        for (int i = 1; i < list.size(); i++) {
            int tmp = list.get(i);
            res += (tmp + 1);

            if (qie && tmp == 1) {
                res--;
                qie = false;
                continue;
            }
            if (!qie && tmp == 1) {
                qie = true;
            }

            System.out.println("i = " + i + ", res = " + res);
        }
        return res;
    }

    public static void main(String[] args) {

        String test = "AaaaAA";
        System.out.println("res:" + getRes(test.length(), test));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());

            String s = br.readLine();

            System.out.println(getRes(n, s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
