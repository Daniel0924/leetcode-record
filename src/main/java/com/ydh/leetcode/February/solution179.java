package com.ydh.leetcode.February;

import java.util.Arrays;
import java.util.Comparator;

public class solution179 {

    public String largestNumber(int[] nums) {

        String[] array = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(array, new Compare());

        String res = "";
        for (int i = nums.length - 1; i >= 0; i--) {
            res = res + array[i];
        }
        return res;

    }

    class Compare implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {

            if (o1.length() > 8 && o2.length() > 8) {
                for (int i = 0; i < 8; i++) {
                    if (o1.charAt(0) == o2.charAt(0)) {
                        o1 = o1.substring(1);
                        o2 = o2.substring(1);
                        System.out.println(o1);
                        System.out.println(o2);

                    } else {
                        break;
                    }
                }
            }


            String a = o1 + o2;
            String b = o2 + o1;

            //return Long.parseLong(a) - Long.parseLong(b);
            return Integer.parseInt(a) - Integer.parseInt(b);
        }
    }

    public static void main(String[] args) {

        int[] nums = {999999998, 999999997, 999999999};
        System.out.println(new solution179().largestNumber(nums));
        System.out.println("ABC".substring(1));

    }
}
