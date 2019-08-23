package com.ydh.leetcode.March;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int count = 1;
        int next = 0;

        while (queue.size() > 0) {

            TreeNode node = queue.poll();
            if (count == 1) {
                list.add(node.val);
            }

            count--;

            if (node.left != null) {
                queue.add(node.left);
                next++;
            }
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }

            if (count == 0) {
                count = next;
                next = 0;
            }

        }
        return list;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(5);

        node.right = new TreeNode(3);
        node.right.right = new TreeNode(4);

        List<Integer> res = new Solution199().rightSideView(node);
        res.forEach(System.out::println);
    }
}
