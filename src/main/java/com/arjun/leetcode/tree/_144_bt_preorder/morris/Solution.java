package com.arjun.leetcode.tree._144_bt_preorder.morris;

import com.arjun.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * <p>
 * In-order traversal is when the left child is "visited" first, then the root node and then the right child
 */
class Solution {
    public List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> traversals = new ArrayList<>();
        if (root == null) return traversals;
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                traversals.add(current.val);
                current = current.right;
            } else {
                TreeNode prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if(prev.right == null) {
                    prev.right = current;
                    traversals.add(current.val);
                    current = current.left;
                } else {
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return traversals;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        List<Integer> integers = new Solution().morrisTraversal(treeNode);
        System.out.println(integers);

        treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        integers = new Solution().morrisTraversal(treeNode);
        System.out.println(integers);
    }
}