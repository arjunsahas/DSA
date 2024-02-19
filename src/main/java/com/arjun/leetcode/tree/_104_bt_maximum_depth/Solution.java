package com.arjun.leetcode.tree._104_bt_maximum_depth;

import com.arjun.leetcode.tree.TreeNode;


class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Integer height = 0;
        return maxDepth(root, height);
    }

    private int maxDepth(TreeNode root, Integer height) {
        if (root == null) return height;
        int left = maxDepth(root.left, height + 1);
        int right = maxDepth(root.right, height + 1);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        int height  = new Solution().maxDepth(treeNode);
        System.out.println(height);
    }
}