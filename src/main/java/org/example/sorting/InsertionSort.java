package org.example.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 4, 1};
        System.out.println(Arrays.toString(arr));
        insertionSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Insertion sort O(n^2)
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentNum = arr[i];
            for (int j = i; j > 0; j--) {
                int prev = arr[j - 1];
                if (prev > currentNum) {
                    arr[j - 1] = arr[j];
                    arr[j] = prev;
                } else break;
            }
        }
    }

    public static void insertionSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentNum = arr[i];
            int pre = i - 1;
            while (pre >= 0 && currentNum < arr[pre]) {
                arr[pre + 1] = arr[pre];
                pre--;
            }
            arr[pre + 1] = currentNum;
        }
    }

}

