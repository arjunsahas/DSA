package com.arjun.leetcode.tree.bt_topview;

import com.arjun.leetcode.tree.TreeNode;
import java.util.*;

/**
 * The Tree is seen from the top. The intuition is that do a level order along with an awareness of
 * the width of the tree. If the width of the tree is larger, then add the nodes to result. Add null
 * also to count the width
 */
class Solution {

  public List<Integer> levelOrder(TreeNode root) {
    List<List<Integer>> lists = new ArrayList<>();
    if (root == null) {
      return new ArrayList<>();
    }

    int maxWidth = 0;
    Queue<TreeNode> treeNodes = new ArrayDeque<>();
    treeNodes.offer(root);
    while (!treeNodes.isEmpty()) {
      List<Integer> integers = new ArrayList<>();
      List<TreeNode> nodes = new ArrayList<>();
      while (!treeNodes.isEmpty()) {
        TreeNode poll = treeNodes.poll();
        nodes.add(poll);
      }
      boolean end = false;
      for (TreeNode node : nodes) {
        if (node.val == -1) {
          end = true;
        } else {
          end = false;
          break;
        }
      }
      if (end) break;

      int width = nodes.size();
      boolean skip = true;
      if (width > maxWidth) {
        maxWidth = width;
        skip = false;
      }

      for (int i = 0; i < nodes.size(); i++) {
        TreeNode node = nodes.get(i);
        if (node != null) {
          if (!skip && (i == 0 || i == nodes.size() - 1)) {
            if (node.val != -1) integers.add(node.val);
          }
          treeNodes.offer(Objects.requireNonNullElseGet(node.left, () -> new TreeNode(-1)));
          treeNodes.offer(Objects.requireNonNullElseGet(node.right, () -> new TreeNode(-1)));
        }
      }
      lists.add(integers);
    }

    int size = 0;
    for (List<Integer> list : lists) {
      size = Math.max(list.size(), size);
    }

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      for (int j = lists.size() - 1; j >= 0; j--) {
        List<Integer> list = lists.get(j);
        if (i <= list.size() - 1) result.add(list.get(i));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode treeNode =
        new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    List<Integer> integers = new Solution().levelOrder(treeNode);
    System.out.println(integers);

    treeNode =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), null));
    integers = new Solution().levelOrder(treeNode);
    System.out.println(integers);

    treeNode =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    integers = new Solution().levelOrder(treeNode);
    System.out.println(integers);
  }
}
