package com.arjun.leetcode.tree._102_bt_levelorder;

import com.arjun.leetcode.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** */
class Solution {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    if (root == null) {
      return lists;
    }

    Queue<TreeNode> treeNodes = new ArrayDeque<>();
    treeNodes.offer(root);
    while (!treeNodes.isEmpty()) {
      List<Integer> integers = new ArrayList<>();
      List<TreeNode> nodes = new ArrayList<>();
      while (!treeNodes.isEmpty()) {
        TreeNode poll = treeNodes.poll();
        if (poll != null) nodes.add(poll);
      }
      for (TreeNode node : nodes) {
        integers.add(node.val);
        if (node.left != null) treeNodes.offer(node.left);
        if (node.right != null) treeNodes.offer(node.right);
      }
      lists.add(integers);
    }
    return lists;
  }

  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    List<List<Integer>> integers = new Solution().levelOrder(treeNode);
    for (List<Integer> list : integers) {
      System.out.println(list);
    }
  }
}
