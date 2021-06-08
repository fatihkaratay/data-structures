package com.karatay.hierarchical.trees;

public class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node=" + value;
    }
}
