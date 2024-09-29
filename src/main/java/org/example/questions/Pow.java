package org.example.questions;

public class Pow {
    public static void main(String[] args) {
        double[] x = {2.0000, 2.10000, 2.0000,2.00000};
        double[] expected = {1024.00000, 9.26100, 0.25000,0};
        int[] n = {10, 3, -2,-2147483648};
        for (int i = 0; i < x.length; i++) {
            System.out.println("expected: " + expected[i]);
            System.out.println("gotted: " + myPow(x[i], n[i]));
            System.out.println();
        }
    }

    public static double myPow(double x, int n) {
        double result = 1;
        if(n == 1) return x;
        if(n == 0) return 1;
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        result *= x;
        n--;
        while(n != 0){
            if((n % 2 ) == 1){
                result *= x;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }
}
