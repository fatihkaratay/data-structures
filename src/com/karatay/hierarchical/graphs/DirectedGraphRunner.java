package com.karatay.hierarchical.graphs;

import java.util.List;

public class DirectedGraphRunner {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");

        System.out.println(graph.hasCycles());
    }
}
