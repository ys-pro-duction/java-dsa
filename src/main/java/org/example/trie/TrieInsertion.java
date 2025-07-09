package org.example.trie;

import java.util.HashMap;

/**
 * BY MY METHOD
 */
class TrieNode extends HashMap<Character, TrieNode> {
    boolean isEnd;
}

public class TrieInsertion {
    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any", "thee" };
        TrieNode trieNode = new TrieNode();
        for (String w : words) {
            insert(trieNode, w, 0);
        }
        System.out.println(trieNode);
        printAllEnd(trieNode,"");

    }

    public static void printAllEnd(TrieNode trieNode, String s) {
        for (Character c : trieNode.keySet()) {
            if (trieNode.get(c).isEnd){
                System.out.println(s+c);
            }
            printAllEnd(trieNode.get(c), s+c);
        }
    }

    public static void insert(TrieNode trieNode, String string, int idx) {
        if (idx >= string.length()) return;
        char key = string.charAt(idx);
        if (!trieNode.containsKey(key)) {
            TrieNode tn = new TrieNode();
            trieNode.put(key, tn);
            if (idx == string.length() - 1) tn.isEnd = true;
        }
        insert(trieNode.get(key), string, idx + 1);

    }
}
