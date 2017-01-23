package com.arjun.algorithms.shortestpath;

public class RunDjkistra {

  public static void main(String[] args) {
    Node a = new Node('A');
    Node b = new Node('B');
    Node c = new Node('C');
    Node d = new Node('D');
    Node e = new Node('E');

    DjkistraShortestPath shortestPath = new DjkistraShortestPath();
    shortestPath.connect(a, b, 4);
    shortestPath.connect(a, c, 1);
    shortestPath.connect(c, b, 2);
    shortestPath.connect(c, d, 4);
    shortestPath.connect(b, e, 4);
    shortestPath.connect(d, e, 4);

    shortestPath.shortestPath(a);
  }

}
