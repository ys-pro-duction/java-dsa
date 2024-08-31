package org.example.array;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(arr));
        reversed(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Reverse array without using new Array
     * O(n/2) = O(n)
     * @param arr
     */
    public static void reversed(int[] arr){
        int lastIndex = arr.length-1;
        for (int i = 0; i < arr.length/2; i++){
            int old = arr[i];
            arr[i] = arr[lastIndex-i];
            arr[lastIndex-i] = old;
        }
    }
}
