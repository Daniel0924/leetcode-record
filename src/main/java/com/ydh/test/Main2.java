package com.ydh.test;

public class Main2 {


    public static String getArray(int emnum, int bus, int[] array) {
        StringBuffer sb = new StringBuffer();

        if (emnum <= bus) {
            for (int i : array) {
                sb.append(i + " ");
            }
            return sb.toString();
        }
        int len = array.length;
        int right = emnum % bus;
        while (right > 0) {
            sb.append(array[len - right] + " ");
            right--;
        }
        for (int i = (len - emnum % bus); i >= bus; i -= bus) {
            int temp = bus;
            while (temp > 0) {
                sb.append(array[i - temp] + " ");
                temp--;
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        int emnum = 23;
        int bus = 3;

        String s = "6334 26500 19169 15724 11478 29358" +
                " 26962 24464 5705 28145 23281 16827 9961 491" +
                " 2995 11942 4827 5436 32391 14604 3902 153" +
                " 292 12382 17421 18716 19718 19895 5447 21726" +
                " 14771 11538 1869 19912 25667 26299 17035 9894" +
                " 28703 23811 31322";

        String[] arrays = s.split(" ");

        int[] test = new int[arrays.length];

        for (int i = 0; i < test.length; i++) {
            test[i] = Integer.parseInt(arrays[i]);
        }

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};

        String res = getArray(emnum, bus, test);
        System.out.println(res);
    }
}
