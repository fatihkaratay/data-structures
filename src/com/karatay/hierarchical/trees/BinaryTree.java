package com.karatay.hierarchical.trees;

public class BinaryTree {
    private Node root;

    public void insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root) {
        if (root == null) return;

        System.out.print(root.value + " ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }
    private void traverseInOrder(Node root) {
        if (root == null) return;

        traverseInOrder(root.leftChild);
        System.out.print(root.value + " ");
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root) {
        if (root == null) return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.print(root.value + " ");
    }

    public int height() {
        return height(root);
    }
    private int height(Node root) {
        if (root == null)
            return -1;
        if (isLeafNode(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int minNode() {
        return minNode(root);
    }
    private int minNode(Node root) {
        if (isLeafNode(root)) {
            return root.value;
        }
        int left = minNode(root.leftChild);
        int right = minNode(root.rightChild);

        return Math.min(root.value, Math.min(left, right));
    }

    public int maxNode() {
        return maxNode(root);
    }
    private int maxNode(Node root) {
        if (isLeafNode(root))
            return root.value;
        int left = maxNode(root.leftChild);
        int right = maxNode(root.rightChild);

        return Math.max(root.value, Math.max(left, right));
    }

    // finding left most node or leaf
    public int leftMostNode() {
        return leftMostNode(root);
    }
    private int leftMostNode(Node root) {
        Node currentNode = root;
        Node lastNode = currentNode;
        while (currentNode != null) {
            lastNode = currentNode;
            currentNode = currentNode.leftChild;
        }

        return lastNode.value;
    }

    public int rightMostNode() {
        return rightMostNode(root);
    }
    private int rightMostNode(Node root) {
        Node currentNode = root;
        Node lastNode = currentNode;
        while (currentNode != null) {
            lastNode = currentNode;
            currentNode = currentNode.rightChild;
        }

        return lastNode.value;
    }

    public boolean isEqual(BinaryTree other) {
        return isEqual(root, other.root);
    }
    private boolean isEqual(Node first, Node second) {
        if (first == null && second == null)
            return true;
        if (first != null && second != null)
            return first.value == second.value &&
                    isEqual(first.leftChild, second.leftChild) &&
                    isEqual(first.rightChild, second.rightChild);

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.value > max || root.value < min)
            return false;
        return isBinarySearchTree(root.leftChild, min, root.value - 1) &&
                isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public void printNodesAtDistance(int distance) {
        printNodesAtDistance(root, distance);
    }
    private void printNodesAtDistance(Node root, int distance) {
        if (root == null)
            return;
        if (distance == 0 )
            System.out.print(root.value + " ");
        printNodesAtDistance(root.leftChild, distance - 1);
        printNodesAtDistance(root.rightChild, distance - 1);
    }

    private boolean isLeafNode(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }
    public void swapRoot() {
        Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }
}
