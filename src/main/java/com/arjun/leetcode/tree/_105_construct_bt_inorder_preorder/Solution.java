package com.arjun.leetcode.tree._105_construct_bt_inorder_preorder;

import com.arjun.leetcode.tree.TreeNode;
import java.util.Arrays;

/** https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ */
public class Solution {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length == 0) return null;
    TreeNode treeNode = new TreeNode();
    buildTree1(treeNode, preorder, inorder);
    return treeNode;
  }

  private void buildTree1(TreeNode treeNode, int[] preorder, int[] inorder) {
    if (preorder.length > 0) {
      int localRoot = preorder[0];
      treeNode.val = localRoot;
      int localRootPosInInorder = findPos(localRoot, inorder);
      int[] leftInOrder = Arrays.copyOfRange(inorder, 0, localRootPosInInorder);
      int[] rightInOrder = Arrays.copyOfRange(inorder, localRootPosInInorder + 1, inorder.length);
      int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftInOrder.length);
      if (leftPreorder.length > 0) {
        buildTree1(getLeft(treeNode), leftPreorder, leftInOrder);
      }
      int[] rightPreorder =
          Arrays.copyOfRange(
              preorder, 1 + leftInOrder.length, 1 + leftInOrder.length + rightInOrder.length);
      if (rightPreorder.length > 0) {
        buildTree1(getRight(treeNode), rightPreorder, rightInOrder);
      }
    }
  }

  private int findPos(int item, int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (item == array[i]) return i;
    }
    return -1;
  }

  private TreeNode getLeft(TreeNode root) {
    TreeNode left = new TreeNode();
    root.left = left;
    return left;
  }

  private TreeNode getRight(TreeNode root) {
    TreeNode right = new TreeNode();
    root.right = right;
    return right;
  }

  public static void main(String[] args) {
    TreeNode treeNode =
        new Solution().buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
    treeTraversal(treeNode);

    treeNode =
        new Solution()
            .buildTree(new int[] {10, 20, 40, 50, 30, 60}, new int[] {40, 20, 50, 10, 60, 30});
    treeTraversal(treeNode);
  }

  private static void treeTraversal(TreeNode node) {
    if (node != null) {
      treeTraversal(node.left);
      System.out.println(node.val);
      treeTraversal(node.right);
    }
  }
}
