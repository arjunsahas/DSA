package com.arjun.algorithms.problems;

import java.util.*;

public class Tries_1 {

    static class Node {
        private char c;
        private Map<Character, Node> children = new HashMap<>();
        private int size = 0;

        Node(char c) {
            this.c = c;
        }

        public int getSize() {
            return size;
        }

        public void setSize(final int size) {
            this.size = size;
        }

        public Node addChild(char c) {
            Node value = new Node(c);
            children.put(c, value);
            return value;
        }

        public Node getChild(char c) {
            return children.get(c);
        }

        public Map<Character, Node> getChildren() {
            return children;
        }
    }

    public static Node buildTries(Node parent, char c) {
        Node child = checkIfPresent(parent, c);
        if (child == null) {
            child = parent.addChild(c);
            child.setSize(child.getSize() + 1);
            return child;
        } else {
            child.setSize(child.getSize() + 1);
            return child;
        }
    }


    public static int searchTries(Node parent, String partialWord) {
        int size = 0;
        Node child = null;
        for (char c : partialWord.toCharArray()) {
            child = parent.getChild(c);
            if (child != null) {
                parent = child;
                size = child.getSize();
            } else {
                size = 0;
                break;
            }
        }
        return size;
    }

    private static Node checkIfPresent(Node parent, char c) {
        return parent.getChild(c);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> result = new ArrayList<>();
        Node root = new Node('*');
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) {
                Node parent = root;
                for (char c : contact.toCharArray()) {
                    parent = buildTries(parent, c);
                }
            }
            if (op.equals("find")) {
                result.add(searchTries(root, contact));
            }
        }
        for (int r : result)
            System.out.println(r);
    }
}
