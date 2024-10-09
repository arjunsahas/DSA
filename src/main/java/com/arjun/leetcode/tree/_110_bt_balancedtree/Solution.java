package com.arjun.leetcode.tree._110_bt_balancedtree;

import com.arjun.leetcode.tree.TreeNode;

class Solution {
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    return traversal(root);
  }

  private boolean traversal(TreeNode root) {
    if (root != null) {
      int heightDiff = height(root.left, 0) - height(root.right, 0);
      if (heightDiff > 1) return false;
      traversal(root.left);
      traversal(root.right);
    }
    return true;
  }

  private int height(TreeNode root, int height) {
    if (root == null) return height;
    int left = height(root.left, height + 1);
    int right = height(root.right, height + 1);
    return Math.max(left, right);
  }

  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    boolean isBalanced = new Solution().isBalanced(treeNode);
    System.out.println(isBalanced);

    treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), null);
    isBalanced = new Solution().isBalanced(treeNode);
    System.out.println(isBalanced);
  }
}
