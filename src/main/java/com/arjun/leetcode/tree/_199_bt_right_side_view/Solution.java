package com.arjun.leetcode.tree._199_bt_right_side_view;

import com.arjun.leetcode.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** https://leetcode.com/problems/binary-tree-right-side-view/ */
class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> integers = new ArrayList<>();
    if (root == null) {
      return integers;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      List<TreeNode> nodes = new ArrayList<>();
      while (!queue.isEmpty()) {
        TreeNode poll = queue.poll();
        if (poll != null) nodes.add(poll);
      }
      int i = 0;
      for (TreeNode node : nodes) {
        if (i == nodes.size() - 1) {
          integers.add(node.val);
        }
        i++;
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
    }
    return integers;
  }

  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    List<Integer> integers = new Solution().rightSideView(treeNode);
    System.out.println(integers);
  }
}
