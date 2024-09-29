package org.example.bit_manipulation;

public class ClearLastNbits {
    public static void main(String[] args) {
        int num = 10;
        int n = 2;
        System.out.println("clear "+n+" bit's from "+num+" = "+clearLastNbits(num,n));
    }
    private static int clearLastNbits(int num,int n){
        int mask = (~0) << n;
        return num & mask;
    }
}
