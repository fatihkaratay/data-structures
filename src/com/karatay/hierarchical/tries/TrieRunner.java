package com.karatay.hierarchical.tries;

import java.util.List;

public class TrieRunner {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");

        var words = trie.findWords(null);
        System.out.println(words);
    }
}
