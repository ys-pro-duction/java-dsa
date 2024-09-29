package org.example.bit_manipulation;

public class ClearIthBit {
    public static void main(String[] args) {
        int num = 8;
        int i = 1;
        System.out.println(clearIthBit(num,i));
    }

    /**
     * First shift 1 to i time and get 1's complement(~) and do AND with num
     * 0001 << 1 = 0010
     *    ~0010  = 1101
     * 1010(10) & = 1101 = 1000(8)
     */
    private static int clearIthBit(int num, int i){
        return (num & (~(1 << i)));
    }
}
