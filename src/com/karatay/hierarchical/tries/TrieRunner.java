package com.karatay.hierarchical.tries;

public class TrieRunner {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("can");

        System.out.println(trie);
    }
}
