package org.example.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 4, 1};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Insertion sort O(n^2)
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int pre = i - 1;
            while (pre >= 0 && arr[pre] < curr) {
                arr[pre+1] = arr[pre];
                pre--;
            }
            arr[pre+1] = curr;
        }
    }

}

