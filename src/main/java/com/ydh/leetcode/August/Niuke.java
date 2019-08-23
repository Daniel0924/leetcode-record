package com.ydh.leetcode.August;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Niuke {

    static final long size = 200 * 1024 * 1024;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        List<Integer> item = new ArrayList<>();
        int next = 0;
        int cur = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            cur--;
            item.add(node.val);
            if (node.left != null) {
                next++;
                queue.add(node.left);
            }
            if (node.right != null) {
                next++;
                queue.add(node.right);
            }
            if (cur == 0) {
                cur = next;
                next = 0;
                res.add(new ArrayList<>(item));
                item = new ArrayList<>();
            }
        }
        Collections.reverse(res);
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[(int) size];

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Collections.reverse(res);
    }
}
