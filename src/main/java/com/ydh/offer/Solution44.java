package com.ydh.offer;

public class Solution44 {


    public String ReverseSentence(String str) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }

        String[] array = str.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            sb.append(array[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {


        String s = "student. a am I";

        System.out.println(new Solution44().ReverseSentence(s));
    }

}
