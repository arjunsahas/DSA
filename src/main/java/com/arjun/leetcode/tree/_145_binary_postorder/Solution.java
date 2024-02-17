package com.arjun.leetcode.tree._145_binary_postorder;

import com.arjun.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 *  Post-order traversal is when left and right child nodes are "visited" before the root node.
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversals = new ArrayList<>();
        if (root == null) return traversals;
        postorderTraversal(root, traversals);
        return traversals;
    }

    private void postorderTraversal(TreeNode root, List<Integer> traversals) {
        if (root == null) return;
        postorderTraversal(root.left, traversals);
        postorderTraversal(root.right, traversals);
        traversals.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        List<Integer> integers = new Solution().postorderTraversal(treeNode);
        System.out.println(integers);
    }
}