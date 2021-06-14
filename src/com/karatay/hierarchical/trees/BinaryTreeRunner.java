package com.karatay.hierarchical.trees;

public class BinaryTreeRunner {
    public static void main(String[] args) {
        BinaryTree tree = constructTree();

        System.out.println(tree.countLeaves());

    }

    private static BinaryTree constructTree() {
        BinaryTree tree = new BinaryTree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(6);
        tree.insert(21);
        tree.insert(4);
        tree.insert(3);
        tree.insert(8);

        return tree;
    }
}
