package com.arjun.leetcode.levelorder102;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Tuple {
    private final int level;
    private final TreeNode node;

    public Tuple(int level, TreeNode node) {
        this.level = level;
        this.node = node;
    }

    public TreeNode getNode() {
        return node;
    }

    public int getLevel() {
        return level;
    }
}


public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<Tuple> queue = new ArrayDeque<>();
        queue.offer(new Tuple(1, root));
        while (!queue.isEmpty()) {
            Tuple t = queue.removeFirst();
            System.out.println("Level : " + t.getLevel() + ", Val :" + t.getNode().val + "\n");
            if (t.getNode().left != null)
                queue.offer(new Tuple(t.getLevel() + 1, t.getNode().left));
            if (t.getNode().right != null)
                queue.offer(new Tuple(t.getLevel() + 1, t.getNode().right));
            List<Integer> integers = map.get(t.getLevel());
            if (integers != null) {
                integers.add(t.getNode().val);
            } else {
                List<Integer> list1 = new ArrayList<>();
                list1.add(t.getNode().val);
                map.put(t.getLevel(), list1);
            }
        }
        list.addAll(map.values());
        return list;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<Tuple> queue = new ArrayDeque<>();
        queue.offer(new Tuple(1, root));
        while (!queue.isEmpty()) {
            Tuple t = queue.removeFirst();
            System.out.println("Level : " + t.getLevel() + ", Val :" + t.getNode().val + "\n");
            if (t.getNode().left != null)
                queue.offer(new Tuple(t.getLevel() + 1, t.getNode().left));
            if (t.getNode().right != null)
                queue.offer(new Tuple(t.getLevel() + 1, t.getNode().right));
            List<Integer> integers = map.get(t.getLevel());
            if (integers != null) {
                integers.add(t.getNode().val);
            } else {
                List<Integer> list1 = new ArrayList<>();
                list1.add(t.getNode().val);
                map.put(t.getLevel(), list1);
            }
        }
        list.addAll(map.values());
        Collections.reverse(list);
        return list;
    }

    public int countNodes(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        int count = 0;
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode n = q.removeFirst();
            count++;
            if(root.left != null) q.offer(n.left);
            if(root.right != null) q.offer(n.right);
        }
        return count;
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Tuple> queue = new ArrayDeque<>();
        queue.offer(new Tuple(1, root));
        while (!queue.isEmpty()) {
            Tuple t = queue.removeFirst();
            if (t.getNode().left != null)
                queue.offer(new Tuple(t.getLevel() + 1, t.getNode().left));
            if (t.getNode().right != null)
                queue.offer(new Tuple(t.getLevel() + 1, t.getNode().right));
            Integer maxValue = map.get(t.getLevel());
            if (maxValue == null) {
                map.put(t.getLevel(), t.getNode().val);
            } else {
                System.out.println(t.getNode().val);
                if(t.getNode().val > maxValue) map.put(t.getLevel(), t.getNode().val);
            }
        }
        list.addAll(map.values());
        return list;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            List<List<Integer>> ret = new Solution().levelOrder(root);

            String out = int2dListToString(ret);

            System.out.print(out);

            ret = new Solution().levelOrderBottom(root);

            out = int2dListToString(ret);

            System.out.print(out);

            List<Integer> ret1 = new Solution().largestValues(root);

            System.out.print(ret1);

            int noOfNodes = new Solution().countNodes(root);

            System.out.print(noOfNodes);
        }
    }
}