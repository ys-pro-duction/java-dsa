package org.example.devide_and_conquer;


public class SortStringWithMergeSort {
    public static void main(String[] args) {
        String[] arr = {"meef", "maet", "ex", "fe", "a"};
        sort(arr, 0, arr.length - 1);
        for (String s : arr) {
            System.out.printf("\"%s\", ", s);
        }
    }

    private static void sort(String[] arr, int start, int end) {
        if (start == end) return;
        int mid = start + (end - start) / 2;
        sort(arr, start, mid); // left
        sort(arr, mid + 1, end); // right
//        int i = start;
//        int j = mid + 1;
//        while (i < j) {
//            int ii = arr[i].charAt(0);
//            int jj = arr[j].charAt(0);
//            if (ii > jj) {
//                String tmp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = tmp;
//            }
//            i++;
//        }
//        int i = start;
//        int j = mid + 1;
//        while (i <= mid && j <= end) {
//            String ii = arr[i];
//            String jj = arr[j];
//            for (int k = 0; k < Math.min(ii.length(), jj.length()); k++) {
//                if (ii.charAt(k) != jj.charAt(k)) if (ii.charAt(k) > jj.charAt(k)) {
//                    arr[i] = jj;
//                    arr[j] = ii;
//                    break;
//                } else break;
//            }
//            i++;
//        }
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (arr[i].charAt(0) > arr[j].charAt(0)) {
                String tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            i++;
        }

    }
}

