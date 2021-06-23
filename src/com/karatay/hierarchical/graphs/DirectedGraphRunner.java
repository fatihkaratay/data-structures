package com.karatay.hierarchical.graphs;

public class DirectedGraphRunner {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.removeEdge("A", "D");
        graph.print();
    }
}
