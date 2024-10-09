package com.arjun.algorithms.bfs;

import com.arjun.algorithms.dfs.Node;

public class RunBFS {

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

    BFS bfs = new BFS();
    bfs.connect(a, b);
    bfs.connect(b, c);
    bfs.connect(b, h);
    bfs.connect(c, d);
    bfs.connect(c, e);
    bfs.connect(e, f);
    bfs.connect(e, g);

    bfs.bfs(a);
  }
}
