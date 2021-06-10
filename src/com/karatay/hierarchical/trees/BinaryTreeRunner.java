package com.karatay.hierarchical.trees;

public class BinaryTreeRunner {
    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();
        tree1.insert(7);
        tree1.insert(4);
        tree1.insert(9);
        tree1.insert(1);
        tree1.insert(6);
        tree1.insert(8);
        tree1.insert(10);

        tree1.levelOrderTraverse();

    }
}
