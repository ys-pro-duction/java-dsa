package org.example.questions;

import java.util.Arrays;

public class OneDArrayIntoTwoDArray {

    public static void main(String[] args) {
        int[] arr = {1,2};
        int m = 1;
        int n = 1;
        for (int[] item :
                construct2DArray(arr, m, n)) {
            System.out.print(Arrays.toString(item));
        }
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];
        if (m*n <= 1) return new int[][]{};
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[index];
                index++;
            }
        }
        return result;
    }
}
