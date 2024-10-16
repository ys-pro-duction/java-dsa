package org.example.recursion;

public class CheckArraySorted {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println("is sorted = "+sorted(arr));
    }
    private static boolean sorted(int[] arr){
        return isArraySorted(arr,1, arr.length-1);
    }
    private static boolean isArraySorted(int[] arr,int curr,int end){
        if (arr[curr-1] > arr[curr]) return false;
        if (curr == end) return true;
        return isArraySorted(arr,++curr,end);
    }
}
