package com.ydh.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution22 {


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (queue.size() > 0) {

            TreeNode temp = queue.pop();

            res.add(temp.val);

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }

        }

        return res;
    }


}
