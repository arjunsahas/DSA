package com.arjun.leetcode.mapsumpairs;

import java.util.HashMap;
import java.util.Map;

class MapSum {

  private Node root = null;

  /** Initialize your data structure here. */
  public MapSum() {
    root = new Node('*');
  }

  public void insert(String word, int val) {
    Node last = null;
    Node parent = root;
    for (char c : word.toCharArray()) {
      Node child = buildTries(parent, c, val);
      parent = child;
      last = child;
    }
    last.setCompleteWord(true);
  }

  public int sum(String prefix) {
    int sum = 0;
    Node last = null;
    Node parent = root;
    for (char c : prefix.toCharArray()) {
      Node child = parent.getChild(c);
      if (child != null) {
        System.out.println(c);
        last = child;
        sum += Integer.valueOf(child.getValue());
        parent = child;
      } else {
        break;
      }
    }
    while (last != null) {
      Map<Character, Node> children = last.getChildren();
      if (children.size() > 0) {
        for (Node node : children.values()) {}
      }
    }
    return last.getValue();
  }

  private int sum(Node node) {
    Map<Character, Node> children = node.getChildren();
    if (children.size() > 0) {
      for (Node n : children.values()) {
        sum(n);
      }
    }
    return 0;
  }

  private Node buildTries(Node parent, char c, int val) {
    Node child = checkIfPresent(parent, c);
    if (child == null) {
      child = parent.addChild(c, val);
      return child;
    } else {
      child.setValue(val);
      return child;
    }
  }

  private Node checkIfPresent(Node parent, char c) {
    return parent.getChild(c);
  }

  static class Node {
    private char c;
    private Map<Character, Node> children = new HashMap<>();
    private Integer value;
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

    public Node addChild(char c, int val) {
      Node value = new Node(c);
      children.put(c, value);
      value.setValue(val);
      System.out.println("Added: " + c);
      return value;
    }

    public Node getChild(char c) {
      return children.get(c);
    }

    public Map<Character, Node> getChildren() {
      return children;
    }

    public Integer getValue() {
      return value;
    }

    public void setValue(Integer val) {
      this.value = val;
    }
  }

  public static void main(String[] args) {
    MapSum obj = new MapSum();
    obj.insert("apple", 5);
    int param_2 = obj.sum("app");
    System.out.println(param_2);
    obj.insert("app", 3);
    param_2 = obj.sum("ap");
    System.out.println(param_2);
  }
}
