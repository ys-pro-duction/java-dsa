package org.example.bit_manipulation;

public class CheckOddEven {
    public static void main(String[] args) {
        int number = 5;
        System.out.println(isEven(number) ? number + " is even" : number + " is odd");
    }

    /**
     * Checks if a number is even.
     * true if the number is even, false otherwise
     */
    private static boolean isEven(int number) {
        return (number & 1) == 0;
    }
}