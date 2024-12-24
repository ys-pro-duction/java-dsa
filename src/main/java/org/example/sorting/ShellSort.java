package org.example.sorting;

import org.example.Main;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 6, 4, 1, 2, 9};
        Main.printIntArray(arr);
        shellSort(arr);
        Main.printIntArray(arr);
    }

    private static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j >= gap && arr[j - gap] > arr[j]) {
                    int tmp = arr[j - gap];
                    arr[j - gap] = arr[j];
                    arr[j] = tmp;
                    j -= gap;
                }
            }
        }
    }
}
