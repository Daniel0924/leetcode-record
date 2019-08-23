package com.ydh.leetcode.niuke;

public class Solution55 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;

        while (slow != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        if (fast == null) {
            return new ListNode(-1);
        }
        ListNode root = pHead;
        while (root != slow) {
            root = root.next;
            slow = slow.next;
        }
        return root;

    }

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

    }
}
