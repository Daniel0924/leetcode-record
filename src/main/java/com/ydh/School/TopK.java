package com.ydh.School;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class TopK {


    public ArrayList<Integer> getTopK(int[] input, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        if (k == 0 || input == null || input.length == 0) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < input.length; i++) {
            if (queue.size() < k) {
                queue.offer(input[i]);
            } else if (input[i] > queue.peek()) {
                queue.poll();
                queue.offer(input[i]);
            }
        }

        res.addAll(queue);
        res.forEach(System.out::print);

        return res;
    }

    public static void main(String[] args) {
        int[] top = {1, 2, 3, 9, 8, 7, 6, 4, 5};
        ArrayList<Integer> res = new TopK().getTopK(top, 3);


    }
}
