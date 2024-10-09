package com.arjun.leetcode.flatbt_to_ll;


class Solution {
  public void flatten(TreeNode root) {
    if (root == null) return;
    TreeNode start = new TreeNode(root.val);
    preorder(root, start);
    print(start);
  }

  private void preorder(TreeNode root, TreeNode start) {
    if (root == null) return;
    if (root.left != null) {
      TreeNode lastNode = endOfList(start);
      lastNode.right = new TreeNode(root.left.val);
      preorder(root.left, start);
    }
    if (root.right != null) {
      TreeNode lastNode = endOfList(start);
      lastNode.right = new TreeNode(root.right.val);
      preorder(root.right, start);
    }
  }

  private TreeNode endOfList(TreeNode start) {
    TreeNode lastNode = null;
    while (start != null) {
      lastNode = start;
      start = start.right;
    }
    return lastNode;
  }

  private void print(TreeNode start) {
    while (start != null) {
      System.out.println(start.val);
      start = start.right;
    }
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode two = new TreeNode(2);
    root.left = two;
    two.left = new TreeNode(3);
    two.right = new TreeNode(4);

    TreeNode five = new TreeNode(5);
    five.right = new TreeNode(6);
    root.right = five;
    new Solution().flatten(root);
  }
}
