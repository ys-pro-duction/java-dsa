package org.example.trie;

class TrieDatNode {
    TrieDatNode[] data;
    boolean eow = false;

    public TrieDatNode() {
        data = new TrieDatNode[26];
        for (int i = 0; i < 26; i++) {
            data[i] = null;
        }
    }

    public void print() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                System.out.print(((char) (i+'a')));
                data[i].print();
            }
        }
    }
}

public class TrieInsertByTuto {
    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any", "thee" };
        TrieDatNode trieDatNode = new TrieDatNode();
        inerstInTrieByTuto(words,trieDatNode);
        trieDatNode.print();
    }
    public static void inerstInTrieByTuto(String[] words, TrieDatNode trieDatNode){
        for (String word : words) {
            TrieDatNode t = trieDatNode;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (t.data[idx] == null) {
                    TrieDatNode tt = new TrieDatNode();
                    t.data[idx] = tt;
                }
                t = t.data[idx];
                if (i == word.length() - 1) t.eow = true;
            }
        }
    }
}
