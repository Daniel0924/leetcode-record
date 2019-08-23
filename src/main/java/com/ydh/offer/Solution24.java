package com.ydh.offer;

import java.util.HashMap;
import java.util.Map;

public class Solution24 {

    public RandomListNode Clone(RandomListNode pHead) {

        RandomListNode head = new RandomListNode(pHead.label);

        RandomListNode res = head;

        if (pHead.random != null) {
            head.random = new RandomListNode(pHead.random.label);
        }

        while (pHead.next != null) {
            pHead = pHead.next;

            head.next = new RandomListNode(pHead.label);
            if (pHead.random != null) {
                head.next.random = new RandomListNode(pHead.random.label);

            }
            head = head.next;

        }
        return res;

    }

    public static void main(String[] args) {

    }
}
