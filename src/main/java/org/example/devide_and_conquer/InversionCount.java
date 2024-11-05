package org.example.devide_and_conquer;

import org.example.Main;

public class InversionCount {

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int inversionCount = mergeSort(arr, 0, arr.length - 1);
        Main.printIntArray(arr);
        System.out.println("\n>> " + inversionCount);
    }

    private static int mergeSort(int[] arr, int start, int end) {
        if (start >= end) return 0;
        int mid = start + (end - start) / 2;
        int left = mergeSort(arr, start, mid); // left
        int right = mergeSort(arr, mid + 1, end); // right
        return merge(arr, start, mid, end) + left + right;
    }

    private static int merge(int[] arr, int start, int mid, int end) {
        int inversionCount = 0;
        int i = start;
        int j = mid;
        int[] tmpArr = new int[end - start + 1];
        int idx = 0;
        while (i < mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tmpArr[idx++] = arr[i++];
            } else if (arr[i] > arr[j]) {
                tmpArr[idx++] = arr[j++];
                inversionCount += mid - i;
            }
        }
        while (i < mid) {
            tmpArr[idx++] = arr[i++];
        }
        while (j <= end) {
            tmpArr[idx++] = arr[j++];
        }
        for (int value : tmpArr) {
            arr[start++] = value;
        }
        return inversionCount;
    }

}
