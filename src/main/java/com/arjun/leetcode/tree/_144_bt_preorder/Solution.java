package com.arjun.leetcode.tree._144_bt_preorder;

import com.arjun.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * <p>
 * Pre-order traversal is when root is "visited" first and then the left and the right children are visited after.
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversals = new ArrayList<>();
        if (root == null) return traversals;
        preorderTraversal(root, traversals);
        return traversals;
    }

    private void preorderTraversal(TreeNode root, List<Integer> traversals) {
        if (root == null) return;
        traversals.add(root.val);
        preorderTraversal(root.left, traversals);
        preorderTraversal(root.right, traversals);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        List<Integer> integers = new Solution().preorderTraversal(treeNode);
        System.out.println(integers);
    }
}