package org.example.sorting;

import org.example.Main;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        quickSort(arr, 0, arr.length - 1);
//        partioning(arr, 0, arr.length - 1);
        Main.printIntArray(arr);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start > end) return;
        int idx = partionaling2(arr, start, end);
        quickSort(arr, start, idx - 1);
        quickSort(arr, idx + 1, end);
    }

    /**
     * Average Case  O(nlogn),
     * Wrost Case O(n^2)
     */
// Extra space
    private static int partionaling(int[] arr, int start, int end) {
        int[] less = new int[end - start + 1];
        int[] grater = new int[end - start + 1];
        int lessIdx = 0;
        int graterIdx = 0;
        int mainIdx = start;
        int last = arr[end];
        while (start < end) {
            if (arr[start] < last) less[lessIdx++] = arr[start++];
            else if (arr[start] > last) grater[graterIdx++] = arr[start++];
        }
        for (int i = 0; i <= lessIdx - 1; i++) {
            arr[mainIdx++] = less[i];
        }
        int returnIdx = mainIdx;
        arr[mainIdx++] = last;
        for (int i = 0; i <= graterIdx - 1; i++) {
            arr[mainIdx++] = grater[i];
        }
        return returnIdx;
    }

    private static int partionaling2(int[] arr, int start, int end) {
        int privot = arr[end];
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] > privot) {
                j++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        j++;
        int tmp = arr[j];
        arr[j] = arr[start];
        arr[start] = tmp;
        return j;
    }
}
