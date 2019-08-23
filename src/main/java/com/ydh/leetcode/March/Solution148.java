package com.ydh.leetcode.March;

public class Solution148 {

    public ListNode sortList(ListNode head) {

        ListNode pre = new ListNode(-1);

        ListNode cur = head;

        pre.next = cur;

        return cur;

    }


    public static void main(String[] args) {

    }
}
