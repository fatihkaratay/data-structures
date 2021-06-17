package com.karatay.hierarchical.avl_trees;

public class AVLTree {
    private class AVLNode {
        private int height;
        private int value;
        private AVLNode left;
        private AVLNode right;

        public AVLNode (int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + this.value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }
    private AVLNode insert(AVLNode root, int value) {
        if (root == null) return new AVLNode(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        root.height = Math.max(leftHeight, rightHeight) + 1;

        balance(root);

        return root;
    }

    private void balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.left) < 0) {
                System.out.println("Left rotate " + root.left.value);
            }
            System.out.println("Right rotate " + root.value);
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.right) > 0) {
                System.out.println("Right rotate " + root.right.value);
            }
            System.out.println("Left rotate " + root.value);
        }
    }



    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }
    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }
}
