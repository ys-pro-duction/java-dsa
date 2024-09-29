package org.example.bit_manipulation;

public class CountSetBits {
    public static void main(String[] args) {
        int num = 8;
        System.out.println("Set bit's in "+num+" is = "+countSetBits(num));
    }
    private static int countSetBits(int num){
        int count = 0;
        while (num > 0){
            if ((num & 1) == 1){
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}
