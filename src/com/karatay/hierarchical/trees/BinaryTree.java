package com.karatay.hierarchical.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private int count = 0;

    public void insert(Node root, int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }
    }

    public boolean find(Node root, int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder(Node root) {
        if (root == null) return;

        System.out.print(root.value + " ");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    public void traverseInOrder(Node root) {
        if (root == null) return;

        traverseInOrder(root.left);
        System.out.print(root.value + " ");
        traverseInOrder(root.right);
    }

    public void traversePostOrder(Node root) {
        if (root == null) return;

        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.print(root.value + " ");
    }

    public int height(Node root) {
        if (root == null)
            return -1;
        if (isLeafNode(root))
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public int minNode(Node root) {
        if (isLeafNode(root)) {
            return root.value;
        }
        int left = minNode(root.left);
        int right = minNode(root.right);

        return Math.min(root.value, Math.min(left, right));
    }

    public int maxNode(Node root) {
        if (isLeafNode(root))
            return root.value;
        int left = maxNode(root.left);
        int right = maxNode(root.right);

        return Math.max(root.value, Math.max(left, right));
    }

    public int leftMostNode(Node root) {
        Node currentNode = root;
        Node lastNode = currentNode;
        while (currentNode != null) {
            lastNode = currentNode;
            currentNode = currentNode.left;
        }

        return lastNode.value;
    }

    public int rightMostNode(Node root) {
        Node currentNode = root;
        Node lastNode = currentNode;
        while (currentNode != null) {
            lastNode = currentNode;
            currentNode = currentNode.right;
        }

        return lastNode.value;
    }

    public boolean isEqual(Node first, Node second) {
        if (first == null && second == null)
            return true;
        if (first != null && second != null)
            return first.value == second.value &&
                    isEqual(first.left, second.left) &&
                    isEqual(first.right, second.right);

        return false;
    }

    public boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.value > max || root.value < min)
            return false;
        return isBinarySearchTree(root.left, min, root.value - 1) &&
                isBinarySearchTree(root.right, root.value + 1, max);
    }

    public void printNodesAtDistance(Node root, int distance) {
        if (root == null)
            return;
        if (distance == 0 )
            System.out.print(root.value + " ");
        printNodesAtDistance(root.left, distance - 1);
        printNodesAtDistance(root.right, distance - 1);
    }

    public void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (distance == 0) {
            list.add(root.value);
        }

        getNodesAtDistance(root.left, distance - 1, list);
        getNodesAtDistance(root.right, distance - 1, list);
    }

    public void levelOrderTraverse(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            root = q.poll();
            System.out.print(root.value + " ");
            if (root.left != null) q.add(root.left);
            if (root.right != null) q.add(root.right);
        }
    }

    public int size(Node root) {
        if (root == null) return 0;

        return 1 + size(root.left) + size(root.right);
    }

    public boolean printAncestors(Node root, int target) {
        if (root == null)
            return false;

        if (root.value == target)
            return true;

        if (printAncestors(root.left, target)
                || printAncestors(root.right, target)) {
            System.out.print(root.value + " ");
            return true;
        }

        return false;
    }

    public int countLeaves(Node root) {
        if (root == null) return 0;

        if (isLeafNode(root))
            count++;

        if (root.left != null)
            countLeaves(root.left);
        if (root.right !=  null)
            countLeaves(root.right);

        return count;
    }

    public boolean isSibling(Node root, int a, int b) {
        if (root == null)
            return false;
        if (root.left.value == a && root.right.value == b)
            return true;
        else if (root.left.value == b && root.right.value == a)
            return true;

        isSibling(root.left, a, b);
        isSibling(root.right, a, b);

        return false;
    }

    public Node LCA(Node root, Node a, Node b) {
        if (root == null) return null;
        if (root == a || root == b) return root;
        Node left = LCA(root.left, a, b);
        Node right = LCA(root.right, a, b);

        if (left != null && right != null)
            return root;
        else
            return left != null ? left : right;
    }

    private boolean isLeafNode(Node root) {
        return root.left == null && root.right == null;
    }
}
