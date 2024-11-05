package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Done prject running");
    }


    public static boolean mEquals(String s, Object anObject) {
        if (s == anObject) {
            return true;
        }
        return (anObject instanceof String aString) && Arrays.equals(s.getBytes(), aString.getBytes());
    }

    public static void changeArray(List arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, (int) arr.get(i) * 2);
        }
    }

    /**
     * Print array
     */
    public static void printIntArray(int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    public static void print2DArr(int[][] arr) {
        for (int[] i : arr) {
            System.out.println();
            for (int j : i) {
                System.out.print(j + " ");
            }
        }
        System.out.println();
    }

    public static void print2DArr(char[][] arr) {
        for (char[] i : arr) {
            System.out.println();
            for (char j : i) {
                System.out.print(j + " ");
            }
        }
        System.out.println();
    }
}