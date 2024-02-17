package com.arjun.leetcode.tree._94_binary_inorder;

import com.arjun.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * <p>
 * In-order traversal is when the left child is "visited" first, then the root node and then the right child
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversals = new ArrayList<>();
        if (root == null) return traversals;
        inorderTraversal(root, traversals);
        return traversals;
    }

    private void inorderTraversal(TreeNode root, List<Integer> traversals) {
        if (root == null) return;
        inorderTraversal(root.left, traversals);
        traversals.add(root.val);
        inorderTraversal(root.right, traversals);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        List<Integer> integers = new Solution().inorderTraversal(treeNode);
        System.out.println(integers);
    }
}