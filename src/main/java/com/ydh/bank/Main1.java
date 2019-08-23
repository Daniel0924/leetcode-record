package com.ydh.bank;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Integer[] arrays = {2, 5, 7, 1, 3};

        Arrays.sort(arrays, (a, b) -> b.compareTo(a));

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.printf("str: %s\n", str);
        }

    }
}
