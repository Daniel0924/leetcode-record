package com.ydh.leetcode.December;

import java.sql.SQLOutput;

public class Leet2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int num1 = temp1.val;
        int num2 = temp2.val;

        temp1 = temp1.next;
        temp2 = temp2.next;

        while (temp1 != null) {
            num1 = num1 * 10 + temp1.val;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            num2 = num2 * 10 + temp2.val;
            temp2 = temp2.next;
        }
        num1 = num1 + num2;
        System.out.println(num1);

        String str = num1 + "";
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        for (int i = 0; i < str.length(); i++){
            temp.next = new ListNode(str.charAt(i) - '0');
            temp = temp.next;
        }

        return res.next;
    }

    public static void main(String[] args) {

        ListNode num1 = new ListNode(2);
        num1.next = new ListNode(4);

        ListNode num2 = new ListNode(3);
        num2.next = new ListNode(6);

        ListNode res = new Leet2().addTwoNumbers(num1, num2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
