package com.karatay.hierarchical.tries;

import java.util.HashMap;

public class Trie {
    private static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value=" + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root) {
        System.out.print(root.value + " ");

        for (Node child : root.getChildren()) {
            traversePreOrder(child);
        }
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root) {
        for (Node child : root.getChildren()) {
            traversePostOrder(child);
        }
        System.out.print(root.value + " ");
    }
}
