package com.arjun.leetcode.search_in_bst;

// class Solution {
//    public TreeNode searchBST(TreeNode root, int val) {
//        if(root == null) return null;
//        if(root.val == val) return root;
//        else if (root.val < val) searchBST(root.left, val);
//        else if (root.val > val) searchBST(root.right, val);
//        return null;
//    }
// }
