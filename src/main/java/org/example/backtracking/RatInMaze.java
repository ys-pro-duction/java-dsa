package org.example.backtracking;

import org.example.Main;

class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        int[][] solution = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        findPath(maze, solution, 0, 0, maze.length - 1);
    }

    private static void findPath(int[][] maze, int[][] solution, int i, int j, int endIdx) {
        if (i == endIdx && j == endIdx) {
            Main.print2DArr(solution);
            return;
        }
//        // top
//        if (i > 0 && maze[i - 1][j] != 0) {
//            solution[i - 1][j] = 1;
//            findPath(maze, solution, i - 1, j, endIdx);
//            solution[i - 1][j] = 0;
//        }
        // bottom
        if (i < endIdx && maze[i + 1][j] != 0) {
            solution[i + 1][j] = 1;
            findPath(maze, solution, i + 1, j, endIdx);
            solution[i + 1][j] = 0;
        }
//        // left
//        if (j > 0 && maze[i][j - 1] != 0) {
//            solution[i][j - 1] = 1;
//            findPath(maze, solution, i, j - 1, endIdx);
//            solution[i][j - 1] = 0;
//        }
        // right
        if (j < endIdx && maze[i][j + 1] != 0) {
            solution[i][j + 1] = 1;
            findPath(maze, solution, i, j + 1, endIdx);
            solution[i][j + 1] = 0;
        }
    }
}