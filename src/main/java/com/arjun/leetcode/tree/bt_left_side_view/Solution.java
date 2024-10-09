package com.arjun.leetcode.tree.bt_left_side_view;

import com.arjun.leetcode.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** https://leetcode.com/problems/binary-tree-right-side-view/ */
class Solution {
  public List<Integer> leftSideView(TreeNode root) {
    List<Integer> integers = new ArrayList<>();
    if (root == null) {
      return integers;
    }
    Queue<TreeNode> treeNodes = new ArrayDeque<>();
    treeNodes.offer(root);
    while (!treeNodes.isEmpty()) {
      List<TreeNode> nodes = new ArrayList<>();
      while (!treeNodes.isEmpty()) {
        TreeNode poll = treeNodes.poll();
        if (poll != null) nodes.add(poll);
      }
      int i = 0;
      for (TreeNode node : nodes) {
        if (i == 0) {
          integers.add(node.val);
        }
        i++;
        if (node.left != null) treeNodes.offer(node.left);
        if (node.right != null) treeNodes.offer(node.right);
      }
    }
    return integers;
  }

  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    List<Integer> integers = new Solution().leftSideView(treeNode);
    System.out.println(integers);
  }
}
