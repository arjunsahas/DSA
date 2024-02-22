package com.arjun.leetcode.tree._145_bt_postorder.morris;

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
            if (current.right == null) {
                traversals.add(current.val);
                current = current.left;
            } else {
                TreeNode prev = current.right;
                while (prev.left != null && prev.left != current) {
                    prev = prev.left;
                }

                if(prev.left == null) {
                    traversals.add(current.val);
                    prev.left = current;
                    current = current.right;
                } else {
                    prev.left = null;
                    current = current.left;
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