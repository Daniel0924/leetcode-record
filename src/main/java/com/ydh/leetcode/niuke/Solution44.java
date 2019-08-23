package com.ydh.leetcode.niuke;

public class Solution44 {

    public String ReverseSentence(String str) {

        String[] stringArray = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = stringArray.length - 1; i >= 0; i--) {
            sb.append(stringArray[i] + " ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args){
        String str = "student. a am I";

        System.out.println(new Solution44().ReverseSentence(str));
    }
}
