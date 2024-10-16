package org.example.recursion;

public class FirstLastOccurance {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 3, 1};
        int key = 3;
        System.out.println("First occurance = " + firstOccurancePosition(arr, key, 0));
        System.out.println("Last occurance = " + lastOccurancePosition(arr, key, 0));
    }

    private static int firstOccurancePosition(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) return i;
        return firstOccurancePosition(arr, key, ++i);
    }

    private static int lastOccurancePosition(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int r = lastOccurancePosition(arr, key, i + 1);
        if (r != -1) return r;
        if (arr[i] == key) return i;
        return -1;
    }
}
