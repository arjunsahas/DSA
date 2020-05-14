package com.arjun.algorithms.shortestpath;

public class Edge {
    private Node a;
    private Node b;
    private int weight;


    public Edge(Node a, Node b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }


    public Integer getWeight(Node a, Node b) {
        if (this.a == a && this.b == b) {
            return this.weight;
        }
        return null;
    }
}
