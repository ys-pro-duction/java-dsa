package org.example.backtracking;

public class KeyPadCombination {
    public static void main(String[] args) {
        String[] key = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String inputDigit = "23";
        allCombination(key, inputDigit, 0, "");
    }

    private static void allCombination(String[] key, String inputDigit, int i, String result) {
        if (i >= inputDigit.length()) {
            System.out.print(result + ", ");
            return;
        }
        int digit = inputDigit.charAt(i) - '0' - 2;
        for (int j = 0; j < key[digit].length(); j++) {
            allCombination(key, inputDigit, i + 1, result + key[digit].charAt(j));
        }
    }
}
