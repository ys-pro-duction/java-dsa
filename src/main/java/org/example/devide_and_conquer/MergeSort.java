package org.example.devide_and_conquer;

import org.example.Main;

import java.util.Arrays;

public class MergeSort {
    static int count1 = 0;
    static int count2 = 0;
    public static void main(String[] args) {
        int[] arr = {498, 496, 98, 98, 85, 14, 9, 9, 8, 8, 8, 7, 6, 6, 5, 4, 4, 4, 4, 4, 3, 2, 2, 2, 1, 0};
        int[] result = mergeSort(arr);
        Main.printIntArray(result);
        mergeSort2(arr,0, arr.length-1);
        Main.printIntArray(arr);
        System.out.printf("\n1: %d, 2: %d",count1,count2);
    }

    public static void mergeSort2(int[] arr, int start, int end) {
        if (end - start == 0) return;
        count2++;
        int mid = start + (end - start) / 2;
        mergeSort2(arr, start, mid);
        mergeSort2(arr, mid + 1, end);
        int i = 0;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            i++;
        }
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;
        count1++;
        int[] tmp = new int[arr.length];
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        left = mergeSort(left);
        right = mergeSort(right);
        int i = 0;
        int j = 0;
        int idx = 0;
        for (; i < left.length && j < right.length; idx++) {
            if (left[i] < right[j]) {
                tmp[idx] = left[i];
                i++;
            } else {
                tmp[idx] = right[j];
                j++;
            }
        }
        if (i < left.length) {
            for (; i < left.length; i++, idx++) {
                tmp[idx] = left[i];
            }
        }
        if (j < right.length) {
            for (; j < right.length; j++, idx++) {
                tmp[idx] = right[j];
            }
        }
        return tmp;
    }
}
