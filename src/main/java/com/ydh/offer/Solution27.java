package com.ydh.offer;

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution27 {

    public ArrayList<String> Permutation(String str) {

        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        TreeSet<String> temp = new TreeSet<>();

        char[] chars = str.toCharArray();

        Permutation(temp, chars, 0);
        return res;
    }

    public void Permutation(TreeSet<String> temp, char[] chars, int begin) {

        if (begin > chars.length - 1) {
            return;
        }

        if (begin == chars.length - 1) {
            temp.add(String.valueOf(chars));
        } else {
            for (int i = begin; i < chars.length; i++) {
                swap(chars, begin, i);
                Permutation(temp, chars, begin + 1);
                swap(chars, begin, i);
            }
        }
    }

    public void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    public static void main(String[] args) {


    }
}
