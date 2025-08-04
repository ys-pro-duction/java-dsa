package org.example.questions;

import org.example.Main;

public class Q73SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        Main.print2DArr(arr);
        setZeroes(arr);
        Main.print2DArr(arr);


    }

    public static void setZeroes(int[][] matrix) {
        int[] column = new int[matrix[0].length];
        int[] row = new int[matrix.length];
        for (int y = 0; y < row.length; y++) {
            for (int x = 0; x < column.length; x++) {
                if (matrix[y][x] == 0) {
                    row[y] = -1;
                    column[x] = -1;
                }
            }
        }
        for (int y = 0; y < column.length; y++) {
            for (int x = 0; x < row.length; x++) {
                if (column[y] == -1 || row[x] == -1) {
                    matrix[x][y] = 0;
                }
            }
        }
    }
}
