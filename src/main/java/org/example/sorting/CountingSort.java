package org.example.sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {100, 84, 16, 72, 69, 96, 24, 62, 57, 56, 96, 24, 62, 57, 56, 89, 55, 49, 5, 57, 56, 89, 55, 49, 57, 86, 28, 9, 62, 57, 56, 89, 55, 49, 57, 86, 28, 95, 24, 6};
        int max = 100;
        System.out.println(Arrays.toString(arr));
        countingSort(arr, max);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Counting sort O(n^2)
     */
    public static void countingSort(int[] arr, int max) {
        int[] count = new int[max + 1];
        for (int j : arr) {
            count[j]++;
        }
        System.out.println(Arrays.toString(count));
        int countIndex = 0;
        int i = 0;
        while (i < arr.length) {
            if (count[countIndex] > 0) {
                arr[i] = countIndex;
                count[countIndex]--;
                i++;
            } else countIndex++;
        }
    }
}
