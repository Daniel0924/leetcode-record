package com.ydh.School;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
    }
}
