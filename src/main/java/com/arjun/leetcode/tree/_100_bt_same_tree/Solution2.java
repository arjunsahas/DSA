package com.arjun.leetcode.tree._100_bt_same_tree;

import com.arjun.leetcode.tree.TreeNode;

class Solution2 {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p != null && q == null) return false;
    if (p == null && q != null) return false;

    return inorderTraversal(p, q);
  }

  private boolean inorderTraversal(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return true;
    else if (root1 != null && root2 == null) return false;
    else if (root1 == null && root2 != null) return false;
    else if (root1 != null && root2 != null)
      return root1.val == root2.val
          && inorderTraversal(root1.left, root2.left)
          && inorderTraversal(root1.right, root2.right);
    return true;
  }

  public static void main(String[] args) {
    TreeNode treeNode1 =
        new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    TreeNode treeNode2 =
        new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    boolean isSame = new Solution2().isSameTree(treeNode1, treeNode2);
    System.out.println(isSame);

    treeNode1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    treeNode2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), null);
    isSame = new Solution2().isSameTree(treeNode1, treeNode2);
    System.out.println(isSame);
  }
}
