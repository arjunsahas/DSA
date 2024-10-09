package com.arjun.leetcode.tree._124_bt_maximum_path_sum;

import com.arjun.leetcode.tree.TreeNode;

class Solution {

  int maxPath = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return root.val;
    maxPathSum1(root);
    return maxPath;
  }

  private int maxPathSum1(TreeNode root) {
    if (root == null) return 0;
    int leftValue = Math.max(maxPathSum1(root.left), 0);
    int rightValue = Math.max(maxPathSum1(root.right), 0);
    maxPath = Math.max(maxPath, root.val + leftValue + rightValue);
    return root.val + Math.max(leftValue, rightValue);
  }

  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    int maxPathSum = new Solution().maxPathSum(treeNode);
    System.out.println(maxPathSum);
  }
}
