package com.ydh.leetcode.June;

import java.util.ArrayList;
import java.util.List;

public class Solution437 {
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> out = new ArrayList<>();
        helper(root, sum, 0, out, res);
        return res;
    }

    public void helper(TreeNode node, int sum, int curSum, List<TreeNode> out, int res) {
        if (node == null) {
            return;
        }
        curSum += node.val;

        out.add(node);
        if (curSum == sum) {
            res++;
        }
        int t = curSum;
        for (int i = 0; i < out.size() - 1; i++) {
            t -= out.get(i).val;
            if (t == sum) {
                res++;
            }
        }
        helper(node.left, sum, curSum, out, res);
        helper(node.right, sum, curSum, out, res);

        out.remove(out.get(out.size() - 1));
    }

    public static void main(String[] args) {

    }
}
