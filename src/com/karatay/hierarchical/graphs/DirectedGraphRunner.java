package com.karatay.hierarchical.graphs;

import java.util.List;

public class DirectedGraphRunner {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");

        graph.addEdge("X", "A");
        graph.addEdge("X", "B");
        graph.addEdge("A", "P");
        graph.addEdge("B", "P");

        List<String> nodes = graph.topologicalSort("X");
        System.out.println(nodes);
    }
}
