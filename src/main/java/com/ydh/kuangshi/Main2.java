package com.ydh.kuangshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {


    public static int[] getNums(List<List<Integer>> list, int n) {
        if (list == null || list.size() == 0) {
            return new int[0];
        }

        List<Integer> res = new ArrayList<>();
        int index = list.size();
        while (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                List<Integer> temp = list.get(i);
                if (temp.size() == 0) {
                    list.remove(i);
                }
                for (int j = 0; j < n; j++) {
                    if (temp.size() > 0) {
                        res.add(temp.get(0));
                        temp.remove(0);
                    } else {
                        break;
                    }
                }
            }
        }
        int[] result = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

        /**
         List<Integer> temp1 = new ArrayList<>();
         List<Integer> temp2 = new ArrayList<>();

         temp1.add(1);
         temp1.add(2);
         temp1.add(3);


         temp2.add(4);
         temp2.add(5);
         temp2.add(6);


         List<List<Integer>> list = new ArrayList<>();
         list.add(temp1);
         list.add(temp2);

         int[] res = getNums(list, 3);
         for (int t : res) {
         System.out.println(t);
         }
         **/
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> arrays = new ArrayList<>();

        while (scanner.hasNext()) {


            String string = scanner.nextLine();

            if (string == null || string.equals("")) {
                break;
            }

            List<Integer> temp = new ArrayList<>();
            String[] numsArr = string.split(",");

            for (int i = 0; i < numsArr.length; i++) {
                temp.add(Integer.parseInt(numsArr[i]));
            }
            if (temp.size() > 0) {
                arrays.add(temp);
                System.out.println("我们添加了：" + temp);
            }

        }

        if (arrays.size() == 0) {
            return;
        }
        int[] result = getNums(arrays, n);
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
