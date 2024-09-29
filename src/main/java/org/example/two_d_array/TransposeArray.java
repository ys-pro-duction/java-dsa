package org.example.two_d_array;

import org.example.Main;

public class TransposeArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 0}, {4, 5, 6, 0}, {7, 8, 9, 0}, {0, 0, 0, 0}};
        Main.print2DArr(arr);
        /**
         * Transpose array
         *, Convert row to column
         */
        int[][] transposed = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                transposed[j][i] = arr[i][j];
            }
        }
        Main.print2DArr(transposed);

    }
}
