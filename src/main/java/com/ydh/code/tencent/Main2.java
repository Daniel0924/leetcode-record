package com.ydh.code.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {



    public static int getSum(int left, int right) {

        if (left % 2 == 0 && right % 2 == 0) {
            return -(right - left) / 2 + right;
        } else if (left % 2 == 0 && right % 2 == 1) {
            return -(right - left + 1) / 2;
        } else if (left % 2 == 1 && right % 2 == 0) {
            return (right - left + 1) / 2;
        } else {
            return (right - left) / 2 - right;
        }

    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int q = Integer.parseInt(br.readLine());

            int[][] nums = new int[q][2];
            for (int i = 0; i < q; i++) {
                String[] s = br.readLine().split(" ");
                nums[i][0] = Integer.parseInt(s[0]);
                nums[i][1] = Integer.parseInt(s[1]);
            }

            for (int i = 0; i < q; i++) {
                System.out.println(getSum(nums[i][0], nums[i][1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
