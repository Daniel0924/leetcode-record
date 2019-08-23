package com.ydh.offer;


public class Solution4 {

    /**
     * 根据前序遍历和中序遍历得到最终的二叉树
     * 前序遍历：根左右
     * 中序遍历：左根右
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstruBinaryTree(int[] pre, int[] in) {

        return helper(pre, in, 0, pre.length - 1, 0, in.length - 1);

    }

    public TreeNode helper(int[] pre, int[] in, int preStart, int preEnd,
                           int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;

        }

        TreeNode node = new TreeNode(pre[preStart]);
        int index = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (in[i] == pre[preStart]) {
                index = i;
                break;
            }
        }
        int len = index - inStart;
        node.left = helper(pre, in, preStart + 1, preStart + len, inStart, index - 1);
        node.right = helper(pre, in, preStart + len + 1, preEnd, index + 1, inEnd);
        return node;

    }
}
