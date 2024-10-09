package com.arjun.leetcode.tree._100_bt_same_tree;

import com.arjun.leetcode.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

class Solution1 {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p != null && q == null) return false;
    if (p == null && q != null) return false;

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    inorderTraversal(p, list1);
    inorderTraversal(q, list2);

    boolean isSame = list1.size() == list2.size();
    if (isSame) {
      for (int i = 0; i < list1.size(); i++) {
        Integer integer = list1.get(i);
        Integer integer1 = list2.get(i);
        if (!integer.equals(integer1)) return false;
      }
    } else return isSame;
    return true;
  }

  private void inorderTraversal(TreeNode root, List<Integer> list) {
    if (root == null) return;
    inorderTraversal(root.left, list);
    list.add(root.val);
    inorderTraversal(root.right, list);
  }

  public static void main(String[] args) {
    TreeNode treeNode1 =
        new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    TreeNode treeNode2 =
        new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    boolean isSame = new Solution1().isSameTree(treeNode1, treeNode2);
    System.out.println(isSame);

    treeNode1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    treeNode2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), null);
    isSame = new Solution1().isSameTree(treeNode1, treeNode2);
    System.out.println(isSame);
  }
}
