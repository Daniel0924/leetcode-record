package com.ydh.bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // 接收123 345 每次用逗号分隔
        int first = scan.nextInt();
        int second = scan.nextInt();
        System.out.println("first:" + first);
        System.out.println("second:" + second);


        // nextLine方式接收字符串，每次用回车？
        System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        if (scan.hasNextLine()) {
            String str2 = scan.nextLine();
            System.out.println("输入的数据为：" + str2);
        }
        scan.close();

    }
}
