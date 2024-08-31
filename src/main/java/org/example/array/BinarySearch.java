package org.example.array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,56,100,236,354,458,598,632,785,845,912,1023};
        int key = 56;
        int result = binarySearch(arr,key);
        System.out.println("Key found at: "+result);
    }
    /**
     * This is binary search O(log n),
     * Binary search works only in SORTED ARRAY,
     * it return the index that is found in array
     */
    public static int binarySearch(int[] arr, int key){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int midIndex = (start+end)/2;
            int mid = arr[midIndex];
            if (mid == key) return midIndex;
            if (key > mid){
                start = midIndex+1;
            }else{
                end = midIndex-1;
            }
        }
        return -1;
    }
}
