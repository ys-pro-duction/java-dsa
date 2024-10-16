package org.example.recursion;

public class SumNaturalNum {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Sum of "+n+" = "+sumNum(n));
    }
    private static int sumNum(int n){
        if (n == 1 ) return n;
        return n+sumNum(n-1);
    }
}
