package com.arjun.leetcode.minimum_depth_of_binary_tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return depth(1, root);
    }

    private int depth(int minDepth, TreeNode root) {
        if (root == null) return minDepth;
        if (root.left == null && root.right == null) return minDepth;

        // this steers the control through the tree path
        if (root.left == null && root.right != null) return depth(minDepth + 1, root.right);
        if (root.right == null && root.left != null) return depth(minDepth + 1, root.left);

        int leftMinDepth = depth(minDepth + 1, root.left);
        int rightMinDepth = depth(minDepth + 1, root.right);
        return Math.min(leftMinDepth, rightMinDepth);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}