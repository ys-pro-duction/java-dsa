package org.example.questions;

import java.util.Arrays;

public class SortingAssignment {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};

        System.out.println("Original");
        System.out.println(Arrays.toString(arr));

        System.out.println("Bubble sort");
        int[] bubleArr = Arrays.copyOf(arr, arr.length);
        bubbleSortA(bubleArr);
        System.out.println(Arrays.toString(bubleArr));

        System.out.println("Selection sort");
        int[] selecArr = Arrays.copyOf(arr, arr.length);
        selectionSortA(selecArr);
        System.out.println(Arrays.toString(selecArr));

        System.out.println("Insertion sort");
        int[] inserArr = Arrays.copyOf(arr, arr.length);
        insertionSortA(inserArr);
        System.out.println(Arrays.toString(inserArr));

        System.out.println("Counting sort");
        int[] countArr = Arrays.copyOf(arr, arr.length);
        countingA(countArr);
        System.out.println(Arrays.toString(countArr));

    }

    private static void countingA(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        int[] coutIndexArr = new int[max + 1];
        for (int i : arr) {
            coutIndexArr[i]++;
        }
        int arrIndex = 0;
        int countIdex = 0;
        while (arrIndex < arr.length) {
            if (coutIndexArr[countIdex] > 0) {
                arr[arrIndex] = countIdex;
                coutIndexArr[countIdex]--;
                arrIndex++;
            } else {
                countIdex++;
            }
        }
    }

    private static void insertionSortA(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int pre = i - 1;
            while (pre >= 0 && arr[pre] > curr) {
                arr[pre + 1] = arr[pre];
                pre--;
            }
            arr[pre + 1] = curr;
        }
    }

    private static void selectionSortA(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    private static void bubbleSortA(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
