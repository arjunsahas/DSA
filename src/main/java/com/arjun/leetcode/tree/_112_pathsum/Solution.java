package com.arjun.leetcode.tree._112_pathsum;

import com.arjun.leetcode.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    return pathSum(root, targetSum, 0);
  }

  private boolean pathSum(TreeNode root, int targetSum, int sum) {
    if (root == null) return false;
    if (root.left == null && root.right == null) return sum + root.val == targetSum;
    return pathSum(root.left, targetSum, sum + root.val)
        || pathSum(root.right, targetSum, sum + root.val);
  }

  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    boolean hasPathSum = new Solution().hasPathSum(treeNode, 11);
    System.out.println(hasPathSum);
  }
}
