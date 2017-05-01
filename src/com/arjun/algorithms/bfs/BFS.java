package com.arjun.algorithms.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.arjun.algorithms.dfs.Node;

public class BFS {
    private Queue<Node> queue = new ConcurrentLinkedQueue<>();


    public BFS() {

    }


    public void connect(Node start, Node end) {
        start.add(end);
    }


    public void displayNode(Node n) {
        System.out.println(n.getLabel());
    }


    public void bfs(Node n) {
        n.setVisited(true);
        displayNode(n);
        queue.add(n);
        Node child = null;
        while (!queue.isEmpty()) {
            while ((child = getUnvisitedNode(queue.peek())) != null) {
                child.setVisited(true);
                displayNode(child);
                queue.add(child);
            }
            queue.remove();
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
