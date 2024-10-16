package org.example.recursion;

public class FactorialCalculate {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Factorial of "+n+" = "+factorialOfN(n));
    }
    private static int factorialOfN(int n){
        if (n == 1) return n;
        return n*factorialOfN(n-1);
    }
}
