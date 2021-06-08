package com.karatay.hierarchical.trees;

public class BinaryTree {
    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
    }
}
