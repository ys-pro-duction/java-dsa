package org.example.devide_and_conquer;

public class FindKeyInSortedRotatedArray {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 0, 1, 2, 3, 4, 5};
        int key = 1;
        System.out.println(findKey(arr, key, 0, arr.length - 1));
        System.out.println(count);
    }

    private static int findKey(int[] arr, int key, int start, int end) {
        if (start > end) return -1;
        count++;
        int mid = start + (end - start) / 2;
        if (arr[mid] == key) return mid;
//        if (key <= arr[mid]) {
//            if (key < arr[start]) return findKey(arr, key, start, mid);
//            else {
//                if (arr[start] < arr[mid]) return findKey(arr, key, mid, end);
//                else return findKey(arr, key, start, mid);
//            }
//        } else {
//            if (key > arr[start]) {
//                if (arr[start] < arr[mid]) return findKey(arr, key, mid, end);
//                else return findKey(arr, key, start, mid);
//            } else return findKey(arr, key, mid, end);
//        }
        if (arr[start] < arr[mid]) {
            if (key <= arr[mid] && key >= arr[start]) return findKey(arr, key, start, mid);
            else findKey(arr, key, mid + 1, end);
        } else {
            if (key >= arr[mid] && key <= arr[end]) return findKey(arr, key, mid, end);
            else return findKey(arr, key, start, mid - 1);
        }
        return -1;
    }
}
