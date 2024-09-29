package org.example.bit_manipulation;

public class FastExponantial {
    public static void main(String[] args) {
        int a = 5;
        int n = 3;
        System.out.println(a+"^"+n+" = "+fastExponantial(a,n));
    }

    // Calculate n power of a mean a^n
    private static int fastExponantial(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans *= a;
            }
            a *= a;
            n = n >> 1;
        }
        return ans;
    }
}
