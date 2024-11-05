package org.example.backtracking;

public class PrintAllSubsetOfString {
    public static void main(String[] args) {
        String name = "abc";
        printSubset(name, 0, "");
    }

    private static void printSubset(String str, int idx, String result) {
        if (idx == str.length()) {
            System.out.println(result);
            return;
        }
        printSubset(str, idx + 1, result + str.charAt(idx));
        printSubset(str, idx + 1, result);
    }
}
