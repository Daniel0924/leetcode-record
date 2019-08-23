package com.ydh.offer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution25 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            String[] chars = s.split(" ");
            int[] intarray = new int[chars.length];

            for (int i = 0; i < chars.length; i++) {
                intarray[i] = Integer.parseInt(chars[i]);
            }

            System.out.println(intarray[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
