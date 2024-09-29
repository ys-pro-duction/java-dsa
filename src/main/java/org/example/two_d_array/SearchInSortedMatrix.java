package org.example.two_d_array;

import org.example.Main;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {21, 29, 37, 48},
                {32, 33, 39, 50}
        };
        Main.print2DArr(arr);
        int key = 39;
        linearSearch(arr, key);
        linearSearch2(arr, key);
    }

    /**
     * Good way of search in sorted 2D array
     * O(n+m)
     * @param arr
     * @param key
     */
    private static void linearSearch2(int[][] arr, int key) {
        int row = 0;
        int col = arr[0].length-1;
        while (row < arr.length && col >= 0){
            int point = arr[row][col];
            if (point == key){
                System.out.println("Key found at: " + "[" + row + ", " + col + "]");
                return;
            } else if (point < key) {
                row++;
            }else col--;
        }
        System.out.println("Key not found");
    }

    /**
     * Linear search to find key O(n^2)
     *
     * @param arr
     * @param key
     */
    private static void linearSearch(int[][] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == key) {
                    System.out.println("Key found at: " + "[" + i + ", " + j + "]");
                }
            }
        }
        System.out.println("Key not found");
    }
}
