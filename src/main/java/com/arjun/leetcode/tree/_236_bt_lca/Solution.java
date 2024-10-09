package com.arjun.leetcode.tree._236_bt_lca;

import com.arjun.leetcode.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root != null) {
      if (root.left != null && root.right != null) {
        if (root.left.equals(p) && root.right.equals(q)) return root;
        else if (root.left.equals(q) && root.right.equals(p)) return root;
      }
    }

    return traversal(root, p, q);
  }

  private TreeNode traversal(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return root;
    List<Boolean> booleans1 = new ArrayList<>();
    List<Boolean> booleans2 = new ArrayList<>();
    findLCA(root.left, p, q, booleans1);
    findLCA(root.right, p, q, booleans2);

    if (booleans1.size() < booleans2.size()) return root.right;
    else return root.left;
  }

  private void findLCA(TreeNode root, TreeNode p, TreeNode q, List<Boolean> booleans) {

    if (root == null) return;
    if (root.val == p.val) {
      booleans.add(Boolean.TRUE);
    }
    if (root.val == p.val) {
      booleans.add(Boolean.TRUE);
    }
    findLCA(root.left, p, q, booleans);
    findLCA(root.right, p, q, booleans);
  }

  public static void main(String[] args) {
    TreeNode p = new TreeNode(4);
    TreeNode q = new TreeNode(3);
    TreeNode treeNode = new TreeNode(1, new TreeNode(2, p, new TreeNode(5)), q);
    TreeNode node = new Solution().lowestCommonAncestor(treeNode, p, q);
    System.out.println(node);

    treeNode =
        new TreeNode(
            1,
            new TreeNode(2, p, new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    node = new Solution().lowestCommonAncestor(treeNode, p, q);
    System.out.println(node);
  }
}
