package com.ydh.offer;

import java.util.TreeSet;

public class Solution26 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        return new TreeNode(1);
    }

    public void printMidOrder(TreeNode root) {
        if (root.left != null){
            printMidOrder(root.left);
        }

        System.out.println(root.val);
        if (root.right != null){
            printMidOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(7);

        new Solution26().printMidOrder(node);

    }


}
