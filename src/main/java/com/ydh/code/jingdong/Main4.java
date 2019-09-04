package com.ydh.code.jingdong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
