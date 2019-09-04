package com.ydh.leetcode.September;

import java.util.*;

/**
 * @author Yang Danhao
 * Solution508 2019/9/4 5:02 PM Version 1.0
 */
public class Solution508 {

    List<Integer> list = new ArrayList<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        helper(root);
        // 键：当前和 值：出现次数
        Map<Integer, Integer> map = new HashMap<>();
        int ci = 1;
        System.out.println("list size:" + list.size());
        for (int i : list) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
                if (map.get(i) > ci) {
                    ci = map.get(i);
                }
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> tmp : map.entrySet()) {
            if (tmp.getValue() == ci) {
                res.add(tmp.getKey());
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }


    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);
        helper(root.right);

        if (root.left == null && root.right == null) {
            list.add(root.val);
            System.out.println("val:" + root.val);

            return;
        }
        if (root.left != null) {
            root.val += root.left.val;
        }
        if (root.right != null) {
            root.val += root.right.val;
        }
        System.out.println("val:" + root.val);
        list.add(root.val);

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(-3);
        int[] res = new Solution508().findFrequentTreeSum(node);

        for (int t : res) {
            System.out.println(t);
        }
    }
}
