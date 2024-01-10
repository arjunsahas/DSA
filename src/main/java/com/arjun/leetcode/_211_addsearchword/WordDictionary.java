package com.arjun.leetcode._211_addsearchword;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {
    private Node root = null;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node('*');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node last = null;
        Node parent = root;
        for (char c : word.toCharArray()) {
            Node child = buildTries(parent, c);
            parent = child;
            last = child;
        }
        last.setCompleteWord(true);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word.contains(".")) return wildcardSearch(word);
        return search(word, true);
    }

    private boolean search(String word, boolean partial) {
        boolean found = true;
        Node parent = root;
        for (char c : word.toCharArray()) {
            Node child = parent.getChild(c);
            if (child != null) {
                System.out.println(c);
                parent = child;
            } else {
                found = false;
                break;
            }
        }
        return found;
    }

    private boolean wildcardSearch(String word) {
        boolean found = true;
        Node parent = root;
        for (char c : word.toCharArray()) {
            Map<Character, Node> children = parent.getChildren();
            if (c == '.') {

            } else {
                for(char c1: children.keySet()) {
                    Node n = children.get(c1);
                    if(n != null) {

                    }
                }
            }

        }
        return found;
    }

    private Node buildTries(Node parent, char c) {
        Node child = checkIfPresent(parent, c);
        if (child == null) {
            child = parent.addChild(c);
            return child;
        } else return child;
    }

    private Node checkIfPresent(Node parent, char c) {
        return parent.getChild(c);
    }

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
            System.out.println("Added: " + c);
            return value;
        }

        public Node getChild(char c) {
            return children.get(c);
        }

        public Map<Character, Node> getChildren() {
            return children;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */