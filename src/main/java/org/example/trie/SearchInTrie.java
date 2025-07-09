package org.example.trie;

public class SearchInTrie {
    public static void main(String[] args) {
        String searchKey = "any";
        TrieDatNode trieDatNode = new TrieDatNode();
        createSampleTrie(trieDatNode);
        System.out.println(isStringInTrie(trieDatNode,searchKey,0));
    }

    private static void createSampleTrie(TrieDatNode trieDatNode) {
        String[] words = {"the", "a", "there", "their", "any", "thee"};
        TrieInsertByTuto.inerstInTrieByTuto(words, trieDatNode);
    }
    public static boolean isStringInTrie(TrieDatNode trie, String word, int idx){
        if (trie == null) return false;
        if (trie.eow && word.length() == idx) return true;
        if (word.length() == idx) return false;
        int currIdx = word.charAt(idx)-'a';
        return isStringInTrie(trie.data[currIdx], word, idx+1);
    }
}
