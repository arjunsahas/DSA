package com.arjun.leetcode.pathsum;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return pathSum(root, targetSum, 0);
    }
    
    private boolean pathSum(TreeNode root, int targetSum, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return sum + root.val == targetSum;
        return pathSum(root.left, targetSum, sum + root.val) || pathSum(root.right, targetSum, sum + root.val);
    }

     public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}