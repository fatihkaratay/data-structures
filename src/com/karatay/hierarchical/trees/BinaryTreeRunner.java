package com.karatay.hierarchical.trees;

public class BinaryTreeRunner {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        System.out.println(tree.find(7));
        System.out.println(tree.find(4));
        System.out.println(tree.find(9));
        System.out.println(tree.find(1));
        System.out.println(tree.find(6));
        System.out.println(tree.find(8));
        System.out.println(tree.find(10));
        System.out.println(tree.find(74));
    }
}
