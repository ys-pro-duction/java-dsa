package org.example.recursion;

public class XPowOfN {
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) {
        int x = 20;
        int n = 2;
        System.out.println("simple n^x " + simpleMethod(x, n));
        System.out.println("optimized n^x " + optimizedMethod(x, n));
        System.out.println(a + " " + b + " ");
    }

    private static int simpleMethod(int x, int n) {
        a++;
        if (x == 0) return 1;
        return n * simpleMethod(x - 1, n);
    }

    private static int optimizedMethod(int x, int n) {
        b++;
        if (x == 1) return n;
        int half = optimizedMethod(x / 2, n);
        int result = half*half;
        if (x % 2 == 1) result *= n;
        return result;
    }
}
