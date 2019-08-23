package com.ydh.leetcode.February;

public class Solution234 {

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode before = head;
        ListNode after = reverse(slow);

        if (after != null && after.next == null && after.val != before.val) {
            return false;
        }

        while (after != null && before != null) {
            if (after.val != before.val) {
                return false;
            }

            after = after.next;
            before = before.next;
        }

        return true;
    }


    public ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        if (cur == null) {
            System.out.println("空的");
        }

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(1);

        //node.next.next.next.next = new ListNode(2);
        //node.next.next.next.next.next = new ListNode(1);

        System.out.println(new Solution234().isPalindrome(node));
    }


}
