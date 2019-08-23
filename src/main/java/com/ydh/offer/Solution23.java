package com.ydh.offer;

import java.util.ArrayList;

public class Solution23 {


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, new ArrayList<Integer>(), root, target);
        return res;

    }


    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> item,
                       TreeNode root, int target) {

        if (target < 0) {

            return;
        }

        item.add(root.val);
        target = target - root.val;

        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(item));
        }

        if (root.left != null) {
            helper(res, item, root.left, target);
        }
        if (root.right != null) {
            helper(res, item, root.right, target);
        }

        item.remove(item.size() - 1);
    }


}
