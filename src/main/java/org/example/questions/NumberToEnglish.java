package org.example.questions;

public class NumberToEnglish {
    public static void main(String[] args) {
        int num = 2019;
        printEnglishNumber(num);
    }

    private static void printEnglishNumber(int num) {
        int first = num & 15;
        int remain = num >> 4;
        if (first == 0 && remain == 0) return;
        String out = switch (first) {
            case 0 -> "zero";
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "";
        };
        System.out.print(out + " ");
        printEnglishNumber(num >> 4);
    }
}
