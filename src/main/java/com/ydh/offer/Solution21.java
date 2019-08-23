package com.ydh.offer;

import java.util.LinkedList;
import java.util.Stack;

public class Solution21 {

    public boolean IsPopOrder(int[] pushA, int[] popA) {

        Stack<Integer> stack = new Stack<>();
        int index = 0;

        LinkedList<TreeNode> list = new LinkedList<>();

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};

        int[] popA = {4, 5, 3, 2, 1};

        System.out.println(new Solution21().IsPopOrder(pushA, popA));
    }
}
