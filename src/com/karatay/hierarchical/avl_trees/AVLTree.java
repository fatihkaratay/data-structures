package com.karatay.hierarchical.avl_trees;

public class AVLTree {
    private class AVLNode {
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
}
