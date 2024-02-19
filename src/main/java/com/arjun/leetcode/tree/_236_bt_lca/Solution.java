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

        traversal(root, p, q);
        return null;
    }

    private void traversal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;
        List<Boolean> booleans = new ArrayList<>();
        findLCA(root, p, q, booleans);

        boolean isLCA = booleans.size() == 2;
        if (isLCA) {
            traversal(root.left, p, q);
        } else {
            traversal(root.right, p, q);
        }
    }

    private void findLCA(TreeNode root, TreeNode p, TreeNode q, List<Boolean> booleans) {

        if (root == null) return;
        if (root.equals(p)) {
            booleans.add(Boolean.TRUE);
        }
        if (root.equals(q)) {
            booleans.add(Boolean.TRUE);
        }
        findLCA(root.left, p, q, booleans);
        findLCA(root.right, p, q, booleans);
    }
}