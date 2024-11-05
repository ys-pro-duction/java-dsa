package org.example.backtracking;

public class KnightTour {
    private static int count = 1;

    public static void main(String[] args) {
        int N = 8;
        int xMove[] = {-1, 1, 2, 2, 1, -1, -2, -2};
        int yMove[] = {2, 2, 1, -1, -2, -2, 1, -1};
        int solution[][] = new int[8][8];
        fillNegetiveOne(solution, N);
        solution[0][0] = 0;
        solveKenightTour(solution, N, xMove, yMove);
    }

    private static void solveKenightTour(int[][] solution, int n, int[] xMove, int[] yMove) {
        new Thread(() -> {
            if (!knightTour(solution, n, 0, 0, xMove, yMove)) {
                System.out.println("No solution exist 😒");
            }
            print2DArr(solution);
        }).start();
    }

    private static boolean knightTour(int[][] solution, int n, int xIdx, int yIdx, int[] xMove, int[] yMove) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clearScreen();
        print2DArr(solution);
        if (count >= ((n * n))) return true;
        for (int j = 0; j < xMove.length; j++) {
            int nextX = xIdx + xMove[j];
            int nextY = yIdx + yMove[j];
            if (isSafe(solution, nextX, nextY)) {
                solution[nextX][nextY] = count++;
                if (knightTour(solution, n, nextX, nextY, xMove, yMove)) return true;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] solution, int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < solution.length && nextY < solution.length && solution[nextX][nextY] == -1;
    }

    private static void fillNegetiveOne(int arr[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = -1;
            }
        }
    }

    public static void print2DArr(int[][] arr) {
        for (int[] i : arr) {
            System.out.println();
            for (int j : i) {
                if (j > -1 && j < 10) System.out.print(" ");
                System.out.print(j + " ");
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
