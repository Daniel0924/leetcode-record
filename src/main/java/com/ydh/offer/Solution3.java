package com.ydh.offer;

import java.util.ArrayList;
import java.util.Stack;

public class Solution3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> tempStack = new Stack<>();

        while (listNode != null) {
            tempStack.push(listNode.val);

            listNode = listNode.next;
        }

        while (!tempStack.isEmpty()) {
            result.add(tempStack.pop());
        }
        return result;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        ArrayList res = new Solution3().printListFromTailToHead(node);

        res.forEach(System.out::print);
    }
}
