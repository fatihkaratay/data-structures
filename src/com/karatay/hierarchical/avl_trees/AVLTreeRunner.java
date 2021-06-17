package com.karatay.hierarchical.avl_trees;

public class AVLTreeRunner {
    public static void main(String[] args) {
        AVLTree tree= new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        System.out.println(tree);
    }
}
