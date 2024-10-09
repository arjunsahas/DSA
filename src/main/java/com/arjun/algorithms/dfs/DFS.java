package com.arjun.algorithms.dfs;

import java.util.LinkedList;
import java.util.Stack;

public class DFS {
  private Stack<Node> stack = new Stack<>();

  public DFS() {}

  public void connect(Node start, Node end) {
    start.add(end);
  }

  public void displayNode(Node n) {
    System.out.println(n.getLabel());
  }

  public void dfs(Node n) {
    n.setVisited(true);
    displayNode(n);
    stack.push(n);
    while (!stack.isEmpty()) {
      Node child = getUnvisitedNode(stack.peek());
      if (child == null) {
        stack.pop();
      } else {
        child.setVisited(true);
        displayNode(child);
        stack.push(child);
      }
    }
  }

  private Node getUnvisitedNode(Node n) {
    LinkedList<Node> children = n.getChildren();
    if (!children.isEmpty()) {
      for (int i = 0; i < children.size(); i++) {
        Node node = children.get(i);
        if (!node.isVisited()) {
          return node;
        }
      }
    }
    return null;
  }
}
