package org.example.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {7, 0, 2, 8, 6, 1, 9, 5, 3, 4};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Bubble sort O(n^2 / 2)
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length -1; i++) {
            if (i == 1) if (swaps == 0) return;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }
    }

    /**
     * Bubble sort O(n^2)
     *
     * @param arr
     */
    public static void bubbleSort2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
