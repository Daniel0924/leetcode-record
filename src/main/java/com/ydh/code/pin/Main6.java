package com.ydh.code.pin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Yang Danhao
 * Main6 2019/9/1 8:51 PM Version 1.0
 */
public class Main6 {

    public static long getRes(int[] box, int m) {
        long worker = 0L;
        int life = m;
        worker += box.length;
        int index = 0;

        for (int i = 0; i < box.length; i++) {
            int temp = box[i] / life;
            worker += temp;
            int mod = box[i] % life;
            index += mod;
            while (index >= m) {
                worker++;
                index -= m;
            }
        }
        System.out.println("index = " + index);

        if (worker == box.length) {
            return (worker + 1);
        }
        return worker;
    }

    public static void main(String[] args) {

        int[] boxs = new int[1000];
        for (int i = 0; i < 1000; i++) {
            boxs[i] = 1000000000;
        }
        int workers = 1;
        System.out.println(getRes(boxs, workers));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] line1 = br.readLine().split(" ");
            int n = Integer.parseInt(line1[0]);
            int m = Integer.parseInt(line1[1]);

            String[] line2 = br.readLine().split(" ");
            int[] box = new int[n];
            for (int i = 0; i < n; i++) {
                box[i] = Integer.parseInt(line2[i]);
            }
            System.out.println(getRes(box, m));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
