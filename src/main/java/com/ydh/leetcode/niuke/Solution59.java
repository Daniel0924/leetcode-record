package com.ydh.leetcode.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;

public class Solution59 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        ArrayList<Integer> temp = new ArrayList<>();
        List<TreeNode> queue = new LinkedList<>();

        if (pRoot == null) {
            return res;
        }

        int next = 1;
        int count = 0;
        queue.add(pRoot);
        while (queue.size() > 0) {

            TreeNode root = queue.remove(0);

            temp.add(root.val);
            next--;

            if (root.left != null) {
                queue.add(root.left);
                count++;
            }
            if (root.right != null) {
                queue.add(root.right);
                count++;
            }

            if (next == 0) {
                res.add(new ArrayList<>(temp));
                temp = new ArrayList<>();
                next = count;
                count = 0;
            }


        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right = new TreeNode(10);

        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(7);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(11);

        ArrayList<ArrayList<Integer>> lists = new Solution59().Print(node);

        for (ArrayList<Integer> list : lists) {
            System.out.println(list);
        }

        int[] a = {6,5,4,3,2,1};
        int[] b = a;
        Arrays.sort(b);
        for (int i : a){
            System.out.println(i);
        }
    }


}
