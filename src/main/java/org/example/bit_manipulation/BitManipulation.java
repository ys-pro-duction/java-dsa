package org.example.bit_manipulation;

public class BitManipulation {
    public static void main(String[] args) {
        and();
        or();
        xorOrNot();
        oneSComplement();
        leftShift();
        rightShift();
    }

    /**
     * 1&1=1 ,
     * 1&0=0,
     * 0&0=0,
     * both must be 1 to get 1
     */
    private static void and(){
        System.out.println("AND");
        int a = 3;// 011
        int b = 6;// 110
        System.out.println(a+"&"+b+" = "+(a&b)); // 010
    }

    /**
     * 1|1=1 ,
     * 1|0=1,
     * 0|0=0,
     * at least one is 1 to get 1
     */
    private static void or(){
        System.out.println("OR");
        int a = 3;// 011
        int b = 6;// 110
        System.out.println(a+"|"+b+" = "+(a|b)); // 111
    }
    /**
     * 1^1=0 ,
     * 1^0=1,
     * 0^0=0,
     * not equals to get 1
     */
    private static void xorOrNot(){
        System.out.println("XOR or NOT");
        int a = 3;// 011
        int b = 6;// 110
        System.out.println(a+"^"+b+" = "+(a^b)); // 101
    }

    private static void oneSComplement(){
        System.out.println("1's Complement");
        int a = 2;// 10
        System.out.println("~"+a+" = "+(~a)); // -11
        // a 1's complement (just invert bit)
        // 10 = -01
        // a 2's complement (just plus +1)
        // -01 = -11
    }

    /**
     * left shift bit to left and add 0's to right
     * 10 << 2 = 1000
     * 2          8
     * formula  = a*2^b
     */
    private static void leftShift(){
        System.out.println("Left shift");
        int a = 5;// 00101
        System.out.println(a+" << 2 = "+(a<<2)); //10100
    }
    /**
     * right shift bit to right and add 0's to left
     * 0110 >> 2 = 0001
     *   6          1
     *   formula = a / 2^b
     */
    private static void rightShift(){
        System.out.println("Right shift");
        int a = 6;// 0110
        System.out.println(a+" >> 2 = "+(a>>2)); // 0001
    }
}
