package org.example.two_d_array;

import java.util.Arrays;
import java.util.function.Consumer;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {4, 5, 6, 5},
                {3, 0, 7, 6},
                {2, 9, 8, 7},
                {1, 0, 9, 8},
        };
//        int[][] arr = {{1, 2, 0},
//                {4, 3, 0},
//                {4, 3, 0},
//                {4, 3, 0},
//        };
        for (int[] i : arr) {
            System.out.println();
            for (int j : i) {
                System.out.print(j + " ");
            }
        }
        System.out.println();
        printSpiralArray(arr);
    }

    /**
     * Print 2D array items in spiral way
     * O(n)
     *
     * @param arr
     */
    public static void printSpiralArray(int[][] arr) {
        int top = 0;
        int start = 0;
        int end = arr[0].length - 1;
        int bottom = arr.length - 1;
        while (top <= bottom && start <= end) {
            for (int i = start; i <= end; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][end] + " ");
            }
            end--;
            for (int i = end; i >= start; i--) {
                System.out.print(arr[bottom][i] + " ");
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                System.out.print(arr[i][start] + " ");
            }
            start++;
        }
    }

}
