package org.example.devide_and_conquer;

import org.example.Main;

public class MajorityElement {
    // elements tha apear more than n/2

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        mergeSort(arr, 0, arr.length - 1);
        Main.printIntArray(arr);
        System.out.println();
        System.out.println(arr[arr.length / 2]);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int[] ar = new int[end - start + 1];
        int idx = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                ar[idx++] = arr[i++];
            } else {
                ar[idx++] = arr[j++];
            }
        }
        while (i <= mid) {
            ar[idx++] = arr[i++];
        }
        while (j <= end) {
            ar[idx++] = arr[j++];
        }
        for (int k = start, l = 0; l < ar.length; k++, l++) {
            arr[k] = ar[l];
        }
    }
}
