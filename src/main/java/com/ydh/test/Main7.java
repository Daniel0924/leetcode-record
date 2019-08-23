package com.ydh.test;

import java.util.*;

public class Main7 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String longString = in.nextLine();
        String[] all = longString.split(" ");
        int num = Integer.parseInt(all[0]);

        String[] temp = new String[num];

        for (int i = 0; i < num; i++) {
            temp[i] = all[i + 1];
        }

        List<String> res = getRes(temp);

        for (String s : res) {
            System.out.print(s + " ");
        }

    }

    public static List<String> getRes(String[] temp) {
        List<String> res = new ArrayList<>();
        for (String s : temp) {
            if (s.length() <= 8) {
                int index = 8 - s.length();
                String zeros = "";
                while (index > 0) {
                    index--;
                    zeros = zeros + "0";
                }
                res.add(s + zeros);
            } else {
                List<String> splits = splits(s);
                res.addAll(splits);
            }
        }

        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        return res;
    }

    public static List<String> splits(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            if (i + 8 > s.length()) {
                int index = i + 8 - s.length();
                String zeros = "";
                while (index > 0) {
                    index--;
                    zeros = zeros + "0";
                }
                res.add(s.substring(i) + zeros);
                break;
            }
            res.add(s.substring(i, i + 8));
            i += 8;
        }
        return res;
    }
}
