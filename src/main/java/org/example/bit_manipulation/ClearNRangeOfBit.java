package org.example.bit_manipulation;

public class ClearNRangeOfBit {
    public static void main(String[] args) {
        int num = 10;
        int i = 2;
        int n = 4;
        System.out.println("Output = "+clearNRangeOfBit(num,i,n));
        System.out.println("Output = "+clearNRangeOfBit(num,4,2,null));
    }
    private static int clearNRangeOfBit(int num,int position, int number){
        int mask = (~0) << position+number;
        int mask2 = ~((~0) << position);
        int finalMask = mask | mask2;
        return  num & finalMask;
    }
    private static int clearNRangeOfBit(int num,int leftP,int rightP,String sNull){
        int mask  = ((~0) << leftP) | ~((~0) << rightP);
        return num & mask;
    }
}
