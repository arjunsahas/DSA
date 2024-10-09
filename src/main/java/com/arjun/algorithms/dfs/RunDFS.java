package com.arjun.algorithms.dfs;

public class RunDFS {

  public static void main(String[] args) {
    Node a = new Node('A');
    Node b = new Node('B');
    Node c = new Node('C');
    Node d = new Node('D');
    Node e = new Node('E');
    Node f = new Node('F');
    Node g = new Node('G');
    Node h = new Node('H');

    //              A
    //            /
    //           B
    //         /  \
    //       C    H
    //      /  \
    //     D    E
    //         / \
    //        F   G

    DFS dfs = new DFS();
    dfs.connect(a, b);
    dfs.connect(b, c);
    dfs.connect(b, h);
    dfs.connect(c, d);
    dfs.connect(c, e);
    dfs.connect(e, f);
    dfs.connect(e, g);

    dfs.dfs(a);
  }
}
