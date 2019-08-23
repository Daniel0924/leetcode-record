package com.ydh.leetcode.niuke;

import java.util.ArrayList;
import java.util.List;

public class Solution58 {

    boolean isSymmetrical(TreeNode pRoot) {


        return doubleIndex(pRoot, pRoot);
    }

    public boolean doubleIndex(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return doubleIndex(left.left, right.right) && doubleIndex(left.right, right.left);
    }


    public void leftIndex(TreeNode node, List<Integer> left) {

        if (node == null) {
            return;
        }
        leftIndex(node.left, left);
        left.add(node.val);
        leftIndex(node.right, left);
    }

    public void rightIndex(TreeNode node, List<Integer> right) {
        if (node == null) {
            return;
        }

        rightIndex(node.right, right);
        right.add(node.val);
        rightIndex(node.left, right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);

        node.left = new TreeNode(3);
        node.right = new TreeNode(3);
        node.right.right = new TreeNode(3);

        System.out.println(new Solution58().isSymmetrical(node));
    }

}
