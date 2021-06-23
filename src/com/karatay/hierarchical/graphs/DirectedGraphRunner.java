package com.karatay.hierarchical.graphs;

public class DirectedGraphRunner {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.addEdge("A", "C");

        graph.traverseDFS_rec("A");
        System.out.println();
        graph.traverseDFS_itr("A");
    }
}