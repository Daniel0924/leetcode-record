package com.ydh.leetcode.December;

public class Leet19 {

    //删除链表中倒数第n个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null && n == 1){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(n > 0 && fast != null){
            n--;
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
