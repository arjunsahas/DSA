package com.arjun.leetcode.tree._114_bt_to_linkedlist;

import com.arjun.leetcode.tree.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list
 *
 * <p>1 (r) 1 (r) 1 / \ \ \ 2 3 -----> 2 -------> 2 / \ / \ \ 4 5 4 5 4 \ \ 3 5 \ 3
 */
public class Solution {
  //    public TreeNode flatten(TreeNode root) {
  //        if (root == null) return root;
  //        TreeNode start = new TreeNode(Integer.MIN_VALUE);
  //        preOrderTraversal(root, start);
  //        return start;
  //    }

  public void flatten(TreeNode root) {
    while (root != null) {
      if (root.left != null) {
        TreeNode left = root.left;

        while (left.right != null) {
          left = left.right;
        }
        left.right = root.right;
        root.right = root.left;
        root.left = null;
      }
      root = root.right;
    }
  }

  //    private void preOrderTraversal(TreeNode root, TreeNode start) {
  //        if (root != null) {
  //            if (start != null && start.val == Integer.MIN_VALUE) {
  //                start.val = root.val;
  //            } else {
  //                TreeNode node = new TreeNode(root.val);
  //                if (start != null && start.right != null) {
  //                    start.right = node;
  //                }
  //
  //            }
  //            preOrderTraversal(root.left, start);
  //            preOrderTraversal(root.right, start);
  //        }
  //    }

  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    new Solution().flatten(treeNode);
    while (treeNode != null) {
      System.out.println(treeNode.val);
      treeNode = treeNode.right;
    }
  }
}
