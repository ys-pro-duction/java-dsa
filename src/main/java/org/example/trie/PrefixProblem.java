package org.example.trie;

public class PrefixProblem {
    public static void insertInTrieByTuto(String[] words, TrieDatNode trieDatNode) {
        for (String word : words) {
            TrieDatNode t = trieDatNode;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (t.data[idx] == null) {
                    TrieDatNode tt = new TrieDatNode();
                    t.data[idx] = tt;
                }
                t = t.data[idx];
                t.count++;
                if (i == word.length() - 1) t.eow = true;
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"zebra", "dog", "duck", "dove"};
        TrieDatNode trie = new TrieDatNode();
        insertInTrieByTuto(arr,trie);
        printPrefixWords(arr,trie);
    }
    private static void printPrefixWords(String[] arr,TrieDatNode trie){
        for (String word : arr) {
            TrieDatNode t = trie;
            StringBuilder result = new StringBuilder();
            for (char c : word.toCharArray()) {
                result.append(c);
                t = t.data[c-'a'];
                if (t.count == 1) break;
            }
            System.out.println(result);
        }
    }

    static class TrieDatNode {
        TrieDatNode[] data;
        boolean eow = false;
        int count = 0;

        public TrieDatNode() {
            data = new TrieDatNode[26];
            for (int i = 0; i < 26; i++) {
                data[i] = null;
            }
        }

        public void print() {
            for (int i = 0; i < data.length; i++) {
                if (data[i] != null) {
                    System.out.print(((char) (i + 'a'))+""+data[i].count+" ");
                    data[i].print();
                }
            }
        }
    }
}
