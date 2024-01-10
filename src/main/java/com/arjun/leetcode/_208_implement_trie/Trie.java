package com.arjun.leetcode._208_implement_trie;

import java.util.HashMap;
import java.util.Map;

class Trie {
    
    private Node root = null;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node('*');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node last = null;
        Node parent = root;
        for(char c: word.toCharArray()) {
            Node child = buildTries(parent, c);
            parent = child;
            last = child;
        }
        last.setCompleteWord(true);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
       return search(word, false);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       return search(prefix, true);
    }
    
    private boolean search(String word, boolean partial) {
        boolean found = true;
        Node last = null;
        Node parent = root;
        for(char c: word.toCharArray()) {
            Node child = parent.getChild(c);
            if(child != null) {
                System.out.println(c);
                last = child;
                parent = child;;
            } 
            else {
                found = false;
                break;
            }
        }
        return partial ? found : found && last.isCompleteWord();
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