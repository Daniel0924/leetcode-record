package com.ydh.leetcode.tencent;

public class Main6 {
    StringBuilder sb = new StringBuilder();

    public String serialize(TreeNode root) {

        if (root == null) {
            sb.append("#");
            sb.append(",");
            return sb.toString();

        }

        sb.append(root.val);
        sb.append(",");
        serialize(root.left);
        serialize(root.right);
        return sb.toString();
    }

    TreeNode deSerialize(String str) {
        String[] nodes = str.split(",");

        return helper(nodes);
    }

    int index = -1;

    TreeNode helper(String[] str) {
        index++;
        if (!str[index].equals("#")) {
            TreeNode root = new TreeNode(Integer.parseInt(str[index]));
            root.left = helper(str);
            root.right = helper(str);
            return root;
        }
        return null;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(7);
        node.left.left = new TreeNode(1);

        System.out.println(new Main6().serialize(node));
    }

}
