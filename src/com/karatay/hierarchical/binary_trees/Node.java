package com.karatay.hierarchical.binary_trees;

public class Node {
    int value;
    Node left;
    Node right;

    public Node() {}

    public Node(int value) {
        this.value = value;
    }

    public Node newNode(int data) {
        Node node = new Node();
        node.value = data;
        node.left = node.right = null;

        return (node);
    }

    @Override
    public String toString() {
        return "Node=" + value;
    }
}
