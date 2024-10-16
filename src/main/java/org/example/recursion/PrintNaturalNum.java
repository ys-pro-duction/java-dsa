package org.example.recursion;

public class PrintNaturalNum {
    public static void main(String[] args) {
        int n = 10;
        incresingOder(n);
        System.out.println();
        decresingOder(n);
    }

    private static void incresingOder(int n) {
        if (n < 0) return;
        incresingOder(n - 1);
        System.out.print(n + " ");
    }

    private static void decresingOder(int n) {
        if (n < 0) return;
        System.out.print(n + " ");
        decresingOder(n - 1);
    }
}
