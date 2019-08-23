package com.ydh.leetcode.niuke;

import java.util.ArrayList;
import java.util.List;


public class Solution62 {

    TreeNode KthNode(TreeNode node, int k) {
        List<TreeNode> res = new ArrayList<>();
        helper(node, res);
        if (res.size() < k) {
            return null;
        }
        return res.get(k - 1);
    }

    public void helper(TreeNode node, List<TreeNode> res) {
        if (node == null) {
            return;
        }

        helper(node.left, res);
        res.add(node);
        helper(node.right, res);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);

        node.left = new TreeNode(6);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(7);

        node.right = new TreeNode(10);
        node.right.right = new TreeNode(11);
        node.right.left = new TreeNode(9);

        TreeNode res = new Solution62().KthNode(node,10);

        System.out.println(res.val);

    }
}
