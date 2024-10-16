package org.example.recursion;

public class BinaryStringProblem {
    public static void main(String[] args) {
        printBinaryStringWithoutBackOne(3, '0', "");
    }
//     * Prints all possible binary strings of length n without consecutive 1s.
    private static void printBinaryStringWithoutBackOne(int n, char c, String s) {
        if (n == 0) {
            System.out.println(s);
            return;
        }
        printBinaryStringWithoutBackOne(n-1, '0', s + '0');
        if (c != '1') printBinaryStringWithoutBackOne(n - 1, '1', s + '1');
    }
}
