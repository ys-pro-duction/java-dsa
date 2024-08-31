package org.example.array;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {54,98,4756,416,1,564,8,4,651,6,8,574,64,5};
        int key = 5;
        linearSearch(arr,key);
    }

    /**
     * NON-Recursive
     * its a linear search algorithm to find positon of key,
     * NON-Recursive O(n)
     */
    public static void linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key){
                System.out.println("Key "+key+" found at index: "+i);
            return;
            }
        }
        System.out.println("Key "+key+" not found");
    }

}
