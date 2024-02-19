package com.arjun.leetcode.tree._100_bt_same_tree;

import com.arjun.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
 public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p != null && q != null) {
            // StringBuilder s = new StringBuilder();
            List<Boolean> b = new ArrayList<>();
            b.add(true);
            traversal(p, q, b);
            return b.get(0);
        } else return false;
    }

    private void traversal(TreeNode p, TreeNode q, List<Boolean> b) {
        if (p == null && q == null) return;
        else if (p != null && q == null) {
            b.set(0, b.get(0) && false);
            return;
        } else if (p == null && q != null) {
            b.set(0, b.get(0) && false);
            return;
        }
        traversal(p.left, q.left, b);
        b.set(0, b.get(0) && p.val == q.val);
        traversal(p.right, q.right, b);
    }
}