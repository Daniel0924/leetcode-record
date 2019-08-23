package com.ydh.School;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Child {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            String[] h = br.readLine().split(" ");

            int m = Integer.parseInt(br.readLine());
            String[] w = br.readLine().split(" ");

            int[] hh = new int[n];
            int[] ww = new int[m];

            for (int i = 0; i < h.length; i++) {
                hh[i] = Integer.parseInt(h[i]);
            }

            for (int i = 0; i < w.length; i++) {
                ww[i] = Integer.parseInt(w[i]);
            }

            System.out.println(child(n, hh, m, ww));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static int child(int n, int[] h, int m, int[] w) {
        int res = 0;

        if (n == 0 || m == 0) {
            return res;
        }

        Arrays.sort(h);
        Arrays.sort(w);

        int pos = h.length - 1;
        for (int i = w.length - 1; i >= 0; i--) {

            if (pos < 0) {
                break;
            }
            if (w[i] >= h[pos]) {
                res++;
            }
            pos--;
        }

        return res;
    }
}
