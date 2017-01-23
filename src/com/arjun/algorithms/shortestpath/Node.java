package com.arjun.algorithms.shortestpath;

import java.util.LinkedList;

public class Node {
  private final char label;
  private LinkedList<Node> children = new LinkedList<>();
  private boolean visited;
  private int distance;


  public int getDistance() {
    return distance;
  }


  public void setDistance(int distance) {
    this.distance = distance;
  }


  public Node(char label) {
    this.label = label;
  }


  public boolean isVisited() {
    return visited;
  }


  public void setVisited(boolean visited) {
    this.visited = visited;
  }


  public boolean add(Node e) {
    return children.add(e);
  }


  public LinkedList<Node> getChildren() {
    return children;
  }


  public char getLabel() {
    return label;
  }


  @Override
  public String toString() {
    return Character.toString(label);
  }

}