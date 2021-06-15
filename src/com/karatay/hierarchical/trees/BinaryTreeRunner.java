package com.karatay.hierarchical.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeRunner {
    public static void main(String[] args) {
        Node root = getTree();

        BinaryTree tree = new BinaryTree();
        System.out.println("value: " + tree.LCA(root, root.newNode(6), root.newNode(7)));
//        tree.levelOrderTraverse(root);
    }

    private static Node getTree() {
        Node root = new Node();
        root = root.newNode(1);
        root.left = root.newNode(2);
        root.right = root.newNode(3);
        root.left.left = root.newNode(4);
        root.left.right = root.newNode(5);
        root.right.left = root.newNode(6);
        root.right.right = root.newNode(7);

        return root;
    }
    private static void levelOrderTraversal(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.print(root.value + " ");
            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);
        }
    }
    private static void inOrderTraverse(Node root) {
        if (root == null) return;

        inOrderTraverse(root.left);
        System.out.print(root.value + " ");
        inOrderTraverse(root.right);
    }

}
