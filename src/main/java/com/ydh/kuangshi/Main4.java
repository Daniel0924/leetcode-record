package com.ydh.kuangshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main4 {

    public int getMul(int[] nums, int n, int k, int d) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return 1;
    }


    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<>();
        int count = 0;
        try {


            List<List<String>> list = new ArrayList<>();

            while (br.ready()) {
                String[] foods = br.readLine().split(" ");
                for (String s : foods) {
                    if (!map.containsKey(s)) {
                        map.put(s, s);
                        count++;
                    }
                }
            }
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
