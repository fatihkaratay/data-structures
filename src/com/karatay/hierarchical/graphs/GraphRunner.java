package com.karatay.hierarchical.graphs;

public class GraphRunner {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 2);

        graph.print();
    }
}
