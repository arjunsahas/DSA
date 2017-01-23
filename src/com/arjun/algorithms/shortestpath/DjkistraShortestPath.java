package com.arjun.algorithms.shortestpath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class DjkistraShortestPath {
  private final PriorityQueue<Node> queue;
  private List<Edge> edges = new ArrayList<>();


  public DjkistraShortestPath() {
    queue = new PriorityQueue<>(10, new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        if(o1.getDistance() > o2.getDistance()) {
          return 1;
        } else if(o1.getDistance() < o2.getDistance()) {
          return -1;
        }
        return 0;
      }
    });
  }


  public void connect(Node start, Node end, int weight) {
    edges.add(new Edge(start, end, weight));
    start.add(end);
  }


  public void displayNode(Node n) {
    System.out.println(n.getLabel());
  }


  public void shortestPath(Node n) {
    n.setVisited(true);
    queue.add(n);
    n.setDistance(0);

    while(!queue.isEmpty()) {
      Node peek = queue.poll();
      displayNode(peek);
      LinkedList<Node> children = peek.getChildren();
      if(!children.isEmpty()) {
        for(int i = 0; i < children.size(); i++) {
          Node node = children.get(i);
          int newDistance = peek.getDistance() + getEdgeWeight(peek, node);
          if(node.getDistance() != -1) {
            queue.remove(node);
            node.setDistance(newDistance);
            queue.add(node);
          }
          if(node.getDistance() > newDistance) {
            node.setDistance(newDistance);
            queue.add(node);
          }
        }
      }
    }
  }


  public int getEdgeWeight(Node a, Node b) {
    for(Edge edge : edges) {
      Integer weight = edge.getWeight(a, b);
      if(weight != null) return weight;
    }
    return 0;
  }
}
