package com.arjun.algorithms.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Tries {

    static class Node {
        private char c;
        private Map<Character, Node> children = new HashMap<>();
        private boolean completeWord;

        Node(char c) {
            this.c = c;
        }

        public boolean isCompleteWord() {
            return completeWord;
        }

        public void setCompleteWord(final boolean isCompleteWord) {
            this.completeWord = isCompleteWord;
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
            return child;
        } else return child;
    }


    public static int searchTries(Node parent, String partialWord) {
        Node child = null;
        for (char c : partialWord.toCharArray()) {
            child = parent.getChild(c);
            if (child != null) {
                parent = child;
            } else {
                return 0;
            }
        }
        return searchPartial(child);
    }

    private static int searchPartial(final Node root) {
        Integer count = 0;
        boolean isCompleteWord = root.isCompleteWord();
        if (isCompleteWord) {
            count++;
        }

        Map<Character, Node> children = root.getChildren();
        if (children.size() > 0) {
            return searchPartial(children, count);
        } else {
            return count;
        }
    }

    private static int searchPartial(final Map<Character, Node> children, int count) {
        for (Node n : children.values()) {
            if (n.isCompleteWord()) {
                count++;
            }
            Map<Character, Node> children1 = n.getChildren();
            if (children1.size() > 0) {
                count = searchPartial(children1, count);
            }
        }
        return count;
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
                parent.setCompleteWord(true);
            }
            if (op.equals("find")) {
                result.add(searchTries(root, contact));
            }
        }
        for (int r : result)
            System.out.println(r);
    }
}
