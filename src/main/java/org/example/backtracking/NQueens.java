package org.example.backtracking;

import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        int N = 4;
        char[][] board = new char[N][N];
        for (char[] bo : board) {
            Arrays.fill(bo, 'x');
        }
        int placeCount = possiblePlaces(board, 0);
        System.out.println(placeCount);
    }

    private static int possiblePlaces(char[][] board, int row) {
        if (row == board.length) {
//            System.out.println("==================");
//            printBoard(board);
            return 1;
        }
        int res = 0;
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                res += possiblePlaces(board, row + 1);
                board[row][j] = 'x';
            }
        }
        return res;
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        // top left diagonal
        for (int left = col - 1, top = row - 1; left >= 0 && top >= 0; left--, top--) {
            if (board[top][left] == 'Q') return false;
        }
        // top
        for (int top = row - 1; top >= 0; top--) {
            if (board[top][col] == 'Q') return false;
        }
        // top right diagonal
        for (int left = col + 1, top = row - 1; left < board.length && top >= 0; left++, top--) {
            if (board[top][left] == 'Q') return false;
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
