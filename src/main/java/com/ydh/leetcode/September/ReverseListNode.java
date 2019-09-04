package com.ydh.leetcode.September;

/**
 * @author Yang Danhao
 * ReverseListNode 2019/9/2 8:54 PM Version 1.0
 */
public class ReverseListNode {

    public ListNode reverse(ListNode root) {

        if (root == null || root.next == null) {
            return root;
        }

        ListNode pre = null;
        ListNode cur = root;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);

        ListNode res = new ReverseListNode().reverse(root);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
