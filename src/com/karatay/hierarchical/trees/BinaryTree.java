package com.karatay.hierarchical.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    private int count = 0;
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

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);

        return list;
    }
    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (distance == 0) {
            list.add(root.value);
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void levelOrderTraverse() {
        levelOrderTraverse(root);
    }
    private void levelOrderTraverse(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            root = q.poll();
            System.out.print(root.value + " ");
            if (root.leftChild != null) q.add(root.leftChild);
            if (root.rightChild != null) q.add(root.rightChild);
        }
    }

    public int size() {
        return size(root);
    }
    private int size(Node root) {
        if (root == null) return 0;

        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public void printAncestors(int target) {
        printAncestors(root, target);
    }
    private boolean printAncestors(Node node, int target) {
        if (node == null)
            return false;

        if (node.value == target)
            return true;

        if (printAncestors(node.leftChild, target)
                || printAncestors(node.rightChild, target)) {
            System.out.print(node.value + " ");
            return true;
        }

        return false;
    }

    public int countLeaves() {
        return countLeaves(root);
    }
    private int countLeaves(Node root) {
        if (root == null) return 0;

        if (isLeafNode(root))
            count++;

        if (root.leftChild != null)
            countLeaves(root.leftChild);
        if (root.rightChild !=  null)
            countLeaves(root.rightChild);

        return count;
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
