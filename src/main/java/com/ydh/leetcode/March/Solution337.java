package com.ydh.leetcode.March;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution337 {

    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cur = 1;
        int next = 0;

        List<Integer> items = new ArrayList<>();
        int item = 0;
        while (!queue.isEmpty()) {

            TreeNode temp = queue.poll();
            cur--;
            item += temp.val;

            if (temp.left != null) {
                next++;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                next++;
                queue.add(temp.right);
            }

            if (cur == 0) {
                cur = next;
                next = 0;
                items.add(item);
                item = 0;
            }
        }

        items.forEach(System.out::println);
        int len = items.size();
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = items.get(i);
        }
        items = null;
        int[] dp = new int[res.length];

        dp[0] = res[0];
        dp[1] = Math.max(dp[0], res[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + res[i]);
        }

        return dp[len - 1];

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(5);

        System.out.println(new Solution337().rob(root));
    }

}
