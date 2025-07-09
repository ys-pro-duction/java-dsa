package org.example.trie;

public class WordBreakProblem {
    public static void main(String[] args) {
        String[] arr = {"i", "like", "sam", "samsung", "mobile", "ice"};
        TrieDatNode trie = new TrieDatNode();
        TrieInsertByTuto.inerstInTrieByTuto(arr, trie);

        String key = "ilikesamsung";//
        System.out.println("Key has all words from array: "+wordBeakIsWordExist(trie,key));
    }

    private static boolean wordBeakIsWordExist(TrieDatNode trie, String key) {
        if (key.isEmpty()) return true;
        for (int i = 1; i <= key.length(); i++) {
            boolean firstPartInTrie = SearchInTrie.isStringInTrie(trie, key.substring(0, i), 0);
            if (firstPartInTrie) {
                if (wordBeakIsWordExist(trie, key.substring(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
