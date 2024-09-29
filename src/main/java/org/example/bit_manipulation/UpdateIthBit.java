package org.example.bit_manipulation;

public class UpdateIthBit {
    public static void main(String[] args) {
        int num = 10;
        int i = 3;
        int newBit = 0;
        System.out.println("Set "+newBit+" at "+i+" on "+num+" = "+setIthBit(num,i,newBit));
    }

    /**
     * First we clear the i th bit in this 2th
     * 1110(14) & (~(1 << 2)) = 1010
     * then create bit mask by shifting newBit by i th time
     * 0000(0) << 2 = 0000
     * 0001(1) << 2 = 0100
     * <p>
     * then apply mask on cleared bit value by OR
     * 1010 | 0000 = 1010    if set 0
     * 1010 | 0100 = 1110    if set 1
     */
    static int setIthBit(int num, int i, int newBit){
        int clearedIthBit = num & (~(1 << i));
        int mask = newBit << i;
        return clearedIthBit | mask;
    }
}
