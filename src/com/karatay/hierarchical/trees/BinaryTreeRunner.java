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

        BinaryTree tree2 = new BinaryTree();
        tree2.insert(20);
        tree2.insert(10);
        tree2.insert(30);
        tree2.insert(6);
        tree2.insert(21);
        tree2.insert(4);
        tree2.insert(3);
        tree2.insert(8);

        tree1.swapRoot();

        System.out.println(tree1.isBinarySearchTree());
        System.out.println(tree2.isBinarySearchTree());


    }
}
