package org.example.devide_and_conquer;

import org.example.Main;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {54, 564, 3, 12, 3, 5};
        quickSort(arr, 0, arr.length - 1);
//        partioning(arr, 0, arr.length - 1);
        Main.printIntArray(arr);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int piIndex = partioning(arr, start, end);
        quickSort(arr, start, piIndex - 1);
        quickSort(arr, piIndex + 1, end);
    }

    private static int partioning(int[] arr, int start, int end) {

        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= arr[end]) {
                j++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        j++;
        int tmp = arr[j];
        arr[j] = arr[end];
        arr[end] = tmp;
        return j;
    }
}
