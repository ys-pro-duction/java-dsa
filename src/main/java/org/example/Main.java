package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int arr[] = {1,2,34,56,8};
        List arrayList = List.of(1,23,465,6,4,165);
        printIntArray(arrayList);
        changeArray(arrayList);
        printIntArray(arrayList);
    }

    public static void changeArray(List arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i,(int) arr.get(i)*2);
        }
    }
    /**
     * Print array
     */
    public static void printIntArray(List array) {
        System.out.println();
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i)+" ");
        }
    }
}