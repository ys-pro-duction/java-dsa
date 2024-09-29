package org.example.bit_manipulation;

public class SwapTwoNumWoutThird {
    public static void main(String[] args) {
        int one = 5;
        int two = 8;
        System.out.println("One = "+one+",  Two = "+two);
        swapNumWithoutThird(one,two);
    }
    private static void swapNumWithoutThird(int one, int two){
        // one 110
        // two 010
        one = one ^ two;
        // one = 100
        two = one ^ two;
        // two 110
        one = one ^ two;
        // one 010
        System.out.println("One = "+one+",  Two = "+two);
    }
}
