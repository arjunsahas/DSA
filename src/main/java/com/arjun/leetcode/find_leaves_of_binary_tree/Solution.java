package com.arjun.leetcode.find_leaves_of_binary_tree;

import java.util.*;

class Solution {
  public List<List<Integer>> findLeaves(TreeNode root) {
    if (root == null) return new ArrayList<>();
    if (root.left == null && root.right == null)
      return Collections.singletonList(new ArrayList<>(root.val));
    List<List<Integer>> integers = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode n = q.peek();
      if (hasChildren(n)) {
        if (n.left != null) {
          q.add(n);
        }
        if (n.right != null) {
          q.add(n);
        }
      }
      n = q.poll();
      stack.push(n);
    }
    while (!stack.empty()) {
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < stack.size(); i++) {
        TreeNode n = stack.peek();
        if (n.left == null && n.right == null) {
          list.add(stack.pop().val);
        } else break;
      }
      for (List<Integer> integerList : integers) {
        for (Integer integer : integerList) {
          TreeNode n = stack.peek();
          if (n.left != null && n.left.val == integer) {
            n.left = null;
          }
          if (n.right != null && n.right.val == integer) {
            n.right = null;
          }
        }
      }
      integers.add(list);
    }
    return integers;
  }

  private boolean hasChildren(TreeNode n) {
    return n.left != null || n.right != null;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode three = new TreeNode(3);
    TreeNode two = new TreeNode(2);

    root.right = three;
    root.left = two;

    two.left = new TreeNode(4);
    two.right = new TreeNode(5);

    new Solution().findLeaves(root);
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
}
