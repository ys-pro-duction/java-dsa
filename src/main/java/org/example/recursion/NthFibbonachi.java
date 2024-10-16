package org.example.recursion;

public class NthFibbonachi {
    public static void main(String[] args) {
        int n = 6;
        System.out.println("Fibbonachi of "+n+" = "+fibbonachi(n));
    }

    private static int fibbonachi(int n) {
        if (n <= 1) return n;
        return fibbonachi(n-1)+fibbonachi(n-2);
    }
}
