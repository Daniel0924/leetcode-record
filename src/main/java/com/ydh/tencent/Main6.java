package com.ydh.tencent;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main6 {

    public static int getMin(int n, int m, int[] nn) {

        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (nn[i] == 0) {
                map = new HashMap<>();
                list = new LinkedList<>();
            }

            if (!map.containsKey(nn[i])) {
                map.put(nn[i], 1);
            }

            list.add(nn[i]);

            if (list.size() > 1 && list.getFirst() == nn[i]) {
                list.removeFirst();
            }

            if (map.size() == m) {
                if (res > list.size()) {
                    System.out.println("更新：" + list.size());
                    res = list.size();
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {

        int n = 14;
        int m = 5;

        int[] nn = {2, 5, 3, 1, 0, 2, 4, 1, 0, 5, 4, 3, 2, 1};

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        System.out.println(linkedList.getLast());

        System.out.println(getMin(n, m, nn));

    }
}
