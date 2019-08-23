package com.ydh.leetcode.niuke;

public class Solution56 {

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode result = new ListNode(-1);
        result.next = pHead;
        ListNode pre = result;
        ListNode cur = pHead;
        boolean repaid = false;
        while (cur != null && cur.next != null) {
            int temp = cur.val;
            while (cur.next != null && temp == cur.next.val) {
                cur = cur.next;
                repaid = true;
            }

            cur = cur.next;
            if (repaid) {
                pre.next = cur;
                repaid = false;
            } else {
                pre = pre.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next = new ListNode(1);


        ListNode res = new Solution56().deleteDuplication(node);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
