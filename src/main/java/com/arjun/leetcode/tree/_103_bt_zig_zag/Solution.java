package com.arjun.leetcode.tree._103_bt_zig_zag;

import com.arjun.leetcode.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
  public List<List<Integer>> zigZagView(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    if (root == null) {
      return lists;
    }
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    boolean flip = false;
    while (!queue.isEmpty()) {
      List<Integer> integers = new ArrayList<>();
      List<TreeNode> nodes = new ArrayList<>();
      while (!queue.isEmpty()) {
        TreeNode poll = queue.poll();
        if (poll != null) nodes.add(poll);
      }
      if (!flip) {
        for (int i = 0; i < nodes.size(); i++) {
          integers.add(nodes.get(i).val);
        }
      } else {
        for (int i = nodes.size() - 1; i >= 0; i--) {
          integers.add(nodes.get(i).val);
        }
      }
      for (int i = 0; i < nodes.size(); i++) {
        TreeNode treeNode = nodes.get(i);
        if (treeNode.left != null) queue.offer(treeNode.left);
        if (treeNode.right != null) queue.offer(treeNode.right);
      }
      flip = !flip;
      lists.add(integers);
    }
    return lists;
  }

  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    List<List<Integer>> lists = new Solution().zigZagView(treeNode);
    System.out.println(lists);

    treeNode =
        new TreeNode(
            1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
    lists = new Solution().zigZagView(treeNode);
    System.out.println(lists);

    treeNode =
        new TreeNode(
            3,
            new TreeNode(
                4,
                new TreeNode(-7, new TreeNode(-7), null),
                new TreeNode(-6, new TreeNode(-5, new TreeNode(-4), null), null)),
            new TreeNode(5));
    lists = new Solution().zigZagView(treeNode);
    System.out.println(lists);
  }
}
