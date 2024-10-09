package com.arjun.leetcode.tree._236_bt_lca;

import com.arjun.leetcode.tree.TreeNode;

class Solution1 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left == null) return right;
    if (right == null) return left;
    return root;
  }

  public static void main(String[] args) {
    TreeNode p = new TreeNode(4);
    TreeNode q = new TreeNode(3);
    TreeNode treeNode = new TreeNode(1, new TreeNode(2, p, new TreeNode(5)), q);
    TreeNode node = new Solution1().lowestCommonAncestor(treeNode, p, q);
    System.out.println(node);

    q = new TreeNode(5);
    treeNode =
        new TreeNode(1, new TreeNode(2, p, q), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    node = new Solution1().lowestCommonAncestor(treeNode, p, q);
    System.out.println(node);
  }
}
