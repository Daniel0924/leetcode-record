package com.ydh.School;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoStringMultiple {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        try {
            line = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(multipleString(line));
    }


    public static String multipleString(String line) {

        String[] array = line.split(" ");

        char[] char1 = array[0].toCharArray();

        char[] char2 = array[1].toCharArray();

        int[] a = new int[char1.length];
        int[] b = new int[char2.length];

        for (int i = 0; i < char1.length; i++) {
            a[i] = char1[char1.length - 1 - i] - '0';
        }
        for (int i = 0; i < char2.length; i++) {
            b[i] = char2[char2.length - 1 - i] - '0';
        }
        int[] res = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {

                res[i + j] += a[i] * b[j];

                if (res[i + j] >= 10) {
                    res[i + j + 1] += res[i + j] / 10;
                    res[i + j] %= 10;
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        for (int i = res.length - 1; i >= 0; i--) {
            if (i == res.length - 1 && res[res.length - 1] == 0) {
                continue;
            }
            sb.append(res[i]);
        }

        return sb.toString();
    }
}
