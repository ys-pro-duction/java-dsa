package org.example.bit_manipulation;

public class SetIthBit {
    public static void main(String[] args) {
        int num = 8;
        int i = 1;
        System.out.println("Set at "+i+" on "+num+" = "+setIthBit(num,i));
    }

    /**
     * First we do left shift to 1 to create mask of i th index
     * and then OR with num to make the i th index to 1
     * 0001 << 1 = 0010
     * 1000 | 0010 = 1010
     */
    private static int setIthBit(int num, int i){
        return (num | (1 << i));
    }
}
