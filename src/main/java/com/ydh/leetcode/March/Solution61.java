package com.ydh.leetcode.March;

public class Solution61 {

    public String Serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Serialize(root, sb);

        return sb.toString();
    }

    public void Serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val);
        sb.append(",");
        Serialize(root.left, sb);
        Serialize(root.right, sb);
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        String[] array = str.split(",");

        return Deserialize(array);

    }

    int index = -1;

    TreeNode Deserialize(String[] str) {
        index++;
        if (!str[index].equals("#")) {
            TreeNode node = new TreeNode(Integer.parseInt(str[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);

            return node;
        }
        return null;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        String res = new Solution61().Serialize(root);

        System.out.println(res);

    }

}
