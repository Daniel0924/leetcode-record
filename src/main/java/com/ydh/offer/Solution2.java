package com.ydh.offer;

public class Solution2 {

    public String replaceSpace(StringBuffer str){

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                str.replace(i,i + 1,"%20");

            }
        }
        return str.toString();
    }

    public static void main(String[] args){
        StringBuffer str = new StringBuffer("ab cde f");

        //str.replace(1,2,"x");
        System.out.println(str.toString());

        System.out.println(new Solution2().replaceSpace(str));
    }
}
