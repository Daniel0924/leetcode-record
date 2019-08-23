package com.ydh.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {


    public static int getNum(int n, int m) {

        if (m < n) {
            return 1;
        }

        if (m % n == 0) {
            return m / n;
        } else {

            return m / n + 1;
        }


    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            System.out.println(getNum(n, m));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
