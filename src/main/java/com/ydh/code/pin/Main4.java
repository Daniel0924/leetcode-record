package com.ydh.code.pin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Yang Danhao
 * Main4 2019/9/1 8:00 PM Version 1.0
 */
public class Main4 {

    public static int getRes(int[] a, int[] b) {
        int odda = 0;
        int evena = 0;
        int oddb = 0;
        int evenb = 0;

        for (int i : a) {
            if ((i & 1) == 1) {
                odda++;
            } else {
                evena++;
            }
        }
        for (int i : b) {
            if ((i & 1) == 1) {
                oddb++;
            } else {
                evenb++;
            }
        }
        int res = 0;
        res += Math.min(odda, evenb);
        res += Math.min(oddb, evena);
        return res;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            String[] line2 = br.readLine().split(" ");
            String[] line3 = br.readLine().split(" ");

            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(line2[i]);
            }
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(line3[i]);
            }
            System.out.println(getRes(a, b));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
