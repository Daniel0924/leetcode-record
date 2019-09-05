package com.ydh.leetcode.September;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Yang Danhao
 * Solution513 2019/9/4 5:34 PM Version 1.0
 */
public class Solution513 {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int cur = 1;
        int next = 0;
        int res = root.val;
        int mid = 1;

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println("node:" + node.val);
            System.out.printf("mid: %d, next:%d", mid, next);
            System.out.println();
            if (mid == cur) {
                res = node.val;
            }
            cur--;
            if (node.left != null) {
                queue.add(node.left);
                next++;
            }
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }
            if (cur == 0) {
                cur = next;
                mid = next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        int res = new Solution513().findBottomLeftValue(root);
        System.out.println(res);
    }
}
