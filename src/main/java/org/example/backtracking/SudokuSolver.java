package org.example.backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] suduko = {{0, 0, 8, 0, 0, 0, 0, 0, 0}, {4, 9, 0, 1, 5, 7, 0, 0, 2}, {0, 0, 3, 0, 0, 4, 1, 9, 0}, {1, 8, 5, 0, 6, 0, 0, 2, 0}, {0, 0, 0, 0, 2, 0, 0, 6, 0}, {9, 6, 0, 4, 0, 5, 3, 0, 0}, {0, 3, 0, 0, 7, 2, 0, 0, 4}, {0, 4, 9, 0, 3, 0, 0, 5, 7}, {8, 2, 7, 0, 0, 9, 0, 1, 3}};
//        int[][] suduko = {{0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        new Thread(() -> {
            sudokuSolve(suduko, 0, 0, suduko.length);
        }).start();
    }

    private static boolean sudokuSolve(int[][] sudoku, int i, int j, int length) {
        if (i >= length) {
            print2DArr(sudoku);
            return true;
        }
//        try {
//            Thread.sleep(20);
//        } catch (Exception e) {
//        }
//        clearScreen();
//        print2DArr(sudoku);
        int col = j + 1, row = i;
        if (col == length) {
            row = row + 1;
            col = 0;
        }

        if (sudoku[i][j] == 0) {
            for (int k = 1; k <= length; k++) {
                if (isSafe(sudoku, i, j, length, k)) {
                    sudoku[i][j] = k;
                    if (sudokuSolve(sudoku, row, col, length)) return true;
                }
            }
            sudoku[i][j] = 0;
            return false;
        } else return sudokuSolve(sudoku, row, col, length);
    }

    private static boolean isSafe(int[][] sudoku, int i, int j, int length, int k) {
        for (int l = 0; l < length; l++) {
            if (sudoku[i][l] == k) return false;
        }
        for (int l = 0; l < length; l++) {
            if (sudoku[l][j] == k) return false;
        }
        int top = ((i) / 3);
        int left = ((j) / 3);
        for (int l = left * 3; l < (left + 1) * 3; l++) {
            for (int m = top * 3; m < (top + 1) * 3; m++) {
                if (sudoku[m][l] == k) return false;
            }
        }
        return true;
    }

    public static void print2DArr(int[][] arr) {
        for (int[] i : arr) {
            System.out.println();
            for (int j : i) {
                System.out.print(j + ". ");
            }
        }
        System.out.println();
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec(new String[]{"clear"});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
