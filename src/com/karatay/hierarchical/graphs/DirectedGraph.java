package com.karatay.hierarchical.graphs;

import java.util.*;

public class DirectedGraph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        Node toNode = nodes.get(to);
        if (toNode == null )
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode); // this is for directed graph.
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            List<Node> targets = adjacencyList.get(source);
            if (!targets.isEmpty()) {
                System.out.println(source + " is connected to " + targets);
            }
        }
    }

    public void remove (String label) {
        Node node = nodes.get(label);
        if (node == null)
            return;
        for (var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);
        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDFS_rec(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;
        traverseDFS_rec(node, new HashSet<>());
    }
    private void traverseDFS_rec(Node root, Set<Node> visited) {
        System.out.print(root + " ");
        visited.add(root);

        for (var node : adjacencyList.get(root))
            if (!visited.contains(node))
                traverseDFS_rec(node, visited);
    }

    public void traverseDFS_itr(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (visited.contains(current))
                continue;

            System.out.print(current + " ");
            visited.add(current);

            for (var n : adjacencyList.get(current)) {
                if (!visited.contains(n))
                    stack.push(n);
            }
        }
    }

}
