package org.example.backtracking;

import java.util.Arrays;


public class GridWays {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        char[][] board = new char[m][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        board[0][0] = '#';
        Thread t = new Thread(() -> {
            int ways = findWays(board, 0, 0, m - 1, n - 1);
            System.out.println("Possible ways = " + ways);
        });
        t.start();
        System.out.println("Math way =" + findWayMath(m, n));
//        Thread.currentThread().start();

    }

    private static int findWayMath(int m, int n) {
        return (factorial(m - 1 + n - 1) / (factorial(m - 1) * factorial(n - 1)));
    }

    private static int findWays(char[][] board, int i, int j, int m, int n) {
        clearScreen();
        printBoard(board, false);
        System.out.println("--------------------");
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (i == m && j == n) {
            clearScreen();
            printBoard(board, true);
            System.out.println("--------------------");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }
        int res = 0;
        if (i < m) {
            board[i + 1][j] = '#';
            res += findWays(board, i + 1, j, m, n);
            board[i + 1][j] = '.';
        }
        if (j < n) {
            board[i][j + 1] = '#';
            res += findWays(board, i, j + 1, m, n);
            board[i][j + 1] = '.';
        }
        return res;
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

    public static void printBoard(char[][] board, boolean power) {
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (power && chars[j] == '#') System.out.print('0');
                else System.out.print(chars[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int factorial(int i) {
        int factorial = 1;
        for (int j = 1; j <= i; j++) {
            factorial = factorial * j;
        }
        return factorial;
    }
}
