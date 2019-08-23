package com.ydh.leetcode.December;

public class Leet21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode res = new ListNode(-1);

        ListNode cur = res;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return res.next;

    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(8);

        ListNode res = new Leet21().mergeTwoLists(l1, l2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
