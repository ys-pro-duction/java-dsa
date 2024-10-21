package org.example.questions;

public class RecursionQ1 {
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key = 2;
        printAllIndicesOfKey(arr,0,key);
    }
    private static void printAllIndicesOfKey(int[] arr,int i,int key){
        if (i == arr.length) return;
        if (arr[i] == 2) System.out.print(i+" ");
        printAllIndicesOfKey(arr, ++i, key);
    }
}
