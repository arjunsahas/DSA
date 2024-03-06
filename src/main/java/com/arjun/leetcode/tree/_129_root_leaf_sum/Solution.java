package com.arjun.leetcode.tree._129_root_leaf_sum;

import com.arjun.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        List<Integer> integers = new ArrayList<>();
        dfs(root, "", integers);
        return integers.stream().reduce(Integer::sum).get();
    }

    private void dfs(TreeNode root, String num, List<Integer> integers) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            int e = Integer.parseInt(num + root.val);
            integers.add(e);
            return;
        }
        dfs(root.left, num + root.val, integers);
        dfs(root.right, num + root.val, integers);
    }

    public int sumNumbers1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        int sum = 0;
        sum = dfs1(root, "", sum);
        return sum;
    }

    private int dfs1(TreeNode root, String num, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            int e = Integer.parseInt(num + root.val);
            return sum + e;
        }
        sum = Math.max(dfs1(root.left, num + root.val, sum), sum);
        sum = Math.max(dfs1(root.right, num + root.val, sum), sum);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        int sumNumbers = new Solution().sumNumbers(treeNode);
        System.out.println(sumNumbers);

        treeNode = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        sumNumbers = new Solution().sumNumbers(treeNode);
        System.out.println(sumNumbers);

        treeNode = new TreeNode(1, new TreeNode(0), null);
        sumNumbers = new Solution().sumNumbers(treeNode);
        System.out.println(sumNumbers);

        treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        sumNumbers = new Solution().sumNumbers1(treeNode);
        System.out.println(sumNumbers);

        treeNode = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        sumNumbers = new Solution().sumNumbers1(treeNode);
        System.out.println(sumNumbers);

        treeNode = new TreeNode(1, new TreeNode(0), null);
        sumNumbers = new Solution().sumNumbers1(treeNode);
        System.out.println(sumNumbers);
    }
}