package org.example.bit_manipulation;

public class IsPowOfTwo {
    public static void main(String[] args) {
        int num = 8 ;
        System.out.println((isPowOfTwo(num) ? num+" is": num+" is not")+" power of 2.");
    }

    /**
     * if we do n & (n-1) and it return 0 then it's power of 2
     * n = 4 = 100;
     *n-1= 3 = 011;
     * 100(4) & 011(3) = 000(0)
     *
     */
    private static boolean isPowOfTwo(int num){
        return (num & (num-1)) == 0;
    }
}
