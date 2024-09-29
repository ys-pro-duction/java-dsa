package org.example.bit_manipulation;

public class IthBit {
    public static void main(String[] args) {
        int number = 8; // 1000
        int index = 1; //    ^
        System.out.println(index+"th bit in "+number+" is "+ithBitIs(number,index));
    }

    /**
     * First we shift binary to n time right side
     * 1000 >> 1 = 0100
     * then AND with 1 with it, we masked the first index
     * mean we made all bit's zero(0) except first index
     * 0100 & 0001(1) = 0000
     * 1011 & 0001(1) = 0001
     * 0000 = 0,
     * 0001 = 1
     */
    private static int ithBitIs(int number, int index) {
        return ((number >> index) & 1) > 0 ? 1 : 0;
    }
}