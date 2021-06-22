package com.karatay.hierarchical.tries;

public class TrieRunner {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("canada");
//        trie.insert("can");

        System.out.println(trie.contains("can"));
    }
}
