package com.ydh.School;

import java.net.ServerSocket;

public class SocketOfServer {

    public static void main(String[] args) {

        int[] numbers = {5, 6, 3, 8, 4, 1, 9, 7};

        quickSort(numbers, 0, numbers.length - 1);

        for (int i : numbers) {
            System.out.print(i + ",");
        }

    }

    //基准，左加右减，交换，分流
    public static void quickSort(int[] numbers, int start, int end) {
        if (start >= end) {
            return;
        }

        int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
        int temp; // 记录临时中间值
        int i = start, j = end;
        while (i <= j) {
            while ((numbers[i] < base) && (i < end)) {
                i++;
            }
            while ((numbers[j] > base) && (j > start)) {
                j--;
            }
            if (i <= j) {
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(numbers, start, j);
        quickSort(numbers, i, end);

    }


    public static void quickSort2(int[] numbers, int start, int end) {


    }
}
